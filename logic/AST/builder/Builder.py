import logging

from generated.pjlangParser import pjlangParser
from generated.pjlangVisitor import pjlangVisitor
from logic.AST.ast import (  # Import all your AST node classes
    Node,
    Program,
    Statement,
    BlockStatement,
    VariableDeclaration,
    ConditionalBranch,
    ConditionalStatement,
    WhileStatement,
    ReturnStatement,
    PrintStatement,
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
)

logger = logging.getLogger(__name__)


class AstBuilder(pjlangVisitor):
    def _create_node_and_set_loc(self, node_class, ctx, *args, **kwargs):
        """
        Creates an AST node instance and sets its location information.
        `node_class`: The AST node class to instantiate (e.g., VariableDeclaration).
        `ctx`: The ANTLR context object for location info.
        `*args`, `**kwargs`: Arguments to pass to the `node_class` constructor.
        """
        # Instantiate the node with its specific constructor arguments
        node_instance = node_class(*args, **kwargs)

        # Manually set location fields (which are init=False in Node)
        if isinstance(node_instance, Node):  # Ensure it's a Node derivative
            if hasattr(ctx, "start") and ctx.start is not None:
                node_instance.line = ctx.start.line
                node_instance.column = ctx.start.column
            # Determine end position carefully
            stop_token = getattr(ctx, "stop", None)
            if stop_token is not None:
                node_instance.end_line = stop_token.line
                node_instance.end_column = stop_token.column + len(stop_token.text or "")
            elif hasattr(ctx, "start") and ctx.start is not None:  # Fallback if stop is not distinct
                node_instance.end_line = ctx.start.line
                node_instance.end_column = ctx.start.column + len(ctx.start.text or "")
        return node_instance

    def _normalize_antlr_collection(self, item):
        """Convert collections to lists for consistency"""
        if item is None:
            return []
        if not isinstance(item, list):  # Crucial: if item is a single context, wrap it
            return [item]
        return item

    def _process_string_literal(self, s: str) -> str:
        """Process string literals, handling escape sequences."""
        try:
            return s.encode("utf-8").decode("unicode_escape")
        except UnicodeDecodeError:
            # If there's a problem with escape sequences, fall back to the original
            logger.warning(f"Failed to process string escape sequences in: {s}")
            return s

    def _build_left_associative_binary_expr(self, left_child_ctx, operator_token, right_child_ctx, overall_ctx):
        """Helper to build binary expression nodes with proper location information."""
        try:
            left_ast = self.visit(left_child_ctx)
            right_ast = self.visit(right_child_ctx)

            # Handle different token types properly
            if hasattr(operator_token, "getText"):
                op_str = operator_token.getText()
            elif hasattr(operator_token, "text"):
                op_str = operator_token.text
            else:
                # Fallback - try to convert to string directly
                op_str = str(operator_token)
                logger.warning(f"Using fallback string conversion for operator: {op_str}")

            return self._create_node_and_set_loc(
                BinaryExpression, overall_ctx, left=left_ast, operator=op_str, right=right_ast
            )
        except Exception as e:
            logger.error(f"Error building binary expression: {e}")
            raise

    # Entry point
    def visitProgram(self, ctx: pjlangParser.ProgramContext):
        try:
            statements = [self.visit(stmt_ctx) for stmt_ctx in ctx.statement()]

            # For Program, pass only 'statements' to its __init__
            prog_node = self._create_node_and_set_loc(Program, ctx, statements=statements)

            # Adjust end_line/end_column for Program to account for EOF
            if ctx.EOF() and ctx.EOF().getSymbol():
                eof_symbol = ctx.EOF().getSymbol()
                prog_node.end_line = eof_symbol.line
                # EOF column might be after last char, or start of EOF token
                prog_node.end_column = eof_symbol.column + len(eof_symbol.text or "")
            elif statements:
                last_stmt = statements[-1]
                if last_stmt.end_line is not None:  # Check if last_stmt has location
                    prog_node.end_line = last_stmt.end_line
                    prog_node.end_column = last_stmt.end_column
            return prog_node
        except Exception as e:
            logger.error(f"Error building Program AST: {e}")
            raise

    # Statements
    def visitVarDeclStmt(self, ctx: pjlangParser.VarDeclStmtContext):
        try:
            decl_ctx = ctx.variableDeclaration()
            name = decl_ctx.name.text
            value_expr_ast = self.visit(decl_ctx.value)
            return self._create_node_and_set_loc(VariableDeclaration, decl_ctx, name=name, value=value_expr_ast)
        except Exception as e:
            logger.error(f"Error building VariableDeclaration AST: {e}")
            raise

    def visitCondStmt(self, ctx: pjlangParser.CondStmtContext):
        try:
            cond_stmt_ctx = ctx.conditionalStatement()

            if_cond_ast = self.visit(cond_stmt_ctx.if_cond)
            if_body_ast = self.visit(cond_stmt_ctx.if_body)
            # Use if_cond context for start, if_body context for end for better span of ConditionalBranch
            if_branch_ctx_span = type(
                "obj", (object,), {"start": cond_stmt_ctx.if_cond.start, "stop": cond_stmt_ctx.if_body.stop}
            )()
            if_branch = self._create_node_and_set_loc(
                ConditionalBranch, if_branch_ctx_span, condition=if_cond_ast, body=if_body_ast
            )

            elif_branches_ast = []
            if cond_stmt_ctx.elif_conds:
                for i in range(len(cond_stmt_ctx.elif_conds)):
                    elif_cond_ast = self.visit(cond_stmt_ctx.elif_conds[i])
                    elif_body_ast = self.visit(cond_stmt_ctx.elif_bodies[i])
                    elif_branch_ctx_span = type(
                        "obj",
                        (object,),
                        {"start": cond_stmt_ctx.elif_conds[i].start, "stop": cond_stmt_ctx.elif_bodies[i].stop},
                    )()
                    branch = self._create_node_and_set_loc(
                        ConditionalBranch, elif_branch_ctx_span, condition=elif_cond_ast, body=elif_body_ast
                    )
                    elif_branches_ast.append(branch)

            else_branch_ast = None
            if cond_stmt_ctx.else_body:
                else_branch_ast = self.visit(cond_stmt_ctx.else_body)

            return self._create_node_and_set_loc(
                ConditionalStatement,
                cond_stmt_ctx,
                if_branch=if_branch,
                elif_branches=elif_branches_ast,
                else_branch=else_branch_ast,
            )
        except Exception as e:
            logger.error(f"Error building ConditionalStatement AST: {e}")
            raise
    
    def visitBlockStatement(self, ctx: pjlangParser.BlockStatementContext):
        statements_ast = []
        

        if ctx.s: # 's' is the label from 's+=statement*'
            for i, stmt_child_ctx in enumerate(ctx.s): # stmt_child_ctx is a StatementContext
                stmt_ast = self.visit(stmt_child_ctx) # This will call visitVarDeclStmt, visitCondStmt etc.
                if stmt_ast:
                    statements_ast.append(stmt_ast)
                            
        created_block_ast = self._create_node_and_set_loc(BlockStatement, ctx, 
                                                          statements=statements_ast)
        return created_block_ast
    
    def visitBlockStmt(self, ctx: pjlangParser.BlockStmtContext):
        block_rule_ctx = ctx.blockStatement()  # Get the actual BlockStatementContext
        return self.visit(block_rule_ctx)

    def visitWhileStmt(self, ctx: pjlangParser.WhileStmtContext):
        try:
            while_stmt_ctx = ctx.whileStatement()
            condition_ast = self.visit(while_stmt_ctx.condition)

            # Debug the body parsing
            logger.debug(f"Processing while statement body at line {while_stmt_ctx.start.line}")
            if hasattr(while_stmt_ctx, "body") and while_stmt_ctx.body is not None:
                body_ast = self.visit(while_stmt_ctx.body)
                if body_ast is None:
                    # Create an empty block if body visit returns None
                    logger.warning("While statement body visit returned None, creating empty block")
                    body_ast = self._create_node_and_set_loc(BlockStatement, while_stmt_ctx, statements=[])
            else:
                logger.error(f"Missing body in while statement at line {while_stmt_ctx.start.line}")
                # Create an empty block as fallback
                body_ast = self._create_node_and_set_loc(BlockStatement, while_stmt_ctx, statements=[])

            return self._create_node_and_set_loc(WhileStatement, while_stmt_ctx, condition=condition_ast, body=body_ast)
        except Exception as e:
            logger.error(f"Error building WhileStatement AST: {e}")
            raise

    def visitReturnStmt(self, ctx: pjlangParser.ReturnStmtContext):
        try:
            ret_ctx = ctx.returnStatement()
            value_ast = self.visit(ret_ctx.val)
            return self._create_node_and_set_loc(ReturnStatement, ret_ctx, value=value_ast)
        except Exception as e:
            logger.error(f"Error building ReturnStatement AST: {e}")
            raise

    def visitBreakStmt(self, ctx: pjlangParser.BreakStmtContext):
        try:
            # Get the BREAK token for location information
            break_stmt_ctx = ctx.breakStatement()
            break_token = break_stmt_ctx.BREAK().getSymbol()

            # Create a dummy context with start/stop properties for location tracking
            location_ctx = type("LocationContext", (), {"start": break_token, "stop": break_token})()

            # Create and return the AST node with location information
            return self._create_node_and_set_loc(BreakStatement, location_ctx)
        except Exception as e:
            logger.error(f"Error building BreakStatement AST: {e}")
            raise

    def visitContinueStmt(self, ctx: pjlangParser.ContinueStmtContext):
        try:
            # Get the CONTINUE token for location information
            continue_stmt_ctx = ctx.continueStatement()
            continue_token = continue_stmt_ctx.CONTINUE().getSymbol()

            # Create a dummy context with start/stop properties for location tracking
            location_ctx = type("LocationContext", (), {"start": continue_token, "stop": continue_token})()

            # Create and return the AST node with location information
            return self._create_node_and_set_loc(ContinueStatement, location_ctx)
        except Exception as e:
            logger.error(f"Error building ContinueStatement AST: {e}")
            raise

    def visitPrintStmt(self, ctx: pjlangParser.PrintStmtContext):
        try:
            print_stmt_ctx = ctx.printStatement()
            arguments_ast = []
            if print_stmt_ctx.arguments:
                arg_list_ctx = print_stmt_ctx.arguments
                arguments_ast.append(self.visit(arg_list_ctx.first_arg))
                next_args = self._normalize_antlr_collection(arg_list_ctx.next_args)
                for arg_expr_ctx in next_args:
                    arguments_ast.append(self.visit(arg_expr_ctx))
            return self._create_node_and_set_loc(PrintStatement, print_stmt_ctx, arguments=arguments_ast)
        except Exception as e:
            logger.error(f"Error building PrintStatement AST: {e}")
            raise

    # Expression
    def visitExpression(self, ctx: pjlangParser.ExpressionContext):
        return self.visit(ctx.logicExpr())

    # Logic expressions
    def visitLogicOrExpr(self, ctx: pjlangParser.LogicOrExprContext):
        return self._build_left_associative_binary_expr(ctx.left, ctx.op, ctx.right, ctx)

    def visitLogicAndPassThrough(self, ctx: pjlangParser.LogicAndPassThroughContext):
        return self.visit(ctx.logicAndExpr())

    def visitLogicAndExprT(self, ctx: pjlangParser.LogicAndExprTContext):
        return self._build_left_associative_binary_expr(ctx.left, ctx.op, ctx.right, ctx)

    def visitEqualityPassThrough(self, ctx: pjlangParser.EqualityPassThroughContext):
        return self.visit(ctx.equalityExpr())

    # Equality and comparison expressions
    def visitEqualityCompExpr(self, ctx: pjlangParser.EqualityCompExprContext):
        return self._build_left_associative_binary_expr(ctx.left, ctx.op, ctx.right, ctx)

    def visitRelationalPassThrough(self, ctx: pjlangParser.RelationalPassThroughContext):
        return self.visit(ctx.relationalExpr())

    def visitRelationalCompExpr(self, ctx: pjlangParser.RelationalCompExprContext):
        return self._build_left_associative_binary_expr(ctx.left, ctx.op, ctx.right, ctx)

    def visitAdditivePassThrough(self, ctx: pjlangParser.AdditivePassThroughContext):
        return self.visit(ctx.additiveExpr())

    # Arithmetic expressions
    def visitAddSubExpr(self, ctx: pjlangParser.AddSubExprContext):
        return self._build_left_associative_binary_expr(ctx.left, ctx.op, ctx.right, ctx)

    def visitMultiplicativePassThrough(self, ctx: pjlangParser.MultiplicativePassThroughContext):
        return self.visit(ctx.multiplicativeExpr())

    def visitMulDivModExpr(self, ctx: pjlangParser.MulDivModExprContext):
        return self._build_left_associative_binary_expr(ctx.left, ctx.op, ctx.right, ctx)

    def visitUnaryPassThrough(self, ctx: pjlangParser.UnaryPassThroughContext):
        return self.visit(ctx.unaryExpr())

    # Unary expressions
    def visitUnaryNotExpr(self, ctx: pjlangParser.UnaryNotExprContext):
        try:
            operand_ast = self.visit(ctx.operand)
            return self._create_node_and_set_loc(UnaryExpression, ctx, operator="!", operand=operand_ast)
        except Exception as e:
            logger.error(f"Error visiting UnaryNotExpr: {e}")
            raise

    def visitUnaryMinusExpr(self, ctx: pjlangParser.UnaryMinusExprContext):
        try:
            operand_ast = self.visit(ctx.operand)
            return self._create_node_and_set_loc(UnaryExpression, ctx, operator="-", operand=operand_ast)
        except Exception as e:
            logger.error(f"Error visiting UnaryMinusExpr: {e}")
            raise

    def visitUnaryPlusExpr(self, ctx: pjlangParser.UnaryPlusExprContext):
        try:
            operand_ast = self.visit(ctx.operand)
            return self._create_node_and_set_loc(UnaryExpression, ctx, operator="+", operand=operand_ast)
        except Exception as e:
            logger.error(f"Error visiting UnaryPlusExpr: {e}")
            raise

    def visitPostfixPassThrough(self, ctx: pjlangParser.PostfixPassThroughContext):
        return self.visit(ctx.postfixExpr())

    # Postfix expressions
    def visitIndexAccessExpr(self, ctx: pjlangParser.IndexAccessExprContext):
        try:
            list_obj_ast = self.visit(ctx.postfixExpr())
            index_expr_ast = self.visit(ctx.index)
            return self._create_node_and_set_loc(ListAccess, ctx, list=list_obj_ast, index=index_expr_ast)
        except Exception as e:
            logger.error(f"Error visiting IndexAccessExpr: {e}")
            raise

    # def visitFunctionCallExpr(self, ctx: pjlangParser.FunctionCallExprContext):
    #     try:
    #         callee_ast = self.visit(ctx.postfixExpr())
    #         arguments_ast = []
    #         if ctx.args:
    #             arg_list_ctx = ctx.args
    #             if hasattr(arg_list_ctx, "first_arg") and arg_list_ctx.first_arg:
    #                 arguments_ast.append(self.visit(arg_list_ctx.first_arg))
    #                 next_args = self._normalize_antlr_collection(arg_list_ctx.next_args)
    #                 for arg_expr_ctx in next_args:
    #                     arguments_ast.append(self.visit(arg_expr_ctx))
    #         return self._create_node_and_set_loc(FunctionCall, ctx, callee=callee_ast, arguments=arguments_ast)
    #     except Exception as e:
    #         logger.error(f"Error visiting FunctionCallExpr: {e}")
    #         raise

    def visitPrimaryPassThrough(self, ctx: pjlangParser.PrimaryPassThroughContext):
        return self.visit(ctx.primaryExpr())

    # Primary expressions
    def visitLiteralExpr(self, ctx: pjlangParser.LiteralExprContext):
        return self.visit(ctx.literal())

    def visitIdentifierExpr(self, ctx: pjlangParser.IdentifierExprContext):
        try:
            name = ctx.IDENTIFIER().getText()
            return self._create_node_and_set_loc(Identifier, ctx, name=name)
        except Exception as e:
            logger.error(f"Error visiting IdentifierExpr: {e}")
            raise

    def visitListExpr(self, ctx: pjlangParser.ListExprContext):
        return self.visit(ctx.listLiteral())

    def visitGroupedExpr(self, ctx: pjlangParser.GroupedExprContext):
        try:
            expr_ast = self.visit(ctx.expression())
            return self._create_node_and_set_loc(GroupedExpression, ctx, expression=expr_ast)
        except Exception as e:
            logger.error(f"Error visiting GroupedExpr: {e}")
            raise

    # Literals
    def visitNumberLit(self, ctx: pjlangParser.NumberLitContext):
        try:
            text = ctx.NUMBER().getText()
            value = float(text) if "." in text or "e" in text.lower() else int(text)
            return self._create_node_and_set_loc(Literal, ctx, value=value)
        except ValueError as e:
            logger.error(f"Error parsing number literal '{text}': {e}")
            # Return a default value to allow parsing to continue
            return self._create_node_and_set_loc(Literal, ctx, value=0)
        except Exception as e:
            logger.error(f"Error visiting NumberLit: {e}")
            raise

    def visitStringLit(self, ctx: pjlangParser.StringLitContext):
        try:
            text = ctx.STRING().getText()
            # Handle escape sequences properly
            raw_value = text[1:-1]  # Remove quotes
            value = self._process_string_literal(raw_value)
            return self._create_node_and_set_loc(Literal, ctx, value=value)
        except Exception as e:
            logger.error(f"Error visiting StringLit: {e}")
            raise

    def visitBooleanLit(self, ctx: pjlangParser.BooleanLitContext):
        try:
            value = ctx.BOOLEAN().getText() == "true"
            return self._create_node_and_set_loc(Literal, ctx, value=value)
        except Exception as e:
            logger.error(f"Error visiting BooleanLit: {e}")
            raise

    def visitListLiteral(self, ctx: pjlangParser.ListLiteralContext):
        try:
            elements_ast = [self.visit(expr_ctx) for expr_ctx in ctx.elements] if ctx.elements else []
            return self._create_node_and_set_loc(ListLiteral, ctx, elements=elements_ast)
        except Exception as e:
            logger.error(f"Error visiting ListLiteral: {e}")
            raise

    def visitAssignStmt(self, ctx: pjlangParser.AssignStmtContext):
        # statement: ... | assignmentStatement SEMICOLON? #AssignStmt
        assign_rule_ctx = ctx.assignmentStatement()  # Get the AssignmentStatementContext

        target_ast = self.visit(assign_rule_ctx.left_hand_side)  # Visit the lvalue
        value_ast = self.visit(assign_rule_ctx.value)

        return self._create_node_and_set_loc(AssignmentStatement, assign_rule_ctx, target=target_ast, value=value_ast)

    # Lvalue visitor methods
    def visitLvalueId(self, ctx: pjlangParser.LvalueIdContext):
        # lvalue: IDENTIFIER #LvalueId
        # This IDENTIFIER should become an Identifier AST node
        name = ctx.IDENTIFIER().getText()
        # Create an Identifier node. Use ctx (LvalueIdContext) for location of this L-value.
        return self._create_node_and_set_loc(Identifier, ctx, name=name)

    def visitLvalueIndex(self, ctx: pjlangParser.LvalueIndexContext):
        # lvalue: base=postfixExpr '[' index=expression ']' #LvalueIndex
        base_ast = self.visit(ctx.base)
        index_ast = self.visit(ctx.index)
        # This L-value is a ListAccess expression.
        # Use ctx (LvalueIndexContext) for location of this L-value.
        return self._create_node_and_set_loc(
            ListAccess,
            ctx,
            list=base_ast,  # 'list' is the field name in ListAccess AST
            index=index_ast,
        )