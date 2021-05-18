package com.chtml.html;
//imports
import static com.chtml.html.HtmlSym.*;
import java_cup.runtime.Symbol;
%%

%class ChtmlLex
%cup
%line
%column
%public

%{

%}

LineTerminator = \r|\n|\r\n
WhiteSpace     =  {LineTerminator}|[ \t\f]
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
String = \"[^"\""]*\"
Commentary = "!!"[^\n]+
BlockCommentary = <!--([^-]|-[^-]|--+[^->])*-*-->
Number = [-]?([0-9]*[.])?[0-9]+
Char = \'[^\']*\'

%%

<YYINITIAL> {

    //Symbols
    "<" {System.out.println("<");
        return new Symbol(LESS, yyline + 1, yycolumn + 1, yytext());}
    ">" {System.out.println(">");
        return new Symbol(GREATER, yyline + 1, yycolumn + 1, yytext());}
    "/" {System.out.println("DIV: /");
        return new Symbol(DIV, yyline + 1, yycolumn + 1, yytext());}
    "(" {System.out.println("(");
        return new Symbol(OPEN_PARENTHESIS, yyline + 1, yycolumn + 1, yytext());}
    ")" {System.out.println(")");
        return new Symbol(CLOSE_PARENTHESIS, yyline + 1, yycolumn + 1, yytext());}
    "[" {System.out.println("[");
        return new Symbol(OPEN_BRACKET, yyline + 1, yycolumn + 1, yytext());}
    "]" {System.out.println("]");
        return new Symbol(CLOSE_BRACKET, yyline + 1, yycolumn + 1, yytext());}
    "=" {System.out.println("=");
        return new Symbol(EQUAL, yyline + 1, yycolumn + 1, yytext());}
    //Script
    {C_SCRIPTING} {System.out.println("C_SCRIPTING");
        return new Symbol(C_SCRIPTING, yyline + 1, yycolumn + 1, yytext());}

    //Etiquetas
    {C_GCIC} {System.out.println("C_GCIC");
            return new Symbol(C_GCIC, yyline + 1, yycolumn + 1, yytext());}
    {C_HEAD} {System.out.println("C_HEAD");
            return new Symbol(C_HEAD, yyline + 1, yycolumn + 1, yytext());}
    {C_TITLE} {System.out.println("C_TITLE");
            return new Symbol(C_TITLE, yyline + 1, yycolumn + 1, yytext());}
    {C_LINK} {System.out.println("C_LINK");
            return new Symbol(C_LINK, yyline + 1, yycolumn + 1, yytext());}
    {C_BODY} {System.out.println("C_BODY");
            return new Symbol(C_BODY, yyline + 1, yycolumn + 1, yytext());}
    {C_SPAM} {System.out.println("C_SPAM");
        return new Symbol(C_SPAM, yyline + 1, yycolumn + 1, yytext());}
    {C_INPUT} {System.out.println("C_INPUT");
        return new Symbol(C_INPUT, yyline + 1, yycolumn + 1, yytext());}
    {C_TEXTAREA} {System.out.println("C_TEXTAREA");
        return new Symbol(C_TEXTAREA, yyline + 1, yycolumn + 1, yytext());}
    {C_SELECT} {System.out.println("C_SELECT");
        return new Symbol(C_SELECT, yyline + 1, yycolumn + 1, yytext());}
    {C_OPTION} {System.out.println("C_OPTION");
        return new Symbol(C_OPTION, yyline + 1, yycolumn + 1, yytext());}
    {C_DIV} {System.out.println("C_DIV");
        return new Symbol(C_DIV, yyline + 1, yycolumn + 1, yytext());}
    {C_IMG} {System.out.println("C_IMG");
        return new Symbol(C_IMG, yyline + 1, yycolumn + 1, yytext());}
    {C_BR} {System.out.println("C_BR");
        return new Symbol(C_BR, yyline + 1, yycolumn + 1, yytext());}
    {C_BUTTON} {System.out.println("C_BUTTON");
        return new Symbol(C_BUTTON, yyline + 1, yycolumn + 1, yytext());}
    {C_H1} {System.out.println("C_H1");
        return new Symbol(C_H1, yyline + 1, yycolumn + 1, yytext());}
    {C_P} {System.out.println("C_P");
        return new Symbol(C_P, yyline + 1, yycolumn + 1, yytext());}
    {String} {System.out.println(yytext());
        return new Symbol(STRING, yyline + 1, yycolumn + 1, yytext());}
    {Char} {System.out.println(yytext());
        return new Symbol(CHAR, yyline + 1, yycolumn + 1, yytext());}
    //Parametros
    "href" {System.out.println("href");
        return new Symbol(HREF, yyline + 1, yycolumn + 1, yytext());}
    "background" {System.out.println("background");
        return new Symbol(BACKGROUND, yyline + 1, yycolumn + 1, yytext());}
    "color" {System.out.println("color");
        return new Symbol(COLOR, yyline + 1, yycolumn + 1, yytext());}
    "font-size" {System.out.println("font-size");
        return new Symbol(FONTSIZE, yyline + 1, yycolumn + 1, yytext());}
    "font-family" {System.out.println("font-family");
        return new Symbol(FONTFAMILY, yyline + 1, yycolumn + 1, yytext());}
    "text-align" {System.out.println("text-align");
        return new Symbol(TEXTALIGN, yyline + 1, yycolumn + 1, yytext());}
    "type" {System.out.println("type");
        return new Symbol(TYPE, yyline + 1, yycolumn + 1, yytext());}
    "text" {System.out.println("text");
        return new Symbol(TEXT, yyline + 1, yycolumn + 1, yytext());}
    "number" {System.out.println("number");
        return new Symbol(NUMBER, yyline + 1, yycolumn + 1, yytext());}
    "radio" {System.out.println("radio");
        return new Symbol(RADIO, yyline + 1, yycolumn + 1, yytext());} 
    "checkbox" {System.out.println("checkbox");
        return new Symbol(CHECKBOX, yyline + 1, yycolumn + 1, yytext());}
    "id" {System.out.println("id");
        return new Symbol(IDE, yyline + 1, yycolumn + 1, yytext());}
    "name" {System.out.println("name");
        return new Symbol(NAME, yyline + 1, yycolumn + 1, yytext());}
    "cols" {System.out.println("cols");
        return new Symbol(COLS, yyline + 1, yycolumn + 1, yytext());}
    "rows" {System.out.println("rows");
        return new Symbol(ROWS, yyline + 1, yycolumn + 1, yytext());}
    "class" {System.out.println("class");
        return new Symbol(CLASS, yyline + 1, yycolumn + 1, yytext());}
    "row" {System.out.println("row");
        return new Symbol(ROW, yyline + 1, yycolumn + 1, yytext());}
    "column" {System.out.println("column");
        return new Symbol(COLUMNS, yyline + 1, yycolumn + 1, yytext());}
    "src" {System.out.println("src");
        return new Symbol(SRC, yyline + 1, yycolumn + 1, yytext());}
    "width" {System.out.println("width");
        return new Symbol(WIDTH, yyline + 1, yycolumn + 1, yytext());}
    "height" {System.out.println("height");
        return new Symbol(HEIGHT, yyline + 1, yycolumn + 1, yytext());}
    "alt" {System.out.println("alt");
        return new Symbol(ALT, yyline + 1, yycolumn + 1, yytext());}
    "onclick"   {System.out.println("onclick");
        return new Symbol(ONCLICK, yyline + 1, yycolumn + 1, yytext());}

    {WhiteSpace}    {return new Symbol(SPACE, yyline + 1, yycolumn + 1, yytext());}   
    {Commentary}    {/*empty*/}
    {BlockCommentary} {/*empty*/}
}

[^=\\(\\)"[""]""\"""\'"\n\r\t\s<>/]+ {System.out.println("OPTION: "+yytext());
                        return new Symbol(OPTION, yyline + 1, yycolumn + 1, yytext());}

