from dataclasses import dataclass, field  # Make sure 'field' is imported
from typing import List, Optional, Union


# Base
@dataclass
class Node:
    line: Optional[int] = field(default=None, init=False)
    column: Optional[int] = field(default=None, init=False)
    end_line: Optional[int] = field(default=None, init=False)
    end_column: Optional[int] = field(default=None, init=False)


# Program
@dataclass
class Program(Node):
    # Use default_factory for mutable defaults like lists
    statements: List["Statement"] = field(default_factory=list)


# Statements
class Statement(Node):
    pass


@dataclass
class BlockStatement(Statement):
    statements: List[Statement] = field(default_factory=list)


@dataclass
class VariableDeclaration(Statement):
    name: str  
    value: "Expression" 


@dataclass
class ConditionalBranch(Node):  
    condition: "Expression"
    body: Statement


@dataclass
class ConditionalStatement(Statement):
    if_branch: ConditionalBranch
    elif_branches: List[ConditionalBranch] = field(default_factory=list)
    else_branch: Optional[Statement] = None


@dataclass
class WhileStatement(Statement):
    condition: "Expression"
    body: BlockStatement


@dataclass
class ReturnStatement(Statement):
    value: "Expression"

@dataclass
class BreakStatement(Statement):
    pass


@dataclass
class ContinueStatement(Statement):
    pass


# Expressions
class Expression(Node):
    pass


@dataclass
class Identifier(Expression):
    name: str


@dataclass
class Literal(Expression):
    value: Union[int, float, str, bool]


@dataclass
class BinaryExpression(Expression):
    left: Expression
    operator: str
    right: Expression


@dataclass
class UnaryExpression(Expression):
    operator: str
    operand: Expression


@dataclass
class GroupedExpression(Expression):
    expression: Expression


# List
@dataclass
class ListLiteral(Expression):
    elements: List[Expression] = field(default_factory=list)


@dataclass
class ListAccess(Expression):
    list: Expression 
    index: Expression


@dataclass
class PrintStatement(Statement):
    arguments: List[Expression] = field(default_factory=list)
    
@dataclass
class AssignmentStatement(Statement):
    target: Expression 
    value: Expression