from typing import List, Dict, Optional
from logic.Semantic.SemanticProperties import Symbol, SemanticError


class SymbolTable:
    def __init__(self):
        # List of dictionaries, where each dictionary is a scope
        # The first scope is the global scope
        self.scopes: List[Dict[str, Symbol]] = [{}]
        self.current_scope_level = 0

    def enter_scope(self):
        """Enter a new scope."""
        self.scopes.append({})
        self.current_scope_level += 1
        return self.current_scope_level

    def exit_scope(self):
        """Exit the current scope."""
        if len(self.scopes) > 1:  # Keep at least the global scope
            self.scopes.pop()
            self.current_scope_level -= 1
        else:
            raise SemanticError.scope_error("Cannot exit global scope")
        return self.current_scope_level

    def define(self, symbol: Symbol) -> bool:
        """
        Define a symbol in the current scope.
        Returns True if successful, False if already defined in current scope.
        """
        current_scope = self.scopes[-1]
        if symbol.name in current_scope:
            return False  # Symbol already defined in this scope
        current_scope[symbol.name] = symbol
        # print(f"Defined '{symbol.name}' in scope {self.current_scope_level}")
        return True

    def lookup(self, name: str) -> Optional[Symbol]:
        """
        Look up a symbol starting from the current scope and going outwards.
        Returns the Symbol object if found, None otherwise.
        """
        # Iterate from the innermost scope to the outermost (global)
        for i in range(len(self.scopes) - 1, -1, -1):
            scope = self.scopes[i]
            if name in scope:
                # print(f"Found '{name}' in scope {i}")
                return scope[name]
        # print(f"'{name}' 404 Not Found")
        return None

    def lookup_current_scope(self, name: str) -> Optional[Symbol]:
        """
        Look up a symbol only in the current (innermost) scope.
        """
        current_scope = self.scopes[-1]
        if name in current_scope:
            return current_scope[name]
        return None

    def get_scope_context(self) -> List[str]:
        """Returns a list of strings representing the current scope context.

        Each string describes a scope level for debugging purposes.
        """
        context = []

        # Add a context entry for each scope level
        for scope_level, scope in enumerate(self.scopes):
            # Create a description of variables in this scope
            var_list = ", ".join([f"{sym.name}: {sym.type}" for sym in scope.values()])

            # Label for the scope
            if scope_level == 0:
                label = "Global scope"
            else:
                label = f"Scope level {scope_level}"

            context.append(f"{label} [{var_list}]")

        return context
