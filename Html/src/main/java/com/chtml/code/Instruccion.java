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
public class Instruccion {
    Object context;
    public int line, column;
    
    public void setContext(Object context){
        this.context = context;
    }
    
    
    public String writeCode(){
        return "";
    }
    
    public void execute(){
        //throw nothing
        System.out.println("Something");
    }   
    
    public Object getContext(){
        return context;
    }
}
