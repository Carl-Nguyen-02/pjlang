# pjlang – A Custom Programming Language

`pjlang` is a custom-designed programming language built using ANTLR4 with its own interpreter. This project combines syntactic elements from Python & Java, with a Python-based interpreter to execute `.pjlang` files.

---

## 🧰 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/pjlang.git
cd pjlang
```
### 2. Set up virtual environment
```bash
python -m venv .env
./.env/Scripts/activate #For Windows
source .env/bin/activate #For Linux
```
### 3. Install necessary libraries
```bash
pip install antlr4-python3-runtime
```
## Basic Syntax

- Statements do not require semicolons to terminate
- Code blocks are enclosed in curly braces `{ }`
- Comments begin with `//`

## Variables

Variables are dynamically typed and do not require declaration keywords:

```
x = 5          // Number assignment
name = "Alice" // String assignment
nums = [1,2,3] // Array assignment
```

## Data Types

### Numbers
Integer and floating-point values:

```
x = 5     // Integer
y = 3.14  // Floating-point
```

### Strings
Text enclosed in double or single quotes:

```
greeting = "Hello"
name = 'World'
```

Strings can be concatenated with the `+` operator:

```
message = "str" + "ing"  // Results in "string"
```

### Arrays
Collections of values enclosed in square brackets:

```
numbers = [1, 2, 3]
mixed = [1, "two", 3.0]
```

Arrays can be concatenated with the `+` operator:

```
arr = [1] + [2] + [3] + ["huh"]  // Results in [1, 2, 3, "huh"]
```

Array elements are accessed using zero-based indexing:

```
a = [1, 2, 3]
value = a[2]  // Gets the third element (3)
```

## Operators

### Arithmetic Operators
- `+` Addition
- `-` Subtraction 
- `*` Multiplication
- `/` Division
- `%/` Integer division (returns the quotient without remainder)

### Comparison Operators
- `==` Equal to
- `!=` Not equal to
- `<` Less than
- `>` Greater than
- `<=` Less than or equal to
- `>=` Greater than or equal to

### Logical Operators
- `&&` Logical AND
- `||` Logical OR
- `!` Logical NOT

## Control Structures

### Conditional Statements
If-else statements for conditional execution:

```
if (condition) {
    // Code to execute if condition is true
} else if (anotherCondition) {
    // Code to execute if anotherCondition is true
} else {
    // Code to execute if all conditions are false
}
```

Example:
```
if (x < y) {
    print("x < y")
} else if (x > y) {
    print("x > y")
} else {
    print("x == y")
}
```

### Loops

While loops for repeated execution:

```
while (condition) {
    // Code to execute while condition is true
}
```

Example:
```
while (a[2] < 10) {
    print(a[2])
    a[2] = a[2] + 1
}
```

## Built-in Functions

### print()
Outputs values to the console:

```
print("Hello, World!")
print("Result:", 5 + 3)
print("Array:", [1, 2, 3])
```

The `print()` function can take multiple arguments, separated by commas.
