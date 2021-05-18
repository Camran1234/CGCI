/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.semantic;

import static com.script.parser.ScriptSyntax.errors;

/**
 *
 * @author camran1234
 */
public class SyntaxError extends Error{
    boolean showLine=false;
    
    
    public SyntaxError(String mensaje, String tokenError, String info, int line, int column, boolean showLine){
        super(mensaje, tokenError, line, column);
        this.info = info;
        this.showLine = showLine;
    }
    
    public String getMessage(){
        if(line==-1 && column ==-1){
            return (" +)"+ info + " en "+tokenError+": "+ mensaje + " [linea: cerca del final, columna: cerca del final");
        }else{
            return ("  +)"+ info + " en "+tokenError+": "+ mensaje + " [linea: "+line+" columna: "+column+"]");
        }
    }
    
}
