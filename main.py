import sys
import argparse
from antlr4 import FileStream, CommonTokenStream, InputStream
from generated.pjlangLexer import pjlangLexer
from generated.pjlangParser import pjlangParser
from logic.AST.builder.Builder import AstBuilder
from logic.Semantic.SemanticAnalyzer import SemanticAnalyzer
from logic.Runtime.Interpreter import Interpreter, PjlangRuntimeError
from logic.Semantic.SemanticProperties import SemanticError
from pprint import pprint
import traceback

DEBUG = False


def run_pjlang_script(file_path=None, source_code=None, verbose=False):
    if verbose:
        print(f"\n--- Processing: {file_path or 'source string'} ---")

    # Get input source
    if source_code:
        input_stream = InputStream(source_code)
    elif file_path:
        try:
            input_stream = FileStream(file_path)
        except Exception as e:
            print(f"Error: Could not read file '{file_path}': {e}")
            return None
    else:
        print("Error: No file path or source code provided.")
        return None

    # Lexing and parsing
    lexer = pjlangLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = pjlangParser(stream)
    parse_tree = parser.program()

    if parser.getNumberOfSyntaxErrors() > 0:
        print("Error: Syntax errors found. Halting.")
        return None

    # AST building
    if verbose:
        print("Parsing successful. Building AST...")
    ast_builder = AstBuilder()
    custom_ast = ast_builder.visit(parse_tree)
    if DEBUG:
        pprint(custom_ast)
    # Semantic analysis
    if verbose:
        print("\nRunning Semantic Analysis...")

    semantic_analyzer = SemanticAnalyzer()
    try:
        semantic_analyzer.visit(custom_ast)
        if verbose:
            print("Semantic analysis successful. No errors found.")
    except SemanticError as e:
        # Print only the formatted error message without the class name prefix
        print(e.get_formatted_error())
        return None

    # Interpretation
    if verbose:
        print("\n--- Interpreting Program ---")
    interpreter = Interpreter()
    program_result = None

    try:
        program_result = interpreter.interpret(custom_ast)
        if verbose:
            if program_result is not None:
                print(f"Program interpretation finished. Result: {program_result}")
            else:
                print("Program interpretation finished. No explicit top-level return.")
    except PjlangRuntimeError as e:
        print(f"Runtime Error: {e.get_formatted_error()}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
        if verbose:
            traceback.print_exc()

    return program_result


def main():
    """Main entry point for the Pjlang interpreter."""
    parser = argparse.ArgumentParser(description="Pjlang Interpreter")
    parser.add_argument("file", nargs="?", help="The Pjlang file to interpret")
    parser.add_argument("-c", "--code", help="Execute Pjlang code from a string")
    parser.add_argument("-v", "--verbose", action="store_true", help="Enable verbose output")

    args = parser.parse_args()

    if not args.file and not args.code:
        parser.print_help()
        print("\nError: You must provide either a file or code to execute.")
        sys.exit(1)

    # Run the script
    result = run_pjlang_script(file_path=args.file, source_code=args.code, verbose=args.verbose)

    # If the program returned a value and we're not in verbose mode,
    # print the result for easier scripting integration
    if result is not None and not args.verbose:
        print(result)

    # Return successful exit code if we got this far
    sys.exit(0)


if __name__ == "__main__":
    main()
