/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.table.SymbolTable;
import com.chtml.tag.Parameter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author camran1234
 */
public class Huntil {
    ArrayList<Instruccion> instrucciones;
    int line, column;
    Operation operation;
    private Object context;
    
    public Huntil(ArrayList<Instruccion> instrucciones, Operation operation, int line, int column){
        this.instrucciones = instrucciones;
        this.operation = operation;
        this.line = line;
        this.column = column;
    }
    
    public void setContext(Object context){
        this.context = context;
        for(int index=0; index<instrucciones.size(); index++){
            instrucciones.get(index).setContext(context);
        }
    }
    
    public Operation getOperation(){
        return operation;
    }
    
    public ArrayList<Instruccion> getInstrucciones(){
        return instrucciones;
    }
    
    public void execute(int var, String name){
        
        try {
            //Obtenemos hasta donde debe de llegar
            Parameter parametro = operation.execute();
            //Recorrera a paso 1
            if(parametro.getParameter().equalsIgnoreCase("int")){
                //Obtiene la variable hasta donde debe de llegar
                int number=Integer.parseInt(parametro.value());
                //Genera un for
                for(int variable=var; variable<=number; variable++){
                    SymbolTable table = new SymbolTable();
                    table.refreshVariable(name);
                    //Realiza todas las instrucciones
                    for(int index=instrucciones.size()-1; index>=0; index--){
                        instrucciones.get(index).execute();
                    }
                    table.eliminateContext(this.context);
                }
            }                    
        } catch (Exception e) {
        }
        
    }
    
    
    public String writeCode(String name){
        StringBuffer string = new StringBuffer();
        Parameter parametro = operation.execute();
        if(parametro.getParameter().equalsIgnoreCase("int")){
            int number = Integer.parseInt(parametro.value());
            string.append( name+" <= "+number+ "; "+name+"++ ) {\n");
            for(int index=instrucciones.size()-1; index>=0; index--){
               string.append(instrucciones.get(index).writeCode());
            }
            string.append("}\n");
        }
        return string.toString();
    }
    
    
}
