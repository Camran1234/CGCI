/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.variables;

/**
 *
 * @author camran1234
 */
public class Variable {
    String modo = "-";
    String type = "";
    String name = "";
    Object value = null;
    boolean error = false;
    String errorMessage = "";
    int line;
    int column;
    
    public Variable(){
        
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public void setName(String name, int line, int column){
        this.name = name;
    }
    
    /**
     * Set value of the variable
     * Can be Integer, String, Character, 
     * @param value 
     */
    public void setValue(String value, int line, int column){
        this.value = value;
    }
    
    public void checkInt(){
        if(this.type.equalsIgnoreCase("integer")){
            if(this.value instanceof Character){
                error = false;
            }else{
                errorMessage = "El valor de la variable "+name+" no es un integer";
                error = true;
            }
        }
    }
    
    public void checkDecimal(){
        if(this.type.equalsIgnoreCase("decimal")){
            if(this.value instanceof Character){
                error = false;
            }else{
                errorMessage = "El valor no es un decimal";
                error = true;
            }
        }
    }
    
    public void checkBoolean(){
        if(this.type.equalsIgnoreCase("boolean")){
            if(this.value instanceof Character){
                error = false;
            }else{
                errorMessage = "El valor no es un boleano";
                error = true;
            }
        }
    }
    
    public void checkChar(){
        if(this.type.equalsIgnoreCase("char")){
            if(this.value instanceof Character){
                error = false;
            }else{
                errorMessage = "El valor no es un char";
                error = true;
            }
        }
    }
    
    public void checkString(){
        if(this.type.equalsIgnoreCase("string")){
            if(this.value instanceof String){
                error = false;
            }else{
                errorMessage = "El valor no es un String";
                error = true;
            }
        }
    }
}
