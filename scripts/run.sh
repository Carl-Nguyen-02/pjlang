#!/usr/bin/zsh
source ~/.zshrc

cd ../grammar
antlr4 mylang.g4 -o ..
cd ..
javac *.java
echo Running:
grun mylang program -gui tests/test.mylang
