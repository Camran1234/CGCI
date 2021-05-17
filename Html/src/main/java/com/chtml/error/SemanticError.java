/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.error;

/**
 *
 * @author camran1234
 */
public class SemanticError extends Error{
    
    
    public SemanticError(String mensaje, String tokenError,String solution, int line, int column){
        super(mensaje, tokenError, line, column);
        this.info = "Error Semantico";
        this.solution=solution;
    }        
    
    public String getMessage(){
        if(line==-1 && column ==-1){
            return (info + " en "+tokenError+": "+ mensaje  + " ("+solution+") [linea: cerca del final, columna: cerca del final\n");
        }else{
            return (info + " en "+tokenError+": "+ mensaje +" ("+solution+ ") [linea: "+line+" columna: "+column+"]\n");
        }
    }
}
