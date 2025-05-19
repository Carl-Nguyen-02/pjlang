// Generated from /home/carl/p_lang/grammar/pjlang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class pjlangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, IF=8, ELIF=9, 
		ELSE=10, WHILE=11, DEF=12, PRINT=13, RETURN=14, BREAK=15, CONTINUE=16, 
		EQUAL=17, AND=18, EQEQUAL=19, NOTEQUAL=20, LESS=21, GREATER=22, LESSEQUALEQUAL=23, 
		GREATEREQUAL=24, OR=25, PLUS=26, MINUS=27, STAR=28, SLASH=29, MODULO=30, 
		FLOOR_DIV=31, COMMA=32, SEMICOLON=33, BOOLEAN=34, IDENTIFIER=35, NUMBER=36, 
		STRING=37, WS=38, COMMENT=39, MULTILINE_COMMENT=40;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_printStatement = 2, RULE_argumentList = 3, 
		RULE_blockStatement = 4, RULE_returnStatement = 5, RULE_breakStatement = 6, 
		RULE_continueStatement = 7, RULE_variableDeclaration = 8, RULE_conditionalStatement = 9, 
		RULE_whileStatement = 10, RULE_expression = 11, RULE_logicExpr = 12, RULE_logicAndExpr = 13, 
		RULE_equalityExpr = 14, RULE_relationalExpr = 15, RULE_additiveExpr = 16, 
		RULE_multiplicativeExpr = 17, RULE_unaryExpr = 18, RULE_postfixExpr = 19, 
		RULE_primaryExpr = 20, RULE_addOp = 21, RULE_mulOp = 22, RULE_literal = 23, 
		RULE_listLiteral = 24, RULE_mathOperator = 25, RULE_compOp = 26, RULE_logicOp = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "printStatement", "argumentList", "blockStatement", 
			"returnStatement", "breakStatement", "continueStatement", "variableDeclaration", 
			"conditionalStatement", "whileStatement", "expression", "logicExpr", 
			"logicAndExpr", "equalityExpr", "relationalExpr", "additiveExpr", "multiplicativeExpr", 
			"unaryExpr", "postfixExpr", "primaryExpr", "addOp", "mulOp", "literal", 
			"listLiteral", "mathOperator", "compOp", "logicOp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'!'", "'['", "']'", "'if'", "'elif'", 
			"'else'", "'while'", "'def'", "'print'", "'return'", "'break'", "'continue'", 
			"'='", "'&&'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'||'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'%/'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "IF", "ELIF", "ELSE", 
			"WHILE", "DEF", "PRINT", "RETURN", "BREAK", "CONTINUE", "EQUAL", "AND", 
			"EQEQUAL", "NOTEQUAL", "LESS", "GREATER", "LESSEQUALEQUAL", "GREATEREQUAL", 
			"OR", "PLUS", "MINUS", "STAR", "SLASH", "MODULO", "FLOOR_DIV", "COMMA", 
			"SEMICOLON", "BOOLEAN", "IDENTIFIER", "NUMBER", "STRING", "WS", "COMMENT", 
			"MULTILINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "pjlang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public pjlangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(pjlangParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34359863560L) != 0)) {
				{
				{
				setState(56);
				statement();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends StatementContext {
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(pjlangParser.SEMICOLON, 0); }
		public ContinueStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends StatementContext {
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(pjlangParser.SEMICOLON, 0); }
		public PrintStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StatementContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclStmtContext extends StatementContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(pjlangParser.SEMICOLON, 0); }
		public VarDeclStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends StatementContext {
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(pjlangParser.SEMICOLON, 0); }
		public BreakStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends StatementContext {
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public BlockStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondStmtContext extends StatementContext {
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public CondStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StatementContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(pjlangParser.SEMICOLON, 0); }
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				variableDeclaration();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(65);
					match(SEMICOLON);
					}
				}

				}
				break;
			case IF:
				_localctx = new CondStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				conditionalStatement();
				}
				break;
			case T__2:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				blockStatement();
				}
				break;
			case WHILE:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				whileStatement();
				}
				break;
			case RETURN:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				returnStatement();
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(72);
					match(SEMICOLON);
					}
				}

				}
				break;
			case BREAK:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				breakStatement();
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(76);
					match(SEMICOLON);
					}
				}

				}
				break;
			case CONTINUE:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
				continueStatement();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(80);
					match(SEMICOLON);
					}
				}

				}
				break;
			case PRINT:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				printStatement();
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(84);
					match(SEMICOLON);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public ArgumentListContext arguments;
		public TerminalNode PRINT() { return getToken(pjlangParser.PRINT, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_printStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(PRINT);
			setState(90);
			match(T__0);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 257899364450L) != 0)) {
				{
				setState(91);
				((PrintStatementContext)_localctx).arguments = argumentList();
				}
			}

			setState(94);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public ExpressionContext first_arg;
		public ExpressionContext expression;
		public List<ExpressionContext> next_args = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(pjlangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(pjlangParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((ArgumentListContext)_localctx).first_arg = expression();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(97);
				match(COMMA);
				setState(98);
				((ArgumentListContext)_localctx).expression = expression();
				((ArgumentListContext)_localctx).next_args.add(((ArgumentListContext)_localctx).expression);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public StatementContext statement;
		public List<StatementContext> s = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__2);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34359863560L) != 0)) {
				{
				{
				setState(105);
				((BlockStatementContext)_localctx).statement = statement();
				((BlockStatementContext)_localctx).s.add(((BlockStatementContext)_localctx).statement);
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext val;
		public TerminalNode RETURN() { return getToken(pjlangParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(RETURN);
			setState(114);
			((ReturnStatementContext)_localctx).val = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(pjlangParser.BREAK, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(BREAK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(pjlangParser.CONTINUE, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(CONTINUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public Token name;
		public ExpressionContext value;
		public TerminalNode EQUAL() { return getToken(pjlangParser.EQUAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(pjlangParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			((VariableDeclarationContext)_localctx).name = match(IDENTIFIER);
			setState(121);
			match(EQUAL);
			setState(122);
			((VariableDeclarationContext)_localctx).value = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalStatementContext extends ParserRuleContext {
		public ExpressionContext if_cond;
		public StatementContext if_body;
		public ExpressionContext expression;
		public List<ExpressionContext> elif_conds = new ArrayList<ExpressionContext>();
		public StatementContext statement;
		public List<StatementContext> elif_bodies = new ArrayList<StatementContext>();
		public StatementContext else_body;
		public TerminalNode IF() { return getToken(pjlangParser.IF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(pjlangParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(pjlangParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(pjlangParser.ELSE, 0); }
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_conditionalStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(IF);
			setState(125);
			match(T__0);
			setState(126);
			((ConditionalStatementContext)_localctx).if_cond = expression();
			setState(127);
			match(T__1);
			setState(128);
			((ConditionalStatementContext)_localctx).if_body = statement();
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(129);
					match(ELIF);
					setState(130);
					match(T__0);
					setState(131);
					((ConditionalStatementContext)_localctx).expression = expression();
					((ConditionalStatementContext)_localctx).elif_conds.add(((ConditionalStatementContext)_localctx).expression);
					setState(132);
					match(T__1);
					setState(133);
					((ConditionalStatementContext)_localctx).statement = statement();
					((ConditionalStatementContext)_localctx).elif_bodies.add(((ConditionalStatementContext)_localctx).statement);
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(140);
				match(ELSE);
				setState(141);
				((ConditionalStatementContext)_localctx).else_body = statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public BlockStatementContext body;
		public TerminalNode WHILE() { return getToken(pjlangParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(WHILE);
			setState(145);
			match(T__0);
			setState(146);
			((WhileStatementContext)_localctx).condition = expression();
			setState(147);
			match(T__1);
			setState(148);
			((WhileStatementContext)_localctx).body = blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			logicExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicExprContext extends ParserRuleContext {
		public LogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpr; }
	 
		public LogicExprContext() { }
		public void copyFrom(LogicExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicOrExprContext extends LogicExprContext {
		public LogicExprContext left;
		public Token op;
		public LogicAndExprContext right;
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public TerminalNode OR() { return getToken(pjlangParser.OR, 0); }
		public LogicAndExprContext logicAndExpr() {
			return getRuleContext(LogicAndExprContext.class,0);
		}
		public LogicOrExprContext(LogicExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicAndPassThroughContext extends LogicExprContext {
		public LogicAndExprContext logicAndExpr() {
			return getRuleContext(LogicAndExprContext.class,0);
		}
		public LogicAndPassThroughContext(LogicExprContext ctx) { copyFrom(ctx); }
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		return logicExpr(0);
	}

	private LogicExprContext logicExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicExprContext _localctx = new LogicExprContext(_ctx, _parentState);
		LogicExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_logicExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LogicAndPassThroughContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(153);
			logicAndExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicOrExprContext(new LogicExprContext(_parentctx, _parentState));
					((LogicOrExprContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_logicExpr);
					setState(155);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(156);
					((LogicOrExprContext)_localctx).op = match(OR);
					setState(157);
					((LogicOrExprContext)_localctx).right = logicAndExpr(0);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicAndExprContext extends ParserRuleContext {
		public LogicAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndExpr; }
	 
		public LogicAndExprContext() { }
		public void copyFrom(LogicAndExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityPassThroughContext extends LogicAndExprContext {
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public EqualityPassThroughContext(LogicAndExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicAndExprTContext extends LogicAndExprContext {
		public LogicAndExprContext left;
		public Token op;
		public EqualityExprContext right;
		public LogicAndExprContext logicAndExpr() {
			return getRuleContext(LogicAndExprContext.class,0);
		}
		public TerminalNode AND() { return getToken(pjlangParser.AND, 0); }
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public LogicAndExprTContext(LogicAndExprContext ctx) { copyFrom(ctx); }
	}

	public final LogicAndExprContext logicAndExpr() throws RecognitionException {
		return logicAndExpr(0);
	}

	private LogicAndExprContext logicAndExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicAndExprContext _localctx = new LogicAndExprContext(_ctx, _parentState);
		LogicAndExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_logicAndExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new EqualityPassThroughContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(164);
			equalityExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicAndExprTContext(new LogicAndExprContext(_parentctx, _parentState));
					((LogicAndExprTContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_logicAndExpr);
					setState(166);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(167);
					((LogicAndExprTContext)_localctx).op = match(AND);
					setState(168);
					((LogicAndExprTContext)_localctx).right = equalityExpr(0);
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ParserRuleContext {
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
	 
		public EqualityExprContext() { }
		public void copyFrom(EqualityExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityCompExprContext extends EqualityExprContext {
		public EqualityExprContext left;
		public Token op;
		public RelationalExprContext right;
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public RelationalExprContext relationalExpr() {
			return getRuleContext(RelationalExprContext.class,0);
		}
		public TerminalNode EQEQUAL() { return getToken(pjlangParser.EQEQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(pjlangParser.NOTEQUAL, 0); }
		public EqualityCompExprContext(EqualityExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalPassThroughContext extends EqualityExprContext {
		public RelationalExprContext relationalExpr() {
			return getRuleContext(RelationalExprContext.class,0);
		}
		public RelationalPassThroughContext(EqualityExprContext ctx) { copyFrom(ctx); }
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		return equalityExpr(0);
	}

	private EqualityExprContext equalityExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, _parentState);
		EqualityExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_equalityExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RelationalPassThroughContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(175);
			relationalExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualityCompExprContext(new EqualityExprContext(_parentctx, _parentState));
					((EqualityCompExprContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_equalityExpr);
					setState(177);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(178);
					((EqualityCompExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==EQEQUAL || _la==NOTEQUAL) ) {
						((EqualityCompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(179);
					((EqualityCompExprContext)_localctx).right = relationalExpr(0);
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ParserRuleContext {
		public RelationalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpr; }
	 
		public RelationalExprContext() { }
		public void copyFrom(RelationalExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditivePassThroughContext extends RelationalExprContext {
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public AdditivePassThroughContext(RelationalExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalCompExprContext extends RelationalExprContext {
		public RelationalExprContext left;
		public Token op;
		public AdditiveExprContext right;
		public RelationalExprContext relationalExpr() {
			return getRuleContext(RelationalExprContext.class,0);
		}
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public TerminalNode LESS() { return getToken(pjlangParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(pjlangParser.GREATER, 0); }
		public TerminalNode LESSEQUALEQUAL() { return getToken(pjlangParser.LESSEQUALEQUAL, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(pjlangParser.GREATEREQUAL, 0); }
		public RelationalCompExprContext(RelationalExprContext ctx) { copyFrom(ctx); }
	}

	public final RelationalExprContext relationalExpr() throws RecognitionException {
		return relationalExpr(0);
	}

	private RelationalExprContext relationalExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExprContext _localctx = new RelationalExprContext(_ctx, _parentState);
		RelationalExprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_relationalExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AdditivePassThroughContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(186);
			additiveExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelationalCompExprContext(new RelationalExprContext(_parentctx, _parentState));
					((RelationalCompExprContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_relationalExpr);
					setState(188);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(189);
					((RelationalCompExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
						((RelationalCompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(190);
					((RelationalCompExprContext)_localctx).right = additiveExpr(0);
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ParserRuleContext {
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
	 
		public AdditiveExprContext() { }
		public void copyFrom(AdditiveExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativePassThroughContext extends AdditiveExprContext {
		public MultiplicativeExprContext multiplicativeExpr() {
			return getRuleContext(MultiplicativeExprContext.class,0);
		}
		public MultiplicativePassThroughContext(AdditiveExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends AdditiveExprContext {
		public AdditiveExprContext left;
		public Token op;
		public MultiplicativeExprContext right;
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public MultiplicativeExprContext multiplicativeExpr() {
			return getRuleContext(MultiplicativeExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(pjlangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(pjlangParser.MINUS, 0); }
		public AddSubExprContext(AdditiveExprContext ctx) { copyFrom(ctx); }
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		return additiveExpr(0);
	}

	private AdditiveExprContext additiveExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, _parentState);
		AdditiveExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_additiveExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new MultiplicativePassThroughContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(197);
			multiplicativeExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddSubExprContext(new AdditiveExprContext(_parentctx, _parentState));
					((AddSubExprContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_additiveExpr);
					setState(199);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(200);
					((AddSubExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
						((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(201);
					((AddSubExprContext)_localctx).right = multiplicativeExpr(0);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExprContext extends ParserRuleContext {
		public MultiplicativeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpr; }
	 
		public MultiplicativeExprContext() { }
		public void copyFrom(MultiplicativeExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModExprContext extends MultiplicativeExprContext {
		public MultiplicativeExprContext left;
		public Token op;
		public UnaryExprContext right;
		public MultiplicativeExprContext multiplicativeExpr() {
			return getRuleContext(MultiplicativeExprContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public TerminalNode STAR() { return getToken(pjlangParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(pjlangParser.SLASH, 0); }
		public TerminalNode MODULO() { return getToken(pjlangParser.MODULO, 0); }
		public TerminalNode FLOOR_DIV() { return getToken(pjlangParser.FLOOR_DIV, 0); }
		public MulDivModExprContext(MultiplicativeExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryPassThroughContext extends MultiplicativeExprContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public UnaryPassThroughContext(MultiplicativeExprContext ctx) { copyFrom(ctx); }
	}

	public final MultiplicativeExprContext multiplicativeExpr() throws RecognitionException {
		return multiplicativeExpr(0);
	}

	private MultiplicativeExprContext multiplicativeExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExprContext _localctx = new MultiplicativeExprContext(_ctx, _parentState);
		MultiplicativeExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_multiplicativeExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new UnaryPassThroughContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(208);
			unaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulDivModExprContext(new MultiplicativeExprContext(_parentctx, _parentState));
					((MulDivModExprContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpr);
					setState(210);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(211);
					((MulDivModExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0)) ) {
						((MulDivModExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(212);
					((MulDivModExprContext)_localctx).right = unaryExpr();
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	 
		public UnaryExprContext() { }
		public void copyFrom(UnaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryPlusExprContext extends UnaryExprContext {
		public Token op;
		public UnaryExprContext operand;
		public TerminalNode PLUS() { return getToken(pjlangParser.PLUS, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public UnaryPlusExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryNotExprContext extends UnaryExprContext {
		public Token op;
		public UnaryExprContext operand;
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public UnaryNotExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixPassThroughContext extends UnaryExprContext {
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public PostfixPassThroughContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryMinusExprContext extends UnaryExprContext {
		public Token op;
		public UnaryExprContext operand;
		public TerminalNode MINUS() { return getToken(pjlangParser.MINUS, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public UnaryMinusExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unaryExpr);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new UnaryNotExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				((UnaryNotExprContext)_localctx).op = match(T__4);
				setState(219);
				((UnaryNotExprContext)_localctx).operand = unaryExpr();
				}
				break;
			case MINUS:
				_localctx = new UnaryMinusExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				((UnaryMinusExprContext)_localctx).op = match(MINUS);
				setState(221);
				((UnaryMinusExprContext)_localctx).operand = unaryExpr();
				}
				break;
			case PLUS:
				_localctx = new UnaryPlusExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				((UnaryPlusExprContext)_localctx).op = match(PLUS);
				setState(223);
				((UnaryPlusExprContext)_localctx).operand = unaryExpr();
				}
				break;
			case T__0:
			case T__5:
			case BOOLEAN:
			case IDENTIFIER:
			case NUMBER:
			case STRING:
				_localctx = new PostfixPassThroughContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				postfixExpr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExprContext extends ParserRuleContext {
		public PostfixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpr; }
	 
		public PostfixExprContext() { }
		public void copyFrom(PostfixExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends PostfixExprContext {
		public ArgumentListContext args;
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallExprContext(PostfixExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexAccessExprContext extends PostfixExprContext {
		public ExpressionContext index;
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexAccessExprContext(PostfixExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryPassThroughContext extends PostfixExprContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public PrimaryPassThroughContext(PostfixExprContext ctx) { copyFrom(ctx); }
	}

	public final PostfixExprContext postfixExpr() throws RecognitionException {
		return postfixExpr(0);
	}

	private PostfixExprContext postfixExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExprContext _localctx = new PostfixExprContext(_ctx, _parentState);
		PostfixExprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_postfixExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimaryPassThroughContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(228);
			primaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(241);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new IndexAccessExprContext(new PostfixExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpr);
						setState(230);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(231);
						match(T__5);
						setState(232);
						((IndexAccessExprContext)_localctx).index = expression();
						setState(233);
						match(T__6);
						}
						break;
					case 2:
						{
						_localctx = new FunctionCallExprContext(new PostfixExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpr);
						setState(235);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(236);
						match(T__0);
						setState(238);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 257899364450L) != 0)) {
							{
							setState(237);
							((FunctionCallExprContext)_localctx).args = argumentList();
							}
						}

						setState(240);
						match(T__1);
						}
						break;
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ParserRuleContext {
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	 
		public PrimaryExprContext() { }
		public void copyFrom(PrimaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExprContext extends PrimaryExprContext {
		public TerminalNode IDENTIFIER() { return getToken(pjlangParser.IDENTIFIER, 0); }
		public IdentifierExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExprContext extends PrimaryExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListExprContext extends PrimaryExprContext {
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public ListExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupedExprContext extends PrimaryExprContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GroupedExprContext(PrimaryExprContext ctx) { copyFrom(ctx); }
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primaryExpr);
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case NUMBER:
			case STRING:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				literal();
				}
				break;
			case IDENTIFIER:
				_localctx = new IdentifierExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(IDENTIFIER);
				}
				break;
			case T__5:
				_localctx = new ListExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				listLiteral();
				}
				break;
			case T__0:
				_localctx = new GroupedExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				match(T__0);
				setState(250);
				expression();
				setState(251);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(pjlangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(pjlangParser.MINUS, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(pjlangParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(pjlangParser.SLASH, 0); }
		public TerminalNode MODULO() { return getToken(pjlangParser.MODULO, 0); }
		public TerminalNode FLOOR_DIV() { return getToken(pjlangParser.FLOOR_DIV, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberLitContext extends LiteralContext {
		public TerminalNode NUMBER() { return getToken(pjlangParser.NUMBER, 0); }
		public NumberLitContext(LiteralContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLitContext extends LiteralContext {
		public TerminalNode BOOLEAN() { return getToken(pjlangParser.BOOLEAN, 0); }
		public BooleanLitContext(LiteralContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLitContext extends LiteralContext {
		public TerminalNode STRING() { return getToken(pjlangParser.STRING, 0); }
		public StringLitContext(LiteralContext ctx) { copyFrom(ctx); }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_literal);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(STRING);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListLiteralContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> elements = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(pjlangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(pjlangParser.COMMA, i);
		}
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_listLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(T__5);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 257899364450L) != 0)) {
				{
				setState(265);
				((ListLiteralContext)_localctx).expression = expression();
				((ListLiteralContext)_localctx).elements.add(((ListLiteralContext)_localctx).expression);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(266);
					match(COMMA);
					setState(267);
					((ListLiteralContext)_localctx).expression = expression();
					((ListLiteralContext)_localctx).elements.add(((ListLiteralContext)_localctx).expression);
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(275);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MathOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(pjlangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(pjlangParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(pjlangParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(pjlangParser.SLASH, 0); }
		public TerminalNode MODULO() { return getToken(pjlangParser.MODULO, 0); }
		public TerminalNode FLOOR_DIV() { return getToken(pjlangParser.FLOOR_DIV, 0); }
		public MathOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathOperator; }
	}

	public final MathOperatorContext mathOperator() throws RecognitionException {
		MathOperatorContext _localctx = new MathOperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mathOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4227858432L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode EQEQUAL() { return getToken(pjlangParser.EQEQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(pjlangParser.NOTEQUAL, 0); }
		public TerminalNode LESS() { return getToken(pjlangParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(pjlangParser.GREATER, 0); }
		public TerminalNode LESSEQUALEQUAL() { return getToken(pjlangParser.LESSEQUALEQUAL, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(pjlangParser.GREATEREQUAL, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33030144L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(pjlangParser.AND, 0); }
		public TerminalNode OR() { return getToken(pjlangParser.OR, 0); }
		public LogicOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOp; }
	}

	public final LogicOpContext logicOp() throws RecognitionException {
		LogicOpContext _localctx = new LogicOpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_logicOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return logicExpr_sempred((LogicExprContext)_localctx, predIndex);
		case 13:
			return logicAndExpr_sempred((LogicAndExprContext)_localctx, predIndex);
		case 14:
			return equalityExpr_sempred((EqualityExprContext)_localctx, predIndex);
		case 15:
			return relationalExpr_sempred((RelationalExprContext)_localctx, predIndex);
		case 16:
			return additiveExpr_sempred((AdditiveExprContext)_localctx, predIndex);
		case 17:
			return multiplicativeExpr_sempred((MultiplicativeExprContext)_localctx, predIndex);
		case 19:
			return postfixExpr_sempred((PostfixExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicExpr_sempred(LogicExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean logicAndExpr_sempred(LogicAndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equalityExpr_sempred(EqualityExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relationalExpr_sempred(RelationalExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean additiveExpr_sempred(AdditiveExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicativeExpr_sempred(MultiplicativeExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean postfixExpr_sempred(PostfixExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u011c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001C\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001J\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001N\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001R\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001V\b\u0001\u0003"+
		"\u0001X\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002]\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"d\b\u0003\n\u0003\f\u0003g\t\u0003\u0001\u0004\u0001\u0004\u0005\u0004"+
		"k\b\u0004\n\u0004\f\u0004n\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0088\b\t\n"+
		"\t\f\t\u008b\t\t\u0001\t\u0001\t\u0003\t\u008f\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u009f\b\f\n\f\f\f\u00a2\t\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00aa\b\r\n\r\f\r\u00ad"+
		"\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00b5\b\u000e\n\u000e\f\u000e\u00b8\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00c0\b\u000f\n\u000f\f\u000f\u00c3\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00cb\b\u0010\n"+
		"\u0010\f\u0010\u00ce\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00d6\b\u0011\n\u0011\f\u0011"+
		"\u00d9\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00e2\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00ef\b\u0013\u0001\u0013"+
		"\u0005\u0013\u00f2\b\u0013\n\u0013\f\u0013\u00f5\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u00fe\b\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0107\b\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u010d\b\u0018\n\u0018\f\u0018"+
		"\u0110\t\u0018\u0003\u0018\u0112\b\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0000\u0007\u0018\u001a\u001c\u001e \"&\u001c\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.0246\u0000\u0007\u0001\u0000\u0013\u0014\u0001\u0000\u0015\u0018"+
		"\u0001\u0000\u001a\u001b\u0001\u0000\u001c\u001f\u0001\u0000\u001a\u001f"+
		"\u0001\u0000\u0013\u0018\u0002\u0000\u0012\u0012\u0019\u0019\u0124\u0000"+
		";\u0001\u0000\u0000\u0000\u0002W\u0001\u0000\u0000\u0000\u0004Y\u0001"+
		"\u0000\u0000\u0000\u0006`\u0001\u0000\u0000\u0000\bh\u0001\u0000\u0000"+
		"\u0000\nq\u0001\u0000\u0000\u0000\ft\u0001\u0000\u0000\u0000\u000ev\u0001"+
		"\u0000\u0000\u0000\u0010x\u0001\u0000\u0000\u0000\u0012|\u0001\u0000\u0000"+
		"\u0000\u0014\u0090\u0001\u0000\u0000\u0000\u0016\u0096\u0001\u0000\u0000"+
		"\u0000\u0018\u0098\u0001\u0000\u0000\u0000\u001a\u00a3\u0001\u0000\u0000"+
		"\u0000\u001c\u00ae\u0001\u0000\u0000\u0000\u001e\u00b9\u0001\u0000\u0000"+
		"\u0000 \u00c4\u0001\u0000\u0000\u0000\"\u00cf\u0001\u0000\u0000\u0000"+
		"$\u00e1\u0001\u0000\u0000\u0000&\u00e3\u0001\u0000\u0000\u0000(\u00fd"+
		"\u0001\u0000\u0000\u0000*\u00ff\u0001\u0000\u0000\u0000,\u0101\u0001\u0000"+
		"\u0000\u0000.\u0106\u0001\u0000\u0000\u00000\u0108\u0001\u0000\u0000\u0000"+
		"2\u0115\u0001\u0000\u0000\u00004\u0117\u0001\u0000\u0000\u00006\u0119"+
		"\u0001\u0000\u0000\u00008:\u0003\u0002\u0001\u000098\u0001\u0000\u0000"+
		"\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000"+
		"\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005"+
		"\u0000\u0000\u0001?\u0001\u0001\u0000\u0000\u0000@B\u0003\u0010\b\u0000"+
		"AC\u0005!\u0000\u0000BA\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CX\u0001\u0000\u0000\u0000DX\u0003\u0012\t\u0000EX\u0003\b\u0004\u0000"+
		"FX\u0003\u0014\n\u0000GI\u0003\n\u0005\u0000HJ\u0005!\u0000\u0000IH\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JX\u0001\u0000\u0000\u0000"+
		"KM\u0003\f\u0006\u0000LN\u0005!\u0000\u0000ML\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NX\u0001\u0000\u0000\u0000OQ\u0003\u000e\u0007"+
		"\u0000PR\u0005!\u0000\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RX\u0001\u0000\u0000\u0000SU\u0003\u0004\u0002\u0000TV\u0005!\u0000"+
		"\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0001\u0000"+
		"\u0000\u0000W@\u0001\u0000\u0000\u0000WD\u0001\u0000\u0000\u0000WE\u0001"+
		"\u0000\u0000\u0000WF\u0001\u0000\u0000\u0000WG\u0001\u0000\u0000\u0000"+
		"WK\u0001\u0000\u0000\u0000WO\u0001\u0000\u0000\u0000WS\u0001\u0000\u0000"+
		"\u0000X\u0003\u0001\u0000\u0000\u0000YZ\u0005\r\u0000\u0000Z\\\u0005\u0001"+
		"\u0000\u0000[]\u0003\u0006\u0003\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0005\u0002\u0000\u0000"+
		"_\u0005\u0001\u0000\u0000\u0000`e\u0003\u0016\u000b\u0000ab\u0005 \u0000"+
		"\u0000bd\u0003\u0016\u000b\u0000ca\u0001\u0000\u0000\u0000dg\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u0007"+
		"\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000hl\u0005\u0003\u0000"+
		"\u0000ik\u0003\u0002\u0001\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000"+
		"\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005\u0004\u0000\u0000"+
		"p\t\u0001\u0000\u0000\u0000qr\u0005\u000e\u0000\u0000rs\u0003\u0016\u000b"+
		"\u0000s\u000b\u0001\u0000\u0000\u0000tu\u0005\u000f\u0000\u0000u\r\u0001"+
		"\u0000\u0000\u0000vw\u0005\u0010\u0000\u0000w\u000f\u0001\u0000\u0000"+
		"\u0000xy\u0005#\u0000\u0000yz\u0005\u0011\u0000\u0000z{\u0003\u0016\u000b"+
		"\u0000{\u0011\u0001\u0000\u0000\u0000|}\u0005\b\u0000\u0000}~\u0005\u0001"+
		"\u0000\u0000~\u007f\u0003\u0016\u000b\u0000\u007f\u0080\u0005\u0002\u0000"+
		"\u0000\u0080\u0089\u0003\u0002\u0001\u0000\u0081\u0082\u0005\t\u0000\u0000"+
		"\u0082\u0083\u0005\u0001\u0000\u0000\u0083\u0084\u0003\u0016\u000b\u0000"+
		"\u0084\u0085\u0005\u0002\u0000\u0000\u0085\u0086\u0003\u0002\u0001\u0000"+
		"\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0081\u0001\u0000\u0000\u0000"+
		"\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008e\u0001\u0000\u0000\u0000"+
		"\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008d\u0005\n\u0000\u0000\u008d"+
		"\u008f\u0003\u0002\u0001\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0001\u0000\u0000\u0000\u008f\u0013\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0005\u000b\u0000\u0000\u0091\u0092\u0005\u0001\u0000\u0000\u0092"+
		"\u0093\u0003\u0016\u000b\u0000\u0093\u0094\u0005\u0002\u0000\u0000\u0094"+
		"\u0095\u0003\b\u0004\u0000\u0095\u0015\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0003\u0018\f\u0000\u0097\u0017\u0001\u0000\u0000\u0000\u0098\u0099\u0006"+
		"\f\uffff\uffff\u0000\u0099\u009a\u0003\u001a\r\u0000\u009a\u00a0\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\n\u0002\u0000\u0000\u009c\u009d\u0005\u0019"+
		"\u0000\u0000\u009d\u009f\u0003\u001a\r\u0000\u009e\u009b\u0001\u0000\u0000"+
		"\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u0019\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a4\u0006\r\uffff\uffff"+
		"\u0000\u00a4\u00a5\u0003\u001c\u000e\u0000\u00a5\u00ab\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\n\u0002\u0000\u0000\u00a7\u00a8\u0005\u0012\u0000\u0000"+
		"\u00a8\u00aa\u0003\u001c\u000e\u0000\u00a9\u00a6\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u001b\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00af\u0006\u000e\uffff\uffff"+
		"\u0000\u00af\u00b0\u0003\u001e\u000f\u0000\u00b0\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\n\u0002\u0000\u0000\u00b2\u00b3\u0007\u0000\u0000\u0000"+
		"\u00b3\u00b5\u0003\u001e\u000f\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u001d\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0006\u000f\uffff\uffff"+
		"\u0000\u00ba\u00bb\u0003 \u0010\u0000\u00bb\u00c1\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\n\u0002\u0000\u0000\u00bd\u00be\u0007\u0001\u0000\u0000\u00be"+
		"\u00c0\u0003 \u0010\u0000\u00bf\u00bc\u0001\u0000\u0000\u0000\u00c0\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c2\u001f\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0006\u0010\uffff\uffff\u0000\u00c5"+
		"\u00c6\u0003\"\u0011\u0000\u00c6\u00cc\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\n\u0002\u0000\u0000\u00c8\u00c9\u0007\u0002\u0000\u0000\u00c9\u00cb\u0003"+
		"\"\u0011\u0000\u00ca\u00c7\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000"+
		"\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cd!\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0006\u0011\uffff\uffff\u0000\u00d0\u00d1\u0003$\u0012"+
		"\u0000\u00d1\u00d7\u0001\u0000\u0000\u0000\u00d2\u00d3\n\u0002\u0000\u0000"+
		"\u00d3\u00d4\u0007\u0003\u0000\u0000\u00d4\u00d6\u0003$\u0012\u0000\u00d5"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8"+
		"#\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0005\u0005\u0000\u0000\u00db\u00e2\u0003$\u0012\u0000\u00dc\u00dd\u0005"+
		"\u001b\u0000\u0000\u00dd\u00e2\u0003$\u0012\u0000\u00de\u00df\u0005\u001a"+
		"\u0000\u0000\u00df\u00e2\u0003$\u0012\u0000\u00e0\u00e2\u0003&\u0013\u0000"+
		"\u00e1\u00da\u0001\u0000\u0000\u0000\u00e1\u00dc\u0001\u0000\u0000\u0000"+
		"\u00e1\u00de\u0001\u0000\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e2%\u0001\u0000\u0000\u0000\u00e3\u00e4\u0006\u0013\uffff\uffff\u0000"+
		"\u00e4\u00e5\u0003(\u0014\u0000\u00e5\u00f3\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\n\u0003\u0000\u0000\u00e7\u00e8\u0005\u0006\u0000\u0000\u00e8\u00e9"+
		"\u0003\u0016\u000b\u0000\u00e9\u00ea\u0005\u0007\u0000\u0000\u00ea\u00f2"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ec\n\u0002\u0000\u0000\u00ec\u00ee\u0005"+
		"\u0001\u0000\u0000\u00ed\u00ef\u0003\u0006\u0003\u0000\u00ee\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f2\u0005\u0002\u0000\u0000\u00f1\u00e6\u0001"+
		"\u0000\u0000\u0000\u00f1\u00eb\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f4\'\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f6\u00fe\u0003.\u0017\u0000\u00f7\u00fe\u0005#\u0000\u0000"+
		"\u00f8\u00fe\u00030\u0018\u0000\u00f9\u00fa\u0005\u0001\u0000\u0000\u00fa"+
		"\u00fb\u0003\u0016\u000b\u0000\u00fb\u00fc\u0005\u0002\u0000\u0000\u00fc"+
		"\u00fe\u0001\u0000\u0000\u0000\u00fd\u00f6\u0001\u0000\u0000\u0000\u00fd"+
		"\u00f7\u0001\u0000\u0000\u0000\u00fd\u00f8\u0001\u0000\u0000\u0000\u00fd"+
		"\u00f9\u0001\u0000\u0000\u0000\u00fe)\u0001\u0000\u0000\u0000\u00ff\u0100"+
		"\u0007\u0002\u0000\u0000\u0100+\u0001\u0000\u0000\u0000\u0101\u0102\u0007"+
		"\u0003\u0000\u0000\u0102-\u0001\u0000\u0000\u0000\u0103\u0107\u0005$\u0000"+
		"\u0000\u0104\u0107\u0005%\u0000\u0000\u0105\u0107\u0005\"\u0000\u0000"+
		"\u0106\u0103\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000"+
		"\u0106\u0105\u0001\u0000\u0000\u0000\u0107/\u0001\u0000\u0000\u0000\u0108"+
		"\u0111\u0005\u0006\u0000\u0000\u0109\u010e\u0003\u0016\u000b\u0000\u010a"+
		"\u010b\u0005 \u0000\u0000\u010b\u010d\u0003\u0016\u000b\u0000\u010c\u010a"+
		"\u0001\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0112"+
		"\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0109"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u0007\u0000\u0000\u01141\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0007\u0004\u0000\u0000\u01163\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0007\u0005\u0000\u0000\u01185\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u0007\u0006\u0000\u0000\u011a7\u0001\u0000\u0000\u0000"+
		"\u001a;BIMQUW\\el\u0089\u008e\u00a0\u00ab\u00b6\u00c1\u00cc\u00d7\u00e1"+
		"\u00ee\u00f1\u00f3\u00fd\u0106\u010e\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}