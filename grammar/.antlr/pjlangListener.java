// Generated from /home/carl/p_lang/grammar/pjlang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pjlangParser}.
 */
public interface pjlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pjlangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(pjlangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(pjlangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDeclStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStmt(pjlangParser.VarDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDeclStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStmt(pjlangParser.VarDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCondStmt(pjlangParser.CondStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCondStmt(pjlangParser.CondStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(pjlangParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(pjlangParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(pjlangParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(pjlangParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(pjlangParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(pjlangParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(pjlangParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(pjlangParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(pjlangParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(pjlangParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(pjlangParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link pjlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(pjlangParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(pjlangParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(pjlangParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(pjlangParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(pjlangParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(pjlangParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(pjlangParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(pjlangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(pjlangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(pjlangParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(pjlangParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(pjlangParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(pjlangParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(pjlangParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(pjlangParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(pjlangParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(pjlangParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(pjlangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(pjlangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(pjlangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(pjlangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicOrExpr}
	 * labeled alternative in {@link pjlangParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrExpr(pjlangParser.LogicOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicOrExpr}
	 * labeled alternative in {@link pjlangParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrExpr(pjlangParser.LogicOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicAndPassThrough}
	 * labeled alternative in {@link pjlangParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndPassThrough(pjlangParser.LogicAndPassThroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicAndPassThrough}
	 * labeled alternative in {@link pjlangParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndPassThrough(pjlangParser.LogicAndPassThroughContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityPassThrough}
	 * labeled alternative in {@link pjlangParser#logicAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityPassThrough(pjlangParser.EqualityPassThroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityPassThrough}
	 * labeled alternative in {@link pjlangParser#logicAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityPassThrough(pjlangParser.EqualityPassThroughContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicAndExprT}
	 * labeled alternative in {@link pjlangParser#logicAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndExprT(pjlangParser.LogicAndExprTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicAndExprT}
	 * labeled alternative in {@link pjlangParser#logicAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndExprT(pjlangParser.LogicAndExprTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityCompExpr}
	 * labeled alternative in {@link pjlangParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityCompExpr(pjlangParser.EqualityCompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityCompExpr}
	 * labeled alternative in {@link pjlangParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityCompExpr(pjlangParser.EqualityCompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalPassThrough}
	 * labeled alternative in {@link pjlangParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalPassThrough(pjlangParser.RelationalPassThroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalPassThrough}
	 * labeled alternative in {@link pjlangParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalPassThrough(pjlangParser.RelationalPassThroughContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditivePassThrough}
	 * labeled alternative in {@link pjlangParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditivePassThrough(pjlangParser.AdditivePassThroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditivePassThrough}
	 * labeled alternative in {@link pjlangParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditivePassThrough(pjlangParser.AdditivePassThroughContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalCompExpr}
	 * labeled alternative in {@link pjlangParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalCompExpr(pjlangParser.RelationalCompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalCompExpr}
	 * labeled alternative in {@link pjlangParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalCompExpr(pjlangParser.RelationalCompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativePassThrough}
	 * labeled alternative in {@link pjlangParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativePassThrough(pjlangParser.MultiplicativePassThroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativePassThrough}
	 * labeled alternative in {@link pjlangParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativePassThrough(pjlangParser.MultiplicativePassThroughContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link pjlangParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(pjlangParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link pjlangParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(pjlangParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivModExpr}
	 * labeled alternative in {@link pjlangParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpr(pjlangParser.MulDivModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivModExpr}
	 * labeled alternative in {@link pjlangParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpr(pjlangParser.MulDivModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPassThrough}
	 * labeled alternative in {@link pjlangParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPassThrough(pjlangParser.UnaryPassThroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPassThrough}
	 * labeled alternative in {@link pjlangParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPassThrough(pjlangParser.UnaryPassThroughContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryNotExpr}
	 * labeled alternative in {@link pjlangParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryNotExpr(pjlangParser.UnaryNotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryNotExpr}
	 * labeled alternative in {@link pjlangParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryNotExpr(pjlangParser.UnaryNotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinusExpr}
	 * labeled alternative in {@link pjlangParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(pjlangParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinusExpr}
	 * labeled alternative in {@link pjlangParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(pjlangParser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPlusExpr}
	 * labeled alternative in {@link pjlangParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPlusExpr(pjlangParser.UnaryPlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPlusExpr}
	 * labeled alternative in {@link pjlangParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPlusExpr(pjlangParser.UnaryPlusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixPassThrough}
	 * labeled alternative in {@link pjlangParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixPassThrough(pjlangParser.PostfixPassThroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixPassThrough}
	 * labeled alternative in {@link pjlangParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixPassThrough(pjlangParser.PostfixPassThroughContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link pjlangParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(pjlangParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link pjlangParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(pjlangParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexAccessExpr}
	 * labeled alternative in {@link pjlangParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterIndexAccessExpr(pjlangParser.IndexAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexAccessExpr}
	 * labeled alternative in {@link pjlangParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitIndexAccessExpr(pjlangParser.IndexAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryPassThrough}
	 * labeled alternative in {@link pjlangParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryPassThrough(pjlangParser.PrimaryPassThroughContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryPassThrough}
	 * labeled alternative in {@link pjlangParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryPassThrough(pjlangParser.PrimaryPassThroughContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link pjlangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(pjlangParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link pjlangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(pjlangParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link pjlangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(pjlangParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link pjlangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(pjlangParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link pjlangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(pjlangParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link pjlangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(pjlangParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupedExpr}
	 * labeled alternative in {@link pjlangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterGroupedExpr(pjlangParser.GroupedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupedExpr}
	 * labeled alternative in {@link pjlangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitGroupedExpr(pjlangParser.GroupedExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(pjlangParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(pjlangParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void enterMulOp(pjlangParser.MulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#mulOp}.
	 * @param ctx the parse tree
	 */
	void exitMulOp(pjlangParser.MulOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberLit}
	 * labeled alternative in {@link pjlangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNumberLit(pjlangParser.NumberLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberLit}
	 * labeled alternative in {@link pjlangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNumberLit(pjlangParser.NumberLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link pjlangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLit(pjlangParser.StringLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link pjlangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLit(pjlangParser.StringLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLit}
	 * labeled alternative in {@link pjlangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLit(pjlangParser.BooleanLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLit}
	 * labeled alternative in {@link pjlangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLit(pjlangParser.BooleanLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(pjlangParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(pjlangParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void enterMathOperator(pjlangParser.MathOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void exitMathOperator(pjlangParser.MathOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(pjlangParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(pjlangParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjlangParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicOp(pjlangParser.LogicOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjlangParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicOp(pjlangParser.LogicOpContext ctx);
}