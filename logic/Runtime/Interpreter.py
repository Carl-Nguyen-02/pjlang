from logic.Runtime.Environment import Environment
from logic.Runtime.RuntimeError import PjlangRuntimeError, ReturnSignal, BreakSignal, ContinueSignal, ErrorType
from typing import Any, Optional
import traceback


from logic.AST.ast import (  # Import all your AST nodes
    Node,
    Program,
    Statement,
    BlockStatement,
    VariableDeclaration,
    ConditionalBranch,
    ConditionalStatement,
    WhileStatement,
    ReturnStatement,
    BreakStatement,
    ContinueStatement,
    PrintStatement,
    AssignmentStatement,
    Expression,
    Identifier,
    Literal,
    BinaryExpression,
    UnaryExpression,
    GroupedExpression,
    ListLiteral,
    ListAccess,
)


class ExecutionContext:
    def __init__(self, name: str, line: Optional[int] = None, column: Optional[int] = None):
        self.name = name
        self.line = line
        self.column = column

    def __str__(self):
        if self.line is not None:
            return f"{self.name} at line {self.line}"
        return self.name


class Interpreter:
    def __init__(self):
        self.globals = Environment()
        self.environment = self.globals
        self.execution_stack = []
        self.function_call_depth = 0
        self._binary_ops = {
            "+": self._binary_add,
            "-": self._binary_subtract,
            "*": self._binary_multiply,
            "/": self._binary_divide,
            "%/": self._binary_floor_divide,
            "%": self._binary_modulo,
            "==": self._binary_equal,
            "!=": self._binary_not_equal,
            "<": self._binary_less,
            "<=": self._binary_less_equal,
            ">": self._binary_greater,
            ">=": self._binary_greater_equal,
            "&&": self._binary_and,
            "||": self._binary_or,
        }

    def _format_value(self, value: Any) -> str:
        if isinstance(value, bool):
            return str(value).lower()
        elif value is None:
            return "null"
        elif isinstance(value, list):
            elements = ", ".join(str(self._format_value(item)) for item in value)
            return f"[{elements}]"
        return str(value)

    def interpret(self, program_node: Program):
        final_result = None

        previous_environment = self.environment
        self.environment = self.globals

        try:
            # Execute the program
            final_result = self.visit(program_node)
            return final_result

        except ReturnSignal as ret_signal:
            return ret_signal.value

        except BreakSignal:
            raise PjlangRuntimeError(
                "Unexpected 'break' statement",
                line=Program.line if hasattr(Program, "line") else None,
                column=Program.column if hasattr(Program, "column") else None,
                execution_stack=self.execution_stack,
                error_type=ErrorType.BREAK_OUTSIDE_LOOP,
            )

        except ContinueSignal:
            raise PjlangRuntimeError(
                "Unexpected 'continue' statement",
                line=Program.line if hasattr(Program, "line") else None,
                column=Program.column if hasattr(Program, "column") else None,
                execution_stack=self.execution_stack,
                error_type=ErrorType.CONTINUE_OUTSIDE_LOOP,
            )

        except PjlangRuntimeError as e:
            # print(f"Runtime Error: {e.get_formatted_error()}")
            raise

        except Exception as e:
            print(f"Internal interpreter error: {e}")
            print(traceback.format_exc())
            raise PjlangRuntimeError.generic_error(f"Internal error: {str(e)}", execution_stack=self.execution_stack)

        finally:
            # Restore previous environment
            self.environment = previous_environment

    def visit(self, node: Any) -> Any:
        """Visit an AST node and return the result of its evaluation."""
        if node is None:
            return None

        method_name = f"visit_{type(node).__name__}"
        visitor = getattr(self, method_name, self.generic_visit)

        context = ExecutionContext(type(node).__name__, getattr(node, "line", None), getattr(node, "column", None))
        self.execution_stack.append(context)

        try:
            return visitor(node)
        finally:
            self.execution_stack.pop()

    def generic_visit(self, node: Any):
        """Default visitor for AST nodes without specific handlers."""
        if node is None:
            return None

        line = getattr(node, "line", None)
        col = getattr(node, "column", None)
        raise PjlangRuntimeError.unimplemented_feature(type(node).__name__, line, col)

    # --- Statement Execution ---

    def visit_Program(self, node: Program):
        result = None
        for stmt in node.statements:
            result = self.visit(stmt)
        return result

    def execute_block(self, statements: list[Statement], environment: Environment):
        previous_env = self.environment
        self.environment = environment
        try:
            for stmt in statements:
                self.visit(stmt)
        except ReturnSignal as ret_sig:
            raise ret_sig
        finally:
            self.environment = previous_env

    def visit_BlockStatement(self, node: BlockStatement):
        block_env = Environment(enclosing=self.environment)
        self.execute_block(node.statements, block_env)
        return None

    def visit_VariableDeclaration(self, node: VariableDeclaration):
        value = self.visit(node.value)

        # lexical scoping
        current_env = self.environment
        found = False

        # First check if variable exists in any enclosing scope
        while current_env is not None:
            if node.name in current_env.values:
                # Found the variable in this scope, update it
                current_env.values[node.name] = value
                found = True
                break
            current_env = current_env.enclosing

        # If not found in any scope, define it in the current scope
        if not found:
            self.environment.define(node.name, value)

        return None

    def visit_ConditionalStatement(self, node: ConditionalStatement):
        if_condition_val = self.visit(node.if_branch.condition)
        if self._is_truthy(if_condition_val):
            self.visit(node.if_branch.body)
            return None

        for elif_branch in node.elif_branches:
            elif_condition_val = self.visit(elif_branch.condition)
            if self._is_truthy(elif_condition_val):
                self.visit(elif_branch.body)
                return None

        if node.else_branch:
            self.visit(node.else_branch)
        return None

    def visit_WhileStatement(self, node: WhileStatement):
        while self._is_truthy(self.visit(node.condition)):
            try:
                # Ensure body is not None before visiting (just want to avoid infinite loop)
                if (node.body.statements != []) and (node.body.statements is not None):
                    self.visit(node.body)
                else:
                    raise PjlangRuntimeError(
                        "Empty body in while statement",
                        node.line if hasattr(node, "line") else None,
                        node.column if hasattr(node, "column") else None,
                        self.execution_stack,
                        ErrorType.GENERIC_ERROR,
                    )
            except ReturnSignal:
                raise
            except BreakSignal:
                break
            except ContinueSignal:
                continue
        return None

    def visit_BreakStatement(self, node: BreakStatement):
        if not self.is_in_loop:
            raise PjlangRuntimeError.break_outside_loop(node.line, node.column, self.execution_stack)
        raise BreakSignal()

    def visit_ContinueStatement(self, node: ContinueStatement):
        if not self.is_in_loop:
            raise PjlangRuntimeError.continue_outside_loop(node.line, node.column, self.execution_stack)
        raise ContinueSignal()

    def visit_ReturnStatement(self, node: ReturnStatement):
        if self.function_call_depth == 0:
            raise PjlangRuntimeError.return_outside_function(node.line, node.column, self.execution_stack)
        value = None
        if hasattr(node, "value") and node.value is not None:
            value = self.visit(node.value)
        raise ReturnSignal(value)

    def visit_PrintStatement(self, node: PrintStatement) -> None:
        try:
            evaluated_arguments = []
            for arg_expr_node in node.arguments:
                try:
                    arg_value = self.visit(arg_expr_node)
                    evaluated_arguments.append(arg_value)
                except Exception as e:
                    if not isinstance(e, PjlangRuntimeError):
                        e = PjlangRuntimeError.generic_error(
                            f"Error evaluating print argument: {str(e)}",
                            arg_expr_node.line,
                            arg_expr_node.column,
                            self.execution_stack,
                        )
                    raise e

            # Custom value format if needed
            output_strings = []
            for arg in evaluated_arguments:
                if isinstance(arg, list):
                    elements = ", ".join(str(self._format_value(item)) for item in arg)
                    output_strings.append(f"[{elements}]")
                elif isinstance(arg, bool):
                    output_strings.append(str(arg).lower())
                elif arg is None:
                    output_strings.append("null")
                else:
                    output_strings.append(str(arg))

            # Print all arguments
            print(*output_strings)

            return None
        except Exception as e:
            if not isinstance(e, PjlangRuntimeError):
                # Wrap non-language errors
                raise PjlangRuntimeError.generic_error(
                    f"Error in print statement: {str(e)}", node.line, node.column, self.execution_stack
                )
            raise

    # Expression

    def visit_Identifier(self, node: Identifier) -> Any:
        try:
            return self.environment.get(node.name)
        except PjlangRuntimeError:
            raise PjlangRuntimeError.name_error(node.name, node.line, node.column)

    def visit_Literal(self, node: Literal) -> Any:
        return node.value

    def visit_BinaryExpression(self, node: BinaryExpression) -> Any:
        if node.operator == "&&":
            left_val = self.visit(node.left)
            if not self._is_truthy(left_val):
                return left_val
            return self.visit(node.right)
        elif node.operator == "||":
            left_val = self.visit(node.left)
            if self._is_truthy(left_val):
                return left_val
            return self.visit(node.right)

        left_val = self.visit(node.left)
        right_val = self.visit(node.right)

        try:
            if node.operator in self._binary_ops:
                return self._binary_ops[node.operator](left_val, right_val, node)
            else:
                raise PjlangRuntimeError.unsupported_operation(
                    node.operator,
                    type(left_val).__name__,
                    type(right_val).__name__,
                    node.line,
                    node.column,
                    self.execution_stack,
                )
        except TypeError:
            raise PjlangRuntimeError.type_error(
                node.operator, type(left_val).__name__, node.line, node.column, self.execution_stack
            )

    def visit_UnaryExpression(self, node: UnaryExpression) -> Any:
        operand_val = self.visit(node.operand)
        op = node.operator

        if op == "!":
            return not self._is_truthy(operand_val)
        elif op == "-":
            if not isinstance(operand_val, (int, float)):
                raise PjlangRuntimeError.type_error(
                    "number", type(operand_val).__name__, node.line, node.column, self.execution_stack
                )
            return -operand_val
        elif op == "+":
            if not isinstance(operand_val, (int, float)):
                raise PjlangRuntimeError.type_error(
                    "number", type(operand_val).__name__, node.line, node.column, self.execution_stack
                )
            return operand_val
        else:
            raise PjlangRuntimeError.unsupported_operation(
                op, type(operand_val).__name__, None, node.line, node.column, self.execution_stack
            )

    def visit_GroupedExpression(self, node: GroupedExpression) -> Any:
        return self.visit(node.expression)

    def visit_ListLiteral(self, node: ListLiteral) -> Any:
        elements = []
        for expr_node in node.elements:
            elements.append(self.visit(expr_node))
        return elements

    def visit_ListAccess(self, node: ListAccess) -> Any:
        list_obj = self.visit(node.list)
        index_val = self.visit(node.index)

        if not isinstance(list_obj, list):
            raise PjlangRuntimeError.type_error(
                "list", type(list_obj).__name__, node.line, node.column, self.execution_stack
            )
        if not isinstance(index_val, int):
            raise PjlangRuntimeError.type_error(
                "integer", type(index_val).__name__, node.line, node.column, self.execution_stack
            )

        try:
            return list_obj[index_val]
        except IndexError:
            raise PjlangRuntimeError.index_error(index_val, len(list_obj), node.line, node.column, self.execution_stack)

    # Binary operation implementations
    def _binary_add(self, left, right, node) -> Any:
        if isinstance(left, (int, float)) and isinstance(right, (int, float)):
            return left + right
        elif isinstance(left, str) and isinstance(right, str):
            return left + right
        elif isinstance(left, list) and isinstance(right, list):
            return left + right  # List concatenation
        else:
            raise PjlangRuntimeError.unsupported_operation(
                "+", type(left).__name__, type(right).__name__, node.line, node.column, self.execution_stack
            )

    def _binary_subtract(self, left, right, node) -> Any:
        if not (isinstance(left, (int, float)) and isinstance(right, (int, float))):
            raise PjlangRuntimeError.type_error(
                "number", f"{type(left).__name__}, {type(right).__name__}", node.line, node.column, self.execution_stack
            )
        return left - right

    def _binary_multiply(self, left, right, node) -> Any:
        if not (isinstance(left, (int, float)) and isinstance(right, (int, float))):
            raise PjlangRuntimeError.type_error(
                "number", f"{type(left).__name__}, {type(right).__name__}", node.line, node.column, self.execution_stack
            )
        return left * right

    def _binary_divide(self, left, right, node) -> Any:
        if not (isinstance(left, (int, float)) and isinstance(right, (int, float))):
            raise PjlangRuntimeError.type_error(
                "number", f"{type(left).__name__}, {type(right).__name__}", node.line, node.column, self.execution_stack
            )
        if right == 0:
            raise PjlangRuntimeError.division_by_zero(node.line, node.column, self.execution_stack)
        return left / right

    def _binary_floor_divide(self, left, right, node) -> Any:
        if not (isinstance(left, (int, float)) and isinstance(right, (int, float))):
            raise PjlangRuntimeError.type_error(
                "number", f"{type(left).__name__}, {type(right).__name__}", node.line, node.column, self.execution_stack
            )
        if right == 0:
            raise PjlangRuntimeError.division_by_zero(node.line, node.column, self.execution_stack)
        return int(left // right)

    def _binary_modulo(self, left, right, node) -> Any:
        if not (isinstance(left, (int, float)) and isinstance(right, (int, float))):
            raise PjlangRuntimeError.type_error(
                "number", f"{type(left).__name__}, {type(right).__name__}", node.line, node.column, self.execution_stack
            )
        if right == 0:
            raise PjlangRuntimeError.division_by_zero(node.line, node.column, self.execution_stack)
        return left % right

    def _binary_equal(self, left, right, node) -> bool:
        return left == right

    def _binary_not_equal(self, left, right, node) -> bool:
        return left != right

    def _binary_less(self, left, right, node) -> bool:
        return left < right

    def _binary_less_equal(self, left, right, node) -> bool:
        return left <= right

    def _binary_greater(self, left, right, node) -> bool:
        return left > right

    def _binary_greater_equal(self, left, right, node) -> bool:
        return left >= right

    def _binary_and(self, left, right, node) -> Any:
        if not self._is_truthy(left):
            return left
        return right

    def _binary_or(self, left, right, node) -> Any:
        if self._is_truthy(left):
            return left
        return right

    def _is_truthy(self, value: Any) -> bool:
        if value is None:
            return False
        if value is False:
            return False
        if isinstance(value, bool):
            return value
        if isinstance(value, (int, float)):
            return value != 0
        if isinstance(value, (str, list)):
            return len(value) > 0
        return True

    def visit_AssignmentStatement(self, node: AssignmentStatement):
        # Get the value from the right side of assignment
        rhs_value = self.visit(node.value)

        # Handle different types of assignment targets
        target_node = node.target

        if isinstance(target_node, Identifier):
            # Case 1: Simple variable assignment (x = value)
            var_name = target_node.name

            # First try to assign to an existing variable in any scope
            if not self.environment.assign(var_name, rhs_value):
                self.environment.define(var_name, rhs_value)

        elif isinstance(target_node, ListAccess):
            # Case 2: List element assignment (list[index] = value)
            try:
                # Evaluate the list object and index
                list_object = self.visit(target_node.list)
                index = self.visit(target_node.index)

                # Type checking for list and index
                if not isinstance(list_object, list):
                    raise PjlangRuntimeError.type_error(
                        "list",
                        type(list_object).__name__,
                        target_node.list.line,
                        target_node.list.column,
                        self.execution_stack,
                    )

                if not isinstance(index, int):
                    raise PjlangRuntimeError.type_error(
                        "integer index",
                        type(index).__name__,
                        target_node.index.line,
                        target_node.index.column,
                        self.execution_stack,
                    )

                # Handle index out of bounds
                if index < 0 or index >= len(list_object):
                    raise PjlangRuntimeError.index_error(
                        index, len(list_object), target_node.line, target_node.column, self.execution_stack
                    )

                # Perform the assignment
                list_object[index] = rhs_value

            except Exception as e:
                # Catch any other errors during list assignment
                if not isinstance(e, PjlangRuntimeError):
                    raise PjlangRuntimeError.generic_error(
                        f"Error in list assignment: {str(e)}", node.line, node.column, self.execution_stack
                    )
                raise
        else:
            # Case 3: Invalid assignment target
            raise PjlangRuntimeError.generic_error(
                f"Invalid target for assignment: cannot assign to {type(target_node).__name__}",
                node.line,
                node.column,
                self.execution_stack,
            )

        return None

    def __str__(self):
        var_count = len(self.environment.values) if hasattr(self.environment, "values") else 0
        stack_depth = len(self.execution_stack)
        return f"Interpreter(variables={var_count}, stack_depth={stack_depth})"
