from typing import Any, Optional, List
from logic.Semantic.SymbolTable import SymbolTable
from logic.Semantic.SemanticProperties import SemanticWarning, Symbol, SemanticError
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
    AssignmentStatement,
    Expression,
    Identifier,
    Literal,
    BinaryExpression,
    UnaryExpression,
    GroupedExpression,
    ListLiteral,
    ListAccess,
    PrintStatement,
)


class SemanticAnalyzer:
    def __init__(self):
        self.symbol_table = SymbolTable()
        self.current_expected_return_type: Optional[str] = None  # For function return type checking (future)
        self.is_in_loop = False  # For break/continue checking (future)
        self.loop_depth = 0

    def get_scope_context(self) -> List[str]:
        """Return the current scope context for error/warning messages."""
        return self.symbol_table.get_scope_context()

    def visit(self, node: Any):
        method_name = f"visit_{type(node).__name__}"
        visitor = getattr(self, method_name, self.generic_visit)
        return visitor(node)

    def generic_visit(self, node: Any):
        for attr_name in dir(node):
            if not attr_name.startswith("_"):
                attr_value = getattr(node, attr_name)
                if isinstance(attr_value, Node):
                    self.visit(attr_value)
                elif isinstance(attr_value, list):
                    for item in attr_value:
                        if isinstance(item, Node):
                            self.visit(item)
        return "any"  # Default Type

    # --- Statement Visitors ---

    def visit_Program(self, node: Program):
        for stmt in node.statements:
            self.visit(stmt)
        return "void"

    def visit_BlockStatement(self, node: BlockStatement):
        self.symbol_table.enter_scope()
        for stmt in node.statements:
            self.visit(stmt)
        self.symbol_table.exit_scope()
        return "void"

    def visit_VariableDeclaration(self, node: VariableDeclaration):
        # 1. Analyze the right-hand side expression.
        self.visit(node.value)
        var_type = "any"

        # 2. Determine if it's a new declaration, shadowing, or re-assignment.
        symbol_in_current_scope = self.symbol_table.lookup_current_scope(node.name)

        if symbol_in_current_scope is not None:
            symbol_in_current_scope.type = var_type
            # pass  # Valid re-assignment.
        else:
            # IDENTIFIER is NOT in the current scope.
            # It could be in an outer scope (shadowing) or completely new.
            symbol_in_outer_scope = self.symbol_table.lookup(node.name)  # Checks all outer scopes too
            if symbol_in_outer_scope is not None:
                print(SemanticWarning.shadowing(node.name, node.line, node.column))
                # pass
            else:
                # Define the new symbol in the CURRENT scope.
                new_symbol = Symbol(name=node.name, type=var_type, line=node.line, column=node.column)
                try:
                    self.symbol_table.define(new_symbol)
                except Exception as e:
                    raise SemanticError.generic_error(
                        f"Internal error: Failed to declare variable: {e}",
                        node.line,
                        node.column,
                    )

    def visit_ConditionalStatement(self, node: ConditionalStatement):
        self.visit(node.if_branch.condition)

        # Create scope for if branch
        self.symbol_table.enter_scope()
        self.visit(node.if_branch.body)
        self.symbol_table.exit_scope()

        for elif_branch in node.elif_branches:
            self.visit(elif_branch.condition)

            # Create scope for elif branch
            self.symbol_table.enter_scope()
            self.visit(elif_branch.body)
            self.symbol_table.exit_scope()

        if node.else_branch:
            # Create scope for else branch
            self.symbol_table.enter_scope()
            self.visit(node.else_branch)
            self.symbol_table.exit_scope()

        return "void"

    def visit_WhileStatement(self, node: WhileStatement):
        self.visit(node.condition)

        old_is_in_loop = self.is_in_loop
        self.is_in_loop = True

        self.loop_depth += 1
        self.visit(node.body)  # Body is a BlockStatement
        self.loop_depth -= 1
        self.is_in_loop = old_is_in_loop
        return "void"

    def visit_BreakStatement(self, node: BreakStatement):
        if self.loop_depth <= 0:
            raise SemanticError.break_outside_loop(node.line, node.column)
        return "void"

    def visit_ContinueStatement(self, node: ContinueStatement):
        if self.loop_depth <= 0:
            raise SemanticError.continue_outside_loop(node.line, node.column)

        return "void"

    def visit_ReturnStatement(self, node: ReturnStatement):
        return_value_type = self.visit(node.value)

        # TODO: implement if its in a function (will do after function is implemented)

        if self.current_expected_return_type is not None:
            # In dynamic typing, we don't need to strictly enforce return types
            pass

        return "void"

    # --- Expression Visitors ---

    def visit_Identifier(self, node: Identifier):
        symbol = self.symbol_table.lookup(node.name)
        if symbol is None:
            raise SemanticError.undefined_variable(node.name, node.line, node.column, self.get_scope_context())

        return symbol.type

    def visit_Literal(self, node: Literal):
        # Could return a simple type string
        if isinstance(node.value, bool):
            return "boolean"
        if isinstance(node.value, (int, float)):
            return "number"
        if isinstance(node.value, str):
            return "string"
        return "any"

    def visit_BinaryExpression(self, node: BinaryExpression):
        left_type = self.visit(node.left)
        right_type = self.visit(node.right)

        # In a dynamically typed language, we just perform basic compatibility checks
        if node.operator in ["+", "-", "*", "/", "%"]:
            if node.operator == "+":
                # + can work for numbers or strings in many dynamic languages
                return "any"  # Could be number or string depending on runtime types
            else:
                # Other arithmetic operators typically expect numbers
                return "number"
        elif node.operator in [">", "<", ">=", "<=", "==", "!="]:
            # Comparison operators produce booleans
            return "boolean"
        elif node.operator in ["&&", "||"]:
            # Logical operators typically work with any values in dynamic languages
            return "boolean"

        return "any"

    def visit_UnaryExpression(self, node: UnaryExpression):
        operand_type = self.visit(node.operand)

        # In dynamic typing, operators might coerce types
        if node.operator == "!":
            return "boolean"
        elif node.operator in ["-", "+"]:
            return "number"

        return "any"

    def visit_GroupedExpression(self, node: GroupedExpression):
        return self.visit(node.expression)  # Type of grouped is type of inner

    def visit_ListLiteral(self, node: ListLiteral):
        # In a dynamically typed language, lists can contain mixed types
        for element in node.elements:
            self.visit(element)
        return "list"

    def visit_ListAccess(self, node: ListAccess):
        list_target_type = self.visit(node.list)
        index_type = self.visit(node.index)

        # Provide warnings but not errors for potential runtime issues
        if list_target_type != "list" and list_target_type != "any":
            print(SemanticWarning.possible_type_mismatch("list", list_target_type, node.line, node.column))

        return "any"  # Element type is unknown until runtime

    def visit_PrintStatement(self, node: PrintStatement):
        arg_types = []

        if not node.arguments:
            # raise error for empty print function if needed
            # self._error("Print statement requires at least one argument.", node)
            pass

        # Visit each argument expression to perform semantic checks on them
        for arg_expr_node in node.arguments:
            arg_type = self.visit(arg_expr_node)
            arg_types.append(arg_type)

        return "void"

    def visit_AssignmentStatement(self, node: AssignmentStatement):
        # 1. Check if the target is a valid L-value
        if not (isinstance(node.target, Identifier) or isinstance(node.target, ListAccess)):
            raise SemanticError.generic_error(
                f"Invalid target for assignment. Cannot assign to a {type(node.target).__name__}.",
                node.line,
                node.column,
            )

        # 2. Analyze the target (L-value)
        if isinstance(node.target, Identifier):
            # Check if variable exists in any scope
            symbol = self.symbol_table.lookup(node.target.name)
            if symbol is None:
                # Auto-declare variables on first assignment (dynamic language behavior)
                new_symbol = Symbol(
                    name=node.target.name,
                    type="any",  # Initial type
                    line=node.line,
                    column=node.column,
                )
                self.symbol_table.define(new_symbol)
                target_type = "any"
            else:
                target_type = symbol.type
        else:  # ListAccess
            # Verify both the list and index
            list_type = self.visit(node.target.list)
            index_type = self.visit(node.target.index)

            # Ensure we're accessing a list type
            if list_type != "list" and list_type != "any":
                print(SemanticWarning.possible_type_mismatch("list", list_type, node.line, node.column))

            # Verify index is a number
            if index_type != "number" and index_type != "any":
                print(SemanticWarning.possible_type_mismatch("number", index_type, node.line, node.column))

            target_type = "any"  # Element type is unknown in dynamic typing

        # 3. Analyze the value (R-value)
        value_type = self.visit(node.value)

        # 4. Update the symbol type if it's an identifier
        if isinstance(node.target, Identifier):
            symbol = self.symbol_table.lookup(node.target.name)
            if symbol:
                symbol.type = value_type
                pass

        return "void"  # Assignment statements don't have a type themselves
