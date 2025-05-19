from dataclasses import dataclass
from typing import Optional, List, Any
from enum import Enum, auto


class SemanticErrorType(Enum):
    UNDEFINED_VARIABLE = auto()
    DUPLICATE_VARIABLE = auto()
    TYPE_ERROR = auto()
    INVALID_OPERATION = auto()
    SCOPE_ERROR = auto()
    BREAK_OUTSIDE_LOOP = auto()
    CONTINUE_OUTSIDE_LOOP = auto()
    RETURN_OUTSIDE_FUNCTION = auto()
    UNDEFINED_FUNCTION = auto()
    ARGUMENT_MISMATCH = auto()
    INVALID_ASSIGNMENT = auto()
    GENERIC_ERROR = auto()


@dataclass
class Symbol:
    name: str
    type: Optional[str] = None
    line: Optional[int] = None
    column: Optional[int] = None
    scope_level: int = 0


class SemanticError(Exception):
    def __init__(
        self,
        message: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
        error_type: SemanticErrorType = SemanticErrorType.GENERIC_ERROR,
    ):
        self.message = message
        self.line = line
        self.column = column
        self.scope_context = scope_context or []
        self.error_type = error_type

        # Format the error message with location if provided
        location = f" at line {line}" if line is not None else ""
        super().__init__(f"{error_type.name}: {message}{location}")

    @classmethod
    def undefined_variable(
        cls, name: str, line: Optional[int] = None, column: Optional[int] = None, scope_context: List[str] = None
    ):
        """Create an error for undefined variable reference."""
        return cls(
            f"Undefined variable '{name}'", line, column, scope_context, error_type=SemanticErrorType.UNDEFINED_VARIABLE
        )

    @classmethod
    def duplicate_variable(
        cls, name: str, line: Optional[int] = None, column: Optional[int] = None, scope_context: List[str] = None
    ):
        """Create an error for duplicate variable declaration."""
        return cls(
            f"Duplicate variable '{name}' in the same scope",
            line,
            column,
            scope_context,
            error_type=SemanticErrorType.DUPLICATE_VARIABLE,
        )

    @classmethod
    def type_error(
        cls,
        expected: str,
        got: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a type error with a formatted message."""
        return cls(
            f"Expected {expected}, got {got}", line, column, scope_context, error_type=SemanticErrorType.TYPE_ERROR
        )

    @classmethod
    def invalid_operation(
        cls,
        operator: str,
        left_type: str,
        right_type: Optional[str] = None,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create an error for invalid operation."""
        if right_type is not None:
            message = f"Invalid operation: {left_type} {operator} {right_type}"
        else:
            message = f"Invalid operation: {operator} {left_type}"
        return cls(message, line, column, scope_context, error_type=SemanticErrorType.INVALID_OPERATION)

    @classmethod
    def scope_error(
        cls, message: str, line: Optional[int] = None, column: Optional[int] = None, scope_context: List[str] = None
    ):
        """Create an error for scope-related issues."""
        return cls(message, line, column, scope_context, error_type=SemanticErrorType.SCOPE_ERROR)

    @classmethod
    def break_outside_loop(
        cls, line: Optional[int] = None, column: Optional[int] = None, scope_context: List[str] = None
    ):
        """Create an error for break statement outside loop."""
        return cls(
            "Break statement outside of loop",
            line,
            column,
            scope_context,
            error_type=SemanticErrorType.BREAK_OUTSIDE_LOOP,
        )

    @classmethod
    def continue_outside_loop(
        cls, line: Optional[int] = None, column: Optional[int] = None, scope_context: List[str] = None
    ):
        """Create an error for continue statement outside loop."""
        return cls(
            "Continue statement outside of loop",
            line,
            column,
            scope_context,
            error_type=SemanticErrorType.CONTINUE_OUTSIDE_LOOP,
        )

    @classmethod
    def return_outside_function(
        cls, line: Optional[int] = None, column: Optional[int] = None, scope_context: List[str] = None
    ):
        """Create an error for return statement outside function."""
        return cls(
            "Return statement outside of function",
            line,
            column,
            scope_context,
            error_type=SemanticErrorType.RETURN_OUTSIDE_FUNCTION,
        )

    @classmethod
    def undefined_function(
        cls, name: str, line: Optional[int] = None, column: Optional[int] = None, scope_context: List[str] = None
    ):
        """Create an error for undefined function call."""
        return cls(
            f"Undefined function '{name}'", line, column, scope_context, error_type=SemanticErrorType.UNDEFINED_FUNCTION
        )

    @classmethod
    def argument_mismatch(
        cls,
        function_name: str,
        expected: int,
        got: int,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create an error for function argument count mismatch."""
        return cls(
            f"Function '{function_name}' expects {expected} arguments, got {got}",
            line,
            column,
            scope_context,
            error_type=SemanticErrorType.ARGUMENT_MISMATCH,
        )

    @classmethod
    def invalid_assignment(
        cls, target: str, line: Optional[int] = None, column: Optional[int] = None, scope_context: List[str] = None
    ):
        """Create an error for invalid assignment target."""
        return cls(
            f"Invalid assignment target: {target}",
            line,
            column,
            scope_context,
            error_type=SemanticErrorType.INVALID_ASSIGNMENT,
        )

    @classmethod
    def generic_error(
        cls,
        message: str = "Semantic error occurred",
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a generic semantic error."""
        return cls(message, line, column, scope_context, error_type=SemanticErrorType.GENERIC_ERROR)

    def get_formatted_error(self) -> str:
        """Get a formatted error message with scope context if available."""
        error_msg = f"Semantic Error: {self.error_type.name}: {self.message}"
        if self.line is not None:
            error_msg += f" at line {self.line}"
            if self.column is not None:
                error_msg += f", column {self.column}"

        if self.scope_context:
            error_msg += "\nScope context:"
            for i, scope in enumerate(reversed(self.scope_context)):
                error_msg += f"\n  {i + 1}. {scope}"

        return error_msg

    def __str__(self):
        return self.get_formatted_error()


class SemanticWarningType(Enum):
    SHADOWING = auto()  # Variable shadows another from outer scope
    POSSIBLE_TYPE_MISMATCH = auto()  # Type might not be compatible
    UNUSED_VARIABLE = auto()  # Variable is defined but never used
    IMPLICIT_TYPE_CONVERSION = auto()  # Implicit conversion between types
    REDUNDANT_CODE = auto()  # Code has no effect
    MISLEADING_INDENTATION = auto()  # Indentation doesn't match logical structure
    UNREACHABLE_CODE = auto()  # Code after return/break/continue
    REDEFINITION_WITHOUT_USE = auto()  # Variable assigned twice without use
    GENERIC_WARNING = auto()  # Generic warning


class SemanticWarning:
    def __init__(
        self,
        message: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
        warning_type: SemanticWarningType = SemanticWarningType.GENERIC_WARNING,
    ):
        self.message = message
        self.line = line
        self.column = column
        self.scope_context = scope_context or []
        self.warning_type = warning_type

    @classmethod
    def shadowing(
        cls,
        name: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a warning for variable shadowing another from outer scope."""
        return cls(
            f"Variable '{name}' shadows an existing definition",
            line,
            column,
            scope_context,
            warning_type=SemanticWarningType.SHADOWING,
        )

    @classmethod
    def possible_type_mismatch(
        cls,
        expected: str,
        got: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a warning for potential type mismatches."""
        return cls(
            f"Possible type mismatch: expected {expected}, using {got}",
            line,
            column,
            scope_context,
            warning_type=SemanticWarningType.POSSIBLE_TYPE_MISMATCH,
        )

    @classmethod
    def unused_variable(
        cls,
        name: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a warning for unused variables."""
        return cls(
            f"Variable '{name}' is defined but never used",
            line,
            column,
            scope_context,
            warning_type=SemanticWarningType.UNUSED_VARIABLE,
        )

    @classmethod
    def implicit_type_conversion(
        cls,
        from_type: str,
        to_type: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a warning for implicit type conversions."""
        return cls(
            f"Implicit conversion from {from_type} to {to_type}",
            line,
            column,
            scope_context,
            warning_type=SemanticWarningType.IMPLICIT_TYPE_CONVERSION,
        )

    @classmethod
    def redundant_code(
        cls,
        message: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a warning for code that has no effect."""
        return cls(message, line, column, scope_context, warning_type=SemanticWarningType.REDUNDANT_CODE)

    @classmethod
    def infinite_loop(
        cls,
        reason: str = "condition always evaluates to true",
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a warning for potentially infinite loops."""
        return cls(
            f"Loop might be infinite: {reason}",
            line,
            column,
            scope_context,
            warning_type=SemanticWarningType.INFINITE_LOOP,
        )

    @classmethod
    def unreachable_code(
        cls,
        reason: str = "code follows unconditional control flow statement",
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a warning for unreachable code."""
        return cls(
            f"Unreachable code: {reason}",
            line,
            column,
            scope_context,
            warning_type=SemanticWarningType.UNREACHABLE_CODE,
        )

    @classmethod
    def outer_scope_modification(
        cls,
        name: str,
        scope_level: int,
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a warning about modifying variables from outer scopes."""
        return cls(
            f"Modifying variable '{name}' from outer scope (level {scope_level})",
            line,
            column,
            scope_context,
            warning_type=SemanticWarningType.GENERIC_WARNING,
        )

    @classmethod
    def generic_warning(
        cls,
        message: str = "Potential issue detected",
        line: Optional[int] = None,
        column: Optional[int] = None,
        scope_context: List[str] = None,
    ):
        """Create a generic warning."""
        return cls(message, line, column, scope_context, warning_type=SemanticWarningType.GENERIC_WARNING)

    def get_formatted_warning(self) -> str:
        """Get a formatted warning message with location and scope context."""
        warning_msg = f"Warning: {self.warning_type.name}: {self.message}"
        if self.line is not None:
            warning_msg += f" at line {self.line}"
            if self.column is not None:
                warning_msg += f", column {self.column}"

        if self.scope_context:
            warning_msg += "\nScope context:"
            for i, scope in enumerate(reversed(self.scope_context)):
                warning_msg += f"\n  {i + 1}. {scope}"

        return warning_msg

    def __str__(self):
        return self.get_formatted_warning()
