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
public class Error {
    String mensaje="";
    String info="";
    String tokenError="";
    int line=0;
    int column=0;
    
    public Error(String mensaje, String tokenError, int line, int column){
        this.mensaje = mensaje;
        this.tokenError = tokenError;
        this.line = line;
        this.column = column;
    }
    
    
}
