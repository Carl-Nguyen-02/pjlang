from typing import List, Dict, Any, Optional

from logic.Runtime.RuntimeError import PjlangRuntimeError


class Environment:
    def __init__(self, enclosing: Optional["Environment"] = None):
        self.values: Dict[str, Any] = {}
        self.enclosing: Optional[Environment] = enclosing

    def define(self, name: str, value: Any):
        self.values[name] = value

    def assign(self, name: str, value: Any) -> bool:
        """Assign a value to an existing variable.
        Traverses up the scope chain if not found locally."""
        if name in self.values:
            self.values[name] = value
            return True
        elif self.enclosing is not None:
            return self.enclosing.assign(name, value)
        else:
            return False

    def get(self, name: str) -> Any:
        if name in self.values:
            return self.values[name]
        elif self.enclosing is not None:
            return self.enclosing.get(name)

        raise PjlangRuntimeError(f"Undefined variable '{name}'.")

    def get_at_depth(self, distance: int, name: str) -> Any:
        ancestor = self
        for _ in range(distance):
            if ancestor.enclosing is None:
                # This should not happen if semantic analysis resolved distances correctly
                raise PjlangRuntimeError(f"Invalid scope distance for '{name}'.")
            ancestor = ancestor.enclosing

        if name in ancestor.values:
            return ancestor.values[name]
        raise PjlangRuntimeError(f"Undefined variable '{name}' at expected scope depth.")

    def assign_at_depth(self, distance: int, name: str, value: Any):
        ancestor = self
        for _ in range(distance):
            if ancestor.enclosing is None:
                raise PjlangRuntimeError(f"Invalid scope distance for assignment to '{name}'.")
            ancestor = ancestor.enclosing

        if name in ancestor.values:
            ancestor.values[name] = value
        else:
            raise PjlangRuntimeError(f"Cannot assign to undefined variable '{name}' at expected scope depth.")
        return
