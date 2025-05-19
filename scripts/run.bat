@echo off
setlocal enabledelayedexpansion

REM Set ANTLR jar path - use environment variable if set, otherwise use default
if not defined ANTLR_JAR (
    set "ANTLR_JAR=C:\JavaLib\antlr-4.13.2-complete.jar"
)

REM Check if ANTLR jar exists
if not exist "!ANTLR_JAR!" (
    echo ERROR: ANTLR jar not found at !ANTLR_JAR!
    echo Please set ANTLR_JAR environment variable to point to your antlr jar
    exit /b 1
)

REM Set paths relative to the script location's parent folder
set "SCRIPT_DIR=%~dp0"
REM Remove trailing backslash from SCRIPT_DIR
set "SCRIPT_DIR=%SCRIPT_DIR:~0,-1%"
set "PROJECT_DIR=%SCRIPT_DIR%\.."
set "GRAMMAR_DIR=%PROJECT_DIR%\grammar"
set "GENERATED_DIR=%PROJECT_DIR%\generated"
set "TESTS_DIR=%PROJECT_DIR%\tests"

REM Create generated directory if it doesn't exist
if not exist "%GENERATED_DIR%" mkdir "%GENERATED_DIR%"

REM Clean previous generated files
echo Cleaning previous generated files...
if exist "%GENERATED_DIR%\*.java" del /Q "%GENERATED_DIR%\*.java"
if exist "%GENERATED_DIR%\*.py" del /Q "%GENERATED_DIR%\*.py"
if exist "%GENERATED_DIR%\*.class" del /Q "%GENERATED_DIR%\*.class"

echo Generating parser from grammar...
java -jar "%ANTLR_JAR%" -visitor -o "%GENERATED_DIR%" "%GRAMMAR_DIR%\pjlang.g4"
java -jar "%ANTLR_JAR%" -Dlanguage=Python3 -visitor -o "%GENERATED_DIR%" "%GRAMMAR_DIR%\pjlang.g4"
if %errorlevel% neq 0 (
    echo ERROR: Failed to generate parser
    exit /b %errorlevel%
)

echo Compiling generated Java files...
pushd "%GENERATED_DIR%"
javac -g *.java
popd
if %errorlevel% neq 0 (
    echo ERROR: Failed to compile generated files
    exit /b %errorlevel%
)

echo Running test file...
java -cp "%GENERATED_DIR%;%ANTLR_JAR%" org.antlr.v4.gui.TestRig pjlang program -gui "%TESTS_DIR%\test.pj"
if %errorlevel% neq 0 (
    echo ERROR: Test execution failed
    exit /b %errorlevel%
)

echo Done!