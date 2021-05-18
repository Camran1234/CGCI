/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.table;

import com.chtml.code.Function;
import com.chtml.code.Instruccion;
import com.chtml.tag.CBody;
import com.chtml.tag.Tag;
import com.chtml.tag.*;
/**
 * Class to storage all the symbols with id 
 * @author camran1234
 */
public class SymbolV {
    private String id= "";
    //Manejar el valor preferiblemente como Parameter   
    private Object value=null;
    private String type="";
    private boolean isGlobal=false;
    private Object context = null;
    private int line=0;
    private int column=0;
    
    
    
    
    public SymbolV(String id, String type, int line, int column, Object context,boolean isGlobal){
        this.id = id;
        this.isGlobal=isGlobal;
        this.line = line;
        this.column = column;
        this.context = context;
    }
    
    public SymbolV(String id, String type, int line, int column, Object value, Object context, boolean isGlobal){
        this.id = id;
        this.line = line;
        this.column = column;
        this.type = type;
        this.value = value;
        this.context = context;
        this.isGlobal = isGlobal;
    }
    
    public boolean isGlobal(){
        return isGlobal;
    }

    public String getContextName(){
        StringBuffer string = new StringBuffer();
        if(context==null){
            string.append("C_SCRIPTING");
        }else if(context instanceof Tag){
            if(context instanceof CBody){
                string.append("C_BODY");
            }else if(context instanceof CBr){
                string.append("C_BR");
            }else if(context instanceof CDiv){
                string.append("C_DIV");
            }else if(context instanceof CGcic){
                string.append("C_GCIC");
            }else if(context instanceof CH1){
                string.append("C_H1");
            }else if(context instanceof CHead){
                string.append("C_HEAD");
            }else if(context instanceof CImg){
                string.append("C_IMG");
            }else if(context instanceof CInput){
                string.append("C_INPUT");
            }else if(context instanceof CLink){
                string.append("C_LINK");
            }else if(context instanceof COption){
                string.append("C_OPTION");
            }else if(context instanceof CP){
                string.append("C_P");
            }else if(context instanceof CScripting){
                string.append("C_SCRIPTING");
            }else if(context instanceof CSelect){
                string.append("C_SELECT");
            }else if(context instanceof CSpam){
                string.append("C_SPAM");
            }else if(context instanceof CText){
                string.append("C_TEXT");
            }else if(context instanceof CTextArea){
                string.append("C_TEXTAREA");
            }else if(context instanceof CTitle){
                string.append("C_TITLE");
            }
        }else{
            Object auxiliar = context;
            String name="";
            while(true){
                if(auxiliar instanceof Function){
                    name = ((Function) auxiliar).getName();
                    break;
                }else{
                    Instruccion instruccion = (Instruccion)auxiliar;
                    auxiliar = instruccion.getContext();
                }
            }
            string.append(name);
        }
        return string.toString();
    }
    
    public void setValue(Object value){
        this.value = value;
    }
    
    public String getMode(){
        if(isGlobal){
            return "@global";
        }else{
            return "-";
        }
    }
    
    public String getNameId() {
        return id;
    }

    public String getType(){
        return type;
    }
    
    public Object getContext(){
        return context;
    }
    
    public Object getValue() {
        return value;
    }
    
    public String getValor(){
        StringBuffer string = new StringBuffer();
        
        if(this.value==null){
            string.append("null");
        }else if(this.value instanceof Parameter){
            Parameter parametro = (Parameter)value;
            string.append(parametro.value());
        }
        
        return string.toString();
    }
    
    public int getLine(){
        return line;
    }
    
    public int getColumn(){
        return column;
    }
    
    public void setLine(int line){
        this.line = line;
    }
    
    public void setColumn(int column){
        this.column = column;
    }
    
    
    /**
     * Return true if its the same id 
     * Return false if its different id
     * @param compareSymbol
     * @return 
     */
    public boolean compareSymbol(SymbolV compareSymbol){
        String compareId = compareSymbol.getNameId();                 
        Object context = compareSymbol.getContext();
        
        if(context==null || this.context==null){
            return false;
        }
        
        if(compareId.equalsIgnoreCase("")){
            return false;
        }
        if(this.id.equals(compareId)){
            if(this.context.equals(context)){
                System.out.println("Something");
            }
        }
        
        if(this.id.equals(compareId) && this.context.equals(context) ){
            if(this.context instanceof SymbolTable){
                if(this.type.equals(compareSymbol.getType())){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public void updateOne() {
        if(this.type.equalsIgnoreCase("int")){
            Parameter parameter = (Parameter) this.value;
            int number = Integer.parseInt(parameter.value()) +1;
            //Copiamos todo y lo unico que cambiamos es el valor
            Parameter nuevo = new Parameter("int",Integer.toString(number),parameter.line, parameter.column);
            this.value = nuevo;
        }
    }
    
}
