#!/usr/bin/zsh
source ~/.zshrc

cd grammar
antlr4 pjlang.g4 -visitor  -o ../generated
antlr4 -Dlanguage=Python3 -visitor pjlang.g4 -o ../generated  
cd ../generated
touch __init__.py
javac *.java
echo Running:
# grun pjlang program -gui ../test2.mylang
