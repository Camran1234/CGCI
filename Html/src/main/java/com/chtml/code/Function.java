/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.table.SymbolTable;
import java.util.ArrayList;

/**
 *
 * @author camran1234
 */
public class Function {
    String name="";
    int line,column;
    ArrayList<Instruccion> instrucciones = new ArrayList();
    boolean isOnLoad=false;
    public static boolean shutUp=false;
    
    public Function(String name, int line, int column, boolean isOnLoad){
        this.line = line;
        this.column = column;
        this.name = name;
        this.isOnLoad = isOnLoad;
    }
    
    public int getLine(){
        return line;
    }
    
    public int getColumn(){
        return column;
    }
    
    public String getName(){
        return name;
    }
    
    public void pushInstrucciones(ArrayList<Instruccion> instrucciones){
        if(instrucciones!=null){
            this.instrucciones = instrucciones;
            for(int index=0; index<instrucciones.size(); index++){
                this.instrucciones.get(index).setContext(this);
            }
        }
    }
    
    public void addName(String newName, int line, int column){
        if(!name.isEmpty()){
            this.name = name;
        }else{
            ErrorHandler.semanticErrorsScript.add(new SemanticError("La funcion no tiene nombre",newName,"Agregar un nombre",line, column));
        }
    }    
    
    /**
     * Devuelve true si es una funcion OnLoad
     * Devuelve false si es una funcion process
     * @return 
     */
    public boolean isOnLoad(){
        return isOnLoad;
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        if(this.isOnLoad){
            string.append("var out;");
            for(int index=instrucciones.size()-1; index>=0; index--){
                string.append(instrucciones.get(index).writeCode());
            }
        }else{
            string.append("function "+name+" (out) {\n");
            //delete this
            //string.append("<%int x=2; JOptionPane.showMessageDialog(null, x);%>\n");
            for(int index=instrucciones.size()-1; index>=0; index--){
                    string.append(instrucciones.get(index).writeCode());
            }
            string.append("\n}\n");
        }
        new SymbolTable().eliminateContext(this);
        return string.toString();
    }
    
    public String writeProcess(){
        StringBuffer string = new StringBuffer();
        string.append("function "+name+" () {\n");
        if(this.isOnLoad()==false){
            for(int index=instrucciones.size()-1; index>=0; index--){
                string.append(instrucciones.get(index).writeCode());
            }
        }
        string.append("\n}\n");
        return string.toString();
    }
    
    
    
    public void execute(){
        try {
            int asd=0;
                for(int index=instrucciones.size()-1; index>=0; index--){
                    if(instrucciones.get(index) instanceof Exit || instrucciones.get(index) instanceof Redirect){
                        instrucciones.get(index).execute();    
                        break;
                    }
                    instrucciones.get(index).execute();    
                }
                if(!this.isOnLoad()){
                    new SymbolTable().eliminateContext(this);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
