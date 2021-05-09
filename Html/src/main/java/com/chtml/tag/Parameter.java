/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.tag;

/**
 *
 * @author camran1234
 */
public class Parameter{
    private String parameter="";
    public String value="";
    private int line;
    private int column;
    private boolean started=false;
    
    public Parameter(String typeParameter){
        this.parameter = typeParameter;
        if(typeParameter.equalsIgnoreCase("type")){
            this.value = "left";
        }
    }
    
    public void setValue(String parameter){
        this.value = parameter;
        this.started=true;
        if(value.charAt(0)=='\"' && value.charAt(value.length()-1)=='\"' ){
            value = value.substring(1, value.length()-1);
        }
    }
    
    /**
     * Function that works better with the parameter and logic of text
     * @param value 
     */
    public void pushValue(String value){
        this.value += value;
        this.started = true;
    }
    
    public String get(){
        return value;
    }
    
    public void setPosition(String line, String column){
        this.line = Integer.parseInt(line);
        this.column = Integer.parseInt(column);
    }
    
    public String getParameter(){
        return this.parameter;
    }
    
    public void setParameter(String newParameter){
        this.parameter = newParameter;
    }
    
    public boolean isEmpty(){
        return started;
    }
}
