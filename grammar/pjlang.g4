grammar pjlang;

// Parser rules
program: statement* EOF;
// program: (statement | functionDeclaration)* EOF; // temporarily disabled

statement:
	variableDeclaration SEMICOLON?	# VarDeclStmt
	| conditionalStatement	SEMICOLON?		# CondStmt
	| assignmentStatement SEMICOLON? # AssignStmt 
	| blockStatement				# BlockStmt
	| whileStatement				# WhileStmt
	| returnStatement SEMICOLON?	# ReturnStmt
	| breakStatement SEMICOLON?		# BreakStmt
	| continueStatement SEMICOLON?	# ContinueStmt
	| printStatement SEMICOLON?		# PrintStmt
	// | expressionStatement	# ExprStmt
	; 

// expressionStatement: expression;

// functionDeclaration: DEF name = IDENTIFIER '(' params = parameterList? ')' body = blockStatement;

// parameterList: first_param = IDENTIFIER (',' next_params += IDENTIFIER)*; // temp disable

assignmentStatement:
	left_hand_side = lvalue EQUAL value = expression ; // Use lvalue on the LHS

lvalue:
	IDENTIFIER										# LvalueId
	| base = postfixExpr '[' index = expression ']'	# LvalueIndex
	; 

printStatement: PRINT '(' arguments = argumentList? ')';

argumentList:
	first_arg = expression (',' next_args += expression)*;

blockStatement: '{' s += statement* '}';

returnStatement: RETURN val = expression;

breakStatement: BREAK;

continueStatement: CONTINUE;

variableDeclaration: name = IDENTIFIER EQUAL value = expression;

conditionalStatement:
	IF '(' if_cond = expression ')' if_body = statement (
		ELIF '(' elif_conds += expression ')' elif_bodies += statement
	)* (ELSE else_body = statement)?;

whileStatement:
	WHILE '(' condition = expression ')' body = blockStatement;

// Expression
expression: logicExpr;

logicExpr:
	left = logicExpr op = OR right = logicAndExpr	# LogicOrExpr
	| logicAndExpr									# LogicAndPassThrough;

logicAndExpr:
	left = logicAndExpr op = AND right = equalityExpr	# LogicAndExprT
	| equalityExpr										# EqualityPassThrough;

// Equality operators (==, !=)
equalityExpr:
	left = equalityExpr op = (EQEQUAL | NOTEQUAL) right = relationalExpr	# EqualityCompExpr
	| relationalExpr														# RelationalPassThrough;

// Relational operators (<, >, <=, >=)
relationalExpr:
	left = relationalExpr op = (
		LESS
		| GREATER
		| LESSEQUALEQUAL
		| GREATEREQUAL
	) right = additiveExpr	# RelationalCompExpr
	| additiveExpr			# AdditivePassThrough;

// Addition and subtraction
additiveExpr:
	left = additiveExpr op = (PLUS | MINUS) right = multiplicativeExpr	# AddSubExpr
	| multiplicativeExpr												# MultiplicativePassThrough;

// Multiplication, division, modulo, floor division
multiplicativeExpr:
	left = multiplicativeExpr op = (
		STAR
		| SLASH
		| MODULO
		| FLOOR_DIV
	) right = unaryExpr	# MulDivModExpr
	| unaryExpr			# UnaryPassThrough;

// Unary operators
unaryExpr:
	op = '!' operand = unaryExpr	# UnaryNotExpr // Logical NOT
	| op = '-' operand = unaryExpr	# UnaryMinusExpr // Unary minus
	| op = '+' operand = unaryExpr	# UnaryPlusExpr // Unary plus
	| postfixExpr					# PostfixPassThrough;

// Postfix operations like indexing and function calls
postfixExpr:
	postfixExpr '[' index = expression ']'		# IndexAccessExpr
	| postfixExpr '(' args = argumentList? ')'	# FunctionCallExpr
	| primaryExpr								# PrimaryPassThrough;

// Highest precedence: literals, identifiers, grouped expressions
primaryExpr:
	literal					# LiteralExpr
	| IDENTIFIER			# IdentifierExpr
	| listLiteral			# ListExpr
	| '(' expression ')'	# GroupedExpr;

addOp: PLUS | MINUS;
mulOp: STAR | SLASH | MODULO | FLOOR_DIV;

literal:
	NUMBER		# NumberLit
	| STRING	# StringLit
	| BOOLEAN	# BooleanLit;

listLiteral:
	'[' (elements += expression (',' elements += expression)*)? ']';

mathOperator: PLUS | MINUS | STAR | SLASH | MODULO | FLOOR_DIV;

compOp:
	EQEQUAL
	| NOTEQUAL
	| LESS
	| GREATER
	| LESSEQUALEQUAL
	| GREATEREQUAL;

logicOp: AND | OR;

// Lexer rules
IF: 'if';
ELIF: 'elif';
ELSE: 'else';
WHILE: 'while';
DEF: 'def';
PRINT: 'print';
RETURN: 'return';
BREAK: 'break';
CONTINUE: 'continue';

EQUAL: '=';
AND: '&&';
EQEQUAL: '==';
NOTEQUAL: '!=';
LESS: '<';
GREATER: '>';
LESSEQUALEQUAL: '<=';
GREATEREQUAL: '>=';
// EXCLAMATION: '!';
OR: '||';

PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
MODULO: '%';
FLOOR_DIV: '%/';
COMMA: ',';
SEMICOLON: ';';

BOOLEAN: 'true' | 'false';

IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

NUMBER: [0-9]+ ('.' [0-9]+)?;

STRING: '"' .*? '"' | '\'' .*? '\'';

WS: [ \t\r\n]+ -> skip;

COMMENT: '//' ~[\r\n]* -> skip;

MULTILINE_COMMENT: '/*' .*? '*/' -> skip;