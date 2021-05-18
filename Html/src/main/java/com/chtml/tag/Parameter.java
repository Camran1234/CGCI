/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.tag;

import com.chtml.table.SymbolTable;

/**
 *
 * @author camran1234
 */
public class Parameter{
    /*
    types{
    Variables : int, string, char, boolean, decimal;
    Special : getElement, 
    
    */
    
    private String parameter="";
    private String value="";
    public int line;
    public int column;
    private boolean started=false;
    
    public Parameter(String typeParameter){
        this.parameter = typeParameter;
        if(typeParameter.equalsIgnoreCase("type")){
            this.value = "text";
        }else if(typeParameter.equalsIgnoreCase("text-align")){
            this.value = "number";
        }else if(typeParameter.equalsIgnoreCase("font-family")){
            this.value="Arial";
        }
    }
    
    public Parameter(String typeParameter, String value, int line, int column){
        this.started=true;
        this.parameter =  typeParameter;
        this.value = value;
        this.line = line;
        this.column=column;
    }
    
    public void setValue(String parameter){
        this.value = String.valueOf(parameter);
        this.started=true;
        if(value.charAt(0)=='\"' && value.charAt(value.length()-1)=='\"' ){
            value = value.substring(1, value.length()-1);
        }
    }
    
    /**
     * Use this more in the script
     * @param parameter 
     */
    public void setRawValue(String parameter){
        this.value = String.valueOf(parameter);
        this.started=true;
    }
    
    /**
     * Function that works better with the parameter and logic of text
     * @param value 
     */
    public void pushValue(String value){
        this.value += value;
        this.started = true;
    }
    
    
    
    public void setPosition(String line, String column){
        this.line = Integer.parseInt(line);
        this.column = Integer.parseInt(column);
    }
    
    public String getRawParameter(){
        return this.parameter;
    }
    
    /**
     * Parametro es el tipo
     * @return 
     */
    public String getParameter(){
        if(parameter.equalsIgnoreCase("variable")){
            SymbolTable table = new SymbolTable();
            String newParameter = table.getTypeVariable(value, line, column);
            if(newParameter.equalsIgnoreCase("")){
                return "";
            }else{
                return newParameter;
            }         
        }else{
            return this.parameter;
        }
        
    }
    
    public String value(){
        if(parameter.equalsIgnoreCase("variable")){
            SymbolTable table = new SymbolTable();
            Parameter newParameter = table.getValueVariable(value, line, column);
            if(newParameter!=null){
                String newValue = newParameter.value();
                return newValue;
            }else{
                return "null";
            }
        }else{
            return this.value;
        }
    }
    
    public void setParameter(String newParameter){
        this.parameter = newParameter;
        
    }
    
    public boolean isStarted(){
        return started;
    }
    
    /**
     * Special action for the code
     * Return a html code for the parameter
     * @return 
     */
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        if(this.started){
            switch(parameter){
            case"href":
                string.append("href=\""+value+"\" ");
                break;
            case "background":
                string.append("background-color:"+value+"; ");
                break;
            case "color":
                string.append("color:"+value+"; ");
                break;
            case "font-size":
                string.append("font-size:"+value+"; ");
                break;
            case "font-family":
                string.append("font-family:"+value+"; ");
                break;
            case "text-align":
                string.append("text-align:"+value+" ");
                break;
            case "type":
                string.append("type=\""+value+"\" ");
                break;
            case "id":
                string.append("id=\""+value+"\" ");
                break;
            case "name":
                break;
            case "cols":
                string.append("cols=\""+value+"\" ");
                break;
                
            case "rows":
                string.append("rows=\""+value+"\" ");
                break;
                
            case "class":
                string.append("class=\""+value  +"\" ");
                break;
                
            case "src":
                string.append("src=\""+value+"\" ");
                break;
            case "width":
                string.append("width=\""+value+"\" ");
                break;
            case "height":
                string.append("height=\""+value+"\" ");
                break;
            case "alt":
                string.append("alt=\""+value+"\" ");
                break;
            case "onclick":
                string.append("onclick=\""+value.replace("()","(this)")+"\" ");
                break;
            case "text":
                //Los unicos que tienen esta etiqueta son la etiqueta script
                //y la etiqueta option
                string.append(value);
                break;
            case "int":
                string.append(value);
                break;
            case "string":
                if(this.value.contains("document.getElementById(")){
                    string.append(value);
                }else{
                    string.append("\""+value+"\"");
                }
                break;
            case "char":
                string.append("\'"+value+"\'");
                break;
            case "decimal":
                string.append(value);
                break;
            case "boolean":
                string.append(value);
                break;
            case "variable":
                string.append(value);
                break;
                
                
            }
        }
        
        
        return string.toString();
    }
}
