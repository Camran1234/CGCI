/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.table;

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

    public void setValue(Object value){
        this.value = value;
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
    
    public int getLine(){
        return line;
    }
    
    public int getColumn(){
        return column;
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
        if(compareId.equalsIgnoreCase("")){
            return false;
        }
        
        if(this.id.equals(compareId) && this.context.equals(context)){
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
    
}
