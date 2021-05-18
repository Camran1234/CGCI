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
public class While extends Instruccion{
    private List<Instruccion> instrucciones;
    private Condition condition;
    private int line, column;
    
    public While(Condition condition, ArrayList<Instruccion> instrucciones, int line, int column){
        this.instrucciones = instrucciones;
        for(int index=0; index<instrucciones.size(); index++){
            this.instrucciones.get(index).setContext(this);
        }
        this.condition = condition;
        this.line = line;
        this.column = column;
    }
    
    
    public void setCondition(Condition condition){
        if(condition!=null){
            this.condition = condition;
        }
            
    }
    
    @Override
    public void execute(){
        Operation op  = condition.execute();
        Parameter parametro = op.execute();
        if(parametro.getParameter().equalsIgnoreCase("boolean")){
            while(true){
                op = condition.execute();
                parametro = op.execute();
                boolean result = Boolean.parseBoolean(parametro.value());
                if(result){
                    //ejecutamos las condiciones
                    for(int index=instrucciones.size()-1; index>=0; index--){
                        //Ejecutamos la accion
                        instrucciones.get(index).execute();
                    }
                }else{
                    break;
                }
                new SymbolTable().eliminateContext(this);
            }
        }
        
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("while ( ");
        string.append(condition.writeCode());
        string.append(" ) { \n");
        for(int index=instrucciones.size()-1; index>=0; index--){
            string.append(instrucciones.get(index).writeCode());
        }
        string.append("}\n");
        return string.toString();
    }
    
}
