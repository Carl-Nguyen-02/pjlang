from enum import Enum, auto
from typing import Optional, List, Any


class ErrorType(Enum):
    TYPE_ERROR = auto()
    NAME_ERROR = auto()
    INDEX_ERROR = auto()
    DIVISION_BY_ZERO = auto()
    UNSUPPORTED_OPERATION = auto()
    UNIMPLEMENTED_FEATURE = auto()
    RETURN_OUTSIDE_FUNCTION = auto()
    BREAK_OUTSIDE_LOOP = auto()
    CONTINUE_OUTSIDE_LOOP = auto()
    STACK_OVERFLOW = auto()
    ARGUMENT_ERROR = auto()
    GENERIC_ERROR = auto()


class PjlangRuntimeError(Exception):
    def __init__(
        self,
        message: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        execution_stack: List[Any] = None,
        error_type: ErrorType = ErrorType.GENERIC_ERROR,
    ):
        self.message = message
        self.line = line
        self.column = column
        self.execution_stack = execution_stack or []
        self.error_type = error_type

        # Format the error message with location if provided
        location = f" at line {line}" if line is not None else ""
        super().__init__(f"{error_type.name}: {message}{location}")

    @classmethod
    def type_error(
        cls,
        expected: str,
        got: str,
        line: Optional[int] = None,
        column: Optional[int] = None,
        execution_stack: List[Any] = None,
    ):
        """Create a type error with a formatted message."""
        return cls(f"Expected {expected}, got {got}", line, column, execution_stack, error_type=ErrorType.TYPE_ERROR)

    @classmethod
    def name_error(
        cls, name: str, line: Optional[int] = None, column: Optional[int] = None, execution_stack: List[Any] = None
    ):
        """Create a name error for undefined variable/function."""
        return cls(
            f"Undefined variable or function '{name}'", line, column, execution_stack, error_type=ErrorType.NAME_ERROR
        )

    @classmethod
    def index_error(
        cls,
        index: Any,
        size: int,
        line: Optional[int] = None,
        column: Optional[int] = None,
        execution_stack: List[Any] = None,
    ):
        """Create an error for invalid list index."""
        return cls(
            f"Index {index} out of bound for list of size {size}",
            line,
            column,
            execution_stack,
            error_type=ErrorType.INDEX_ERROR,
        )

    @classmethod
    def division_by_zero(
        cls, line: Optional[int] = None, column: Optional[int] = None, execution_stack: List[Any] = None
    ):
        """Create an error for division by zero."""
        return cls("Division by zero", line, column, execution_stack, error_type=ErrorType.DIVISION_BY_ZERO)

    @classmethod
    def unsupported_operation(
        cls,
        operator: str,
        left_type: str,
        right_type: Optional[str] = None,
        line: Optional[int] = None,
        column: Optional[int] = None,
        execution_stack: List[Any] = None,
    ):
        """Create an error for unsupported operation."""
        if right_type is not None:
            message = f"Unsupported operation: {left_type} {operator} {right_type}"
        else:
            message = f"Unsupported operation: {operator} {left_type}"
        return cls(message, line, column, execution_stack, error_type=ErrorType.UNSUPPORTED_OPERATION)

    @classmethod
    def unimplemented_feature(
        cls, feature: str, line: Optional[int] = None, column: Optional[int] = None, execution_stack: List[Any] = None
    ):
        """Create an error for unimplemented language feature."""
        return cls(
            f"Unimplemented feature: {feature}",
            line,
            column,
            execution_stack,
            error_type=ErrorType.UNIMPLEMENTED_FEATURE,
        )

    @classmethod
    def return_outside_function(
        cls, line: Optional[int] = None, column: Optional[int] = None, execution_stack: List[Any] = None
    ):
        """Create an error for return statement outside function."""
        return cls(
            "Return statement outside of function",
            line,
            column,
            execution_stack,
            error_type=ErrorType.RETURN_OUTSIDE_FUNCTION,
        )

    @classmethod
    def break_outside_loop(
        cls, line: Optional[int] = None, column: Optional[int] = None, execution_stack: List[Any] = None
    ):
        """Create an error for break statement outside loop."""
        return cls(
            "Break statement outside of loop",
            line,
            column,
            execution_stack,
            error_type=ErrorType.BREAK_OUTSIDE_LOOP,
        )

    @classmethod
    def continue_outside_loop(
        cls, line: Optional[int] = None, column: Optional[int] = None, execution_stack: List[Any] = None
    ):
        """Create an error for continue statement outside loop."""
        return cls(
            "Continue statement outside of loop",
            line,
            column,
            execution_stack,
            error_type=ErrorType.CONTINUE_OUTSIDE_LOOP,
        )

    @classmethod
    def generic_error(
        cls,
        message="An error occurred during execution",
        line: Optional[int] = None,
        column: Optional[int] = None,
        execution_stack: List[Any] = None,
    ):
        """Create a generic runtime error."""
        return cls(
            message,
            line,
            column,
            execution_stack,
            error_type=ErrorType.GENERIC_ERROR,
        )

    def get_formatted_error(self) -> str:
        """Get a formatted error message with stack trace if available."""
        error_msg = f"{self.error_type.name}: {self.message}"
        if self.line is not None:
            error_msg += f" at line {self.line}"
            if self.column is not None:
                error_msg += f", column {self.column}"

        if self.execution_stack:
            error_msg += "\nCall stack (most recent call last):"
            for i, frame in enumerate(reversed(self.execution_stack)):
                error_msg += f"\n  {i + 1}. {frame}"

        return error_msg


# Control flow signal classes
class ReturnSignal(Exception):
    """Signal for return statements."""

    def __init__(self, value=None):
        self.value = value
        super().__init__(f"Return signal with value: {value}")


class BreakSignal(Exception):
    """Signal for break statements."""

    pass


class ContinueSignal(Exception):
    """Signal for continue statements."""

    pass
