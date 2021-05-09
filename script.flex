package com.script.parser;
//imports
import static com.script.parser.ScriptSym.*;
import java_cup.runtime.Symbol;
%%

%class ScriptLex
%cup
%line
%column
%public

%{

%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
C_GCIC = [cC]"_"[gG][cC][iI][cC]
C_HEAD = [cC]"_"[hH][eE][aA][dD]
C_TITLE = [cC]"_"[tT][iI][tT][lL][eE]
C_LINK = [cC]"_"[lL][iI][nN][kK]
C_BODY = [cC]"_"[bB][oO][dD][yY]
C_SPAM = [cC]"_"[sS][pP][aA][mM]
C_INPUT = [cC]"_"[iI][nN][pP][uU][tT]
C_TEXTAREA = [cC]"_"[tT][eE][xX][tT][aA][rR][eE][aA]
C_SELECT = [cC]"_"[sS][eE][lL][eE][cC][tT]
C_OPTION = [cC]"_"[oO][pP][tT][iI][oO][nN]
C_DIV = [cC]"_"[dD][iI][vV]
C_IMG = [cC]"_"[iI][mM][gG]
C_BR = [cC]"_"[bB][rR]
C_BUTTON = [cC]"_"[bB][uU][tT][tT][oO][nN]
C_H1 = [cC]"_"[hH]"1"
C_P = [cC]"_"[pP]
C_SCRIPTING = [cC]"_"[sS][cC][rR][iI][pP][tT][iI][nN][gG] 
String = \"[^\"]*\"
Commentary = "!!"[^\n]+
BlockCommentary = <!--([^-]|-[^-]|--+[^->])*-*-->
Decimal = (([1-9][0-9]*|0?)[.])[0-9]+
Number = [0-9]+
Char = \'[^\']*\'
IdVariable = [aA-zZ][[aA-zZ]|[0-9]|[_]]*
Process = [P][R][O][C][E][S][S][_][^ \\(\\)\n\t\r]+

%%

<YYINITIAL> {
    //Palabras RESERVADAS
    "INIT"  {
            return new Symbol(INIT, yyline + 1, yycolumn + 1, yytext());}
    "END"   {
        return new Symbol(END, yyline + 1, yycolumn + 1, yytext());}
    "IF"    {
            return new Symbol(IF, yyline + 1, yycolumn + 1, yytext());}
    "THEN"  {
            return new Symbol(THEN, yyline + 1, yycolumn + 1, yytext());}
    "ELSE"  {
            return new Symbol(ELSE, yyline + 1, yycolumn + 1, yytext());}
    "REPEAT"    {
                return new Symbol(REPEAT, yyline + 1, yycolumn + 1, yytext());}
    "HUNTIL"    {
                return new Symbol(HUNTIL, yyline + 1, yycolumn + 1, yytext());}
    "INSERT"    {
                return new Symbol(INSERT, yyline + 1, yycolumn + 1, yytext());}
    "WHILE" {
            return new Symbol(WHILE, yyline + 1, yycolumn + 1, yytext());}
    "THENWHILE" {
                return new Symbol(THENWHILE, yyline + 1, yycolumn + 1, yytext());}
    "ON_LOAD" {
            return new Symbol(ONLOAD, yyline + 1, yycolumn + 1, yytext());}
    "true"  {
            return new Symbol(TRUE, yyline + 1, yycolumn + 1, yytext());}
    "false" {
            return new Symbol(FALSE, yyline + 1, yycolumn + 1, yytext());}
    "@global" {
            return new Symbol(GLOBAL, yyline + 1, yycolumn + 1, yytext());}
    {String} {
            return new Symbol(STRING, yyline + 1, yycolumn + 1, yytext());}
    {Process} {
            return new Symbol(PROCESS, yyline + 1, yycolumn + 1, yytext());}
    //Operadores LOGICOS
    "||"    {
            return new Symbol(OR, yyline + 1, yycolumn + 1, yytext());}
    "&&"    {
            return new Symbol(AND, yyline + 1, yycolumn + 1, yytext());}
    "!" {
            return new Symbol(NOT, yyline + 1, yycolumn + 1, yytext());}

    //Operadores RELACIONALES
    "==" {
            return new Symbol(EQUALIZATION, yyline + 1, yycolumn + 1, yytext());}
    "!=" {
            return new Symbol(DIFFERENTIATION, yyline + 1, yycolumn + 1, yytext());}
    "<="    {
            return new Symbol(LESSTHAN, yyline + 1, yycolumn + 1, yytext());}
    ">="    {
            return new Symbol(GREATERTHAN, yyline + 1, yycolumn + 1, yytext());}
    "<"    {
            return new Symbol(LESS, yyline + 1, yycolumn + 1, yytext());}
    ">" {
        return new Symbol(GREATER, yyline + 1, yycolumn + 1, yytext());}

    //Operadores ARITMETICOS
    "+" {
        return new Symbol(SUMA, yyline + 1, yycolumn + 1, yytext());}
    "-" {
        return new Symbol(RESTA, yyline + 1, yycolumn + 1, yytext());}
    "/" {
        return new Symbol(DIV, yyline + 1, yycolumn + 1, yytext());}
    "*" {
        return new Symbol(MULT, yyline + 1, yycolumn + 1, yytext());}

    //FUNCIONES ESPECIALES
    "ASC"   {
            return new Symbol(ASC, yyline + 1, yycolumn + 1, yytext());}
    "DESC"  {
            return new Symbol(DESC, yyline + 1, yycolumn + 1, yytext());}
    "LETPAR_NUM"    {
                    return new Symbol(LETPAR_NUM, yyline + 1, yycolumn + 1, yytext());}
    "LETIMPAR_NUM"  {
                    return new Symbol(LETIMPAR_NUM, yyline + 1, yycolumn + 1, yytext());}
    "REVERSE"   {
                return new Symbol(REVERSE, yyline + 1, yycolumn + 1, yytext());}
    "CARACTER_ALEATORIO"    {
                            return new Symbol(CARACTER_ALEATORIO, yyline + 1, yycolumn + 1, yytext());}
    "NUM_ALEATORIO" {
                    return new Symbol(NUM_ALEATORIO, yyline + 1, yycolumn + 1, yytext());}
    "ALERT_INFO"    {
                    return new Symbol(ALERT_INFO, yyline + 1, yycolumn + 1, yytext());}
    "EXIT"  {
            return new Symbol(EXIT, yyline + 1, yycolumn + 1, yytext());}

    //Datos VARIABLES
    "integer"   {
                return new Symbol(INTEGER, yyline + 1, yycolumn + 1, yytext());}
    "decimal"   {
                return new Symbol(DECIMAL, yyline + 1, yycolumn + 1, yytext());}
    "boolean"   {
                return new Symbol(BOOLEAN, yyline + 1, yycolumn + 1, yytext());}
    "char"  {
                return new Symbol(CHAR, yyline + 1, yycolumn + 1, yytext());}
    "string"    {
                return new Symbol(STRINGVAR, yyline + 1, yycolumn + 1, yytext());}

    //Simbolos
    "=" {
        return new Symbol(EQUAL, yyline + 1, yycolumn + 1, yytext());}
    ";" {
        return new Symbol(COLON, yyline + 1, yycolumn + 1, yytext());}
    ":" {
        return new Symbol(SEMICOLON, yyline + 1, yycolumn + 1, yytext());}
    "," {
        return new Symbol(COMA, yyline + 1, yycolumn + 1, yytext());}
    "{" {
        return new Symbol(OPEN_CURLY, yyline + 1, yycolumn + 1, yytext());}
    "}" {
        return new Symbol(CLOSE_CURLY, yyline + 1, yycolumn + 1, yytext());}
    "[" {
        return new Symbol(OPEN_BRACKET, yyline + 1, yycolumn + 1, yytext());}
    "]" {
        return new Symbol(CLOSE_BRACKET, yyline + 1, yycolumn + 1, yytext());}
    "(" {
        return new Symbol(OPEN_PARENTHESIS, yyline + 1, yycolumn + 1, yytext());}
    ")" {
        return new Symbol(CLOSE_PARENTHESIS, yyline + 1, yycolumn + 1, yytext());}
    {Number}    {
                return new Symbol(NUMBER, yyline + 1, yycolumn + 1, yytext());}
    {Decimal}   {
                return new Symbol(DECIMAL, yyline + 1, yycolumn + 1, yytext());}
    {Char}  {
            return new Symbol(SYMCHAR, yyline + 1, yycolumn + 1, yytext());}
    "getElemenById" {
                    return new Symbol(GETELEMENT, yyline + 1, yycolumn + 1, yytext());}


    //Declaracion y asignacion de VARIABLES
    {IdVariable}    {
                    return new Symbol(IDVARIABLE, yyline + 1, yycolumn + 1, yytext());}
    

    {WhiteSpace}    {/*empty*/}   
    {Commentary}    {/*empty*/}
    {BlockCommentary} {/*empty*/}
}
[^-=:\\{\\}\\(\\)"[""]""\"""\'"\n\r\t\s<>/[0-9];]+ {System.out.println("Token: INVALIDATE, Lexema: "+yytext());}

