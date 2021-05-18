/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

/**
 *
 * @author camran1234
 */
public class Redirect extends Instruccion{
    private int line,column;
    
    public Redirect(int line, int column){
        this.line = line;
        this.column = column;
    } 
}
