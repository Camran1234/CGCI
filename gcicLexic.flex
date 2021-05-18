
%%

%class ChtmlLex
%standalone
%line
%column
%public

%{
      StringBuffer string = new StringBuffer();
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
String = \"[^"\""]*\"
Commentary = "!!"[^\n]+
BlockCommentary = <!--([^-]|-[^-]|--+[^->])*-*-->
Number = [-]?([0-9]*[.])?[0-9]+
Char = \'[^\']\'

%state STRING

%%

<YYINITIAL> {

    //Symbols
    "<" {System.out.println("Token: LESS, Lexema: "+yytext());
        }
    ">" {System.out.println("Token: GREATER, Lexema: "+yytext());
        }
    "/" {System.out.println("Token: DIV, Lexema: "+yytext());
        }
    "(" {System.out.println("Token: OPEN_PARENTHESIS, Lexema: "+yytext());
        }
    ")" {System.out.println("Token: CLOSE_PARENTHESIS, Lexema: "+yytext());
        }
    "[" {System.out.println("Token: OPEN_BRACKET, Lexema: "+yytext());
        }
    "]" {System.out.println("Token: CLOSE_BRACKET, Lexema: "+yytext());
        }
    "=" {System.out.println("Token: EQUAL, Lexema: "+yytext());
        }
    //Script
    {C_SCRIPTING} {System.out.println("Token: C_SCRIPTING, Lexema: "+yytext());
        }

    //Etiquetas
    {C_GCIC} {System.out.println("Token: C_GCIC, Lexema: "+yytext());
            }
    {C_HEAD} {System.out.println("Token: C_HEAD, Lexema: "+yytext());
            }
    {C_TITLE} {System.out.println("Token: C_TITLE, Lexema: "+yytext());
            }
    {C_LINK} {System.out.println("Token: C_LINK, Lexema: "+yytext());
            }
    {C_BODY} {System.out.println("Token: C_BODY, Lexema: "+yytext());
            }
    {C_SPAM} {System.out.println("Token: C_SPAM, Lexema: "+yytext());
        }
    {C_INPUT} {System.out.println("Token: C_INPUT, Lexema: "+yytext());
        }
    {C_TEXTAREA} {System.out.println("Token: C_TEXTAREA, Lexema: "+yytext());
        }
    {C_SELECT} {System.out.println("Token: C_SELECT, Lexema: "+yytext());
        }
    {C_OPTION} {System.out.println("Token: C_OPTION, Lexema: "+yytext());
        }
    {C_DIV} {System.out.println("Token: C_DIV, Lexema: "+yytext());
        }
    {C_IMG} {System.out.println("Token: C_IMG, Lexema: "+yytext());
        }
    {C_BR} {System.out.println("Token: C_BR, Lexema: "+yytext());
        }
    {C_BUTTON} {System.out.println("Token: C_BUTTON, Lexema: "+yytext());
        }
    {C_H1} {System.out.println("Token: C_H1, Lexema: "+yytext());
        }
    {C_P} {System.out.println("Token: C_P, Lexema: "+yytext());
        }
    \" {string.setLength(0); yybegin(STRING);
        }
    //Parametros
    "href" {System.out.println("Token: HREF, Lexema: "+yytext());
        }
    "background" {System.out.println("Token: BACKGROUND, Lexema: "+yytext());
        }
    "color" {System.out.println("Token: COLOR, Lexema: "+yytext());
        }
    "font-size" {System.out.println("Token: FONTSIZE, Lexema: "+yytext());
        }
    "font-family" {System.out.println("Token: FONTFAMILY, Lexema: "+yytext());
        }
    "text-align" {System.out.println("Token: TEXTALIGN, Lexema: "+yytext());
        }
    "type" {System.out.println("Token: TYPE, Lexema: "+yytext());
        }
    "text" {System.out.println("Token: TEXT, Lexema: "+yytext());
        }
    "number" {System.out.println("Token: NUMBER, Lexema: "+yytext());
        }
    "radio" {System.out.println("Token: RADIO, Lexema: "+yytext());
        } 
    "checkbox" {System.out.println("Token: CHECKBOX, Lexema: "+yytext());
        }
    "id" {System.out.println("Token: IDE, Lexema: "+yytext());
        }
    "name" {System.out.println("Token: NAME, Lexema: "+yytext());
        }
    "cols" {System.out.println("Token: COLS, Lexema: "+yytext());
        }
    "rows" {System.out.println("Token: ROWS, Lexema: "+yytext());
        }
    "class" {System.out.println("Token: CLASS, Lexema: "+yytext());
        }
    "row" {System.out.println("Token: ROW, Lexema: "+yytext());
        }
    "column" {System.out.println("Token: COLUMNS, Lexema: "+yytext());
        }
    "src" {System.out.println("Token: SRC, Lexema: "+yytext());
        }
    "width" {System.out.println("Token: WIDTH, Lexema: "+yytext());
        }
    "height" {System.out.println("Token: HEIGHT, Lexema: "+yytext());
        }
    "alt" {System.out.println("Token: ALT, Lexema: "+yytext());
        }
    "onclick"   {System.out.println("Token: ONCLICK, Lexema: "+yytext());
        }

    {WhiteSpace}    {/*empty*/}   
    {Commentary}    {/*empty*/}
    {BlockCommentary} {/*empty*/}
}

<STRING> {
      \"                             { yybegin(YYINITIAL);
                                        System.out.println("Token: STRING, Lexema: \""+string.toString()+"\"");
                                        }
      [^\"]+                   { string.append( yytext() ); }
    }

[^\"=\\(\\)"[""]"\n\r\t\s<>/]+ {System.out.println("Token: OPTION, Lexema: \'"+yytext()+"\'");}

