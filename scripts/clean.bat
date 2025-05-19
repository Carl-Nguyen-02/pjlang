@echo off
echo Cleaning generated files...

REM Set paths relative to the script location
set "GENERATED_DIR=%~dp0..\generated"

if not exist "%GENERATED_DIR%" (
    echo Warning: Generated directory not found at %GENERATED_DIR%
    exit /b 0
)

cd "%GENERATED_DIR%"
@REM remove __pycache__ directory
if exist __pycache__ (
    rmdir /s /q __pycache__ 2>nul
)
del *.class 2>nul
del *.interp 2>nul
del *.java 2>nul
del *.tokens 2>nul
del *.py 2>nul

echo Cleanup complete.