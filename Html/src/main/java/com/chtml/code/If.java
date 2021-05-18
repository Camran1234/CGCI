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

/**
 *
 * @author camran1234
 */
public class If extends Instruccion{
     Condition condition;
     List<Instruccion> instrucciones;
    List<ElseIf> elseif;
    Else else_;
    
    
    
    public If(Condition condition, ArrayList<Instruccion> instrucciones, int line, int column){
        if(condition !=null && instrucciones !=null){
            this.condition = condition;
            //Agregamos el contexto
            this.instrucciones = instrucciones;
            for(int index=0; index<instrucciones.size(); index++){
                this.instrucciones.get(index).setContext(this);
            }            
            this.line = line;
            this.column = column;
        }
    }
    
    public void setCondition(Condition condition){
        this.condition = condition;
    }
    
    public void setElseIfs(ArrayList<ElseIf> elses){
        this.elseif = elses;
    }
    
    public void setElse(Else elses){
        this.else_ = elses;
    }
    
    public void addInstruccion(Instruccion instruccion){
        this.instrucciones.add(instruccion);
    }
    
    public void pushInstruccion(ArrayList<Instruccion> instrucciones){    
        if(instrucciones!=null){
            for(int index=0; index<instrucciones.size(); index++){
                this.instrucciones.add(instrucciones.get(index));
            }
        }
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("\nif ( ");
        string.append(condition.writeCode());
        string.append(") {\n");
        for(int index=instrucciones.size()-1; index>=0; index--){
            string.append(instrucciones.get(index).writeCode());
        }
        string.append("} ");
        //ahora los elseifs
        if(elseif!=null){
            for(int index=0; index<elseif.size(); index++){
                string.append("else if ( ");
                string.append(elseif.get(index).condition.writeCode());
                string.append(") {\n");
                ArrayList<Instruccion> elseIfInstruccion = (ArrayList<Instruccion>) elseif.get(index).instrucciones;
                for(int i=elseIfInstruccion.size()-1; i>=0; i--){
                    string.append(elseIfInstruccion.get(i).writeCode());
                }
                string.append("} ");
            }
        }
        
        
        if(else_!=null){
            string.append(" else {\n");
            ArrayList<Instruccion> elseInstrucciones = (ArrayList<Instruccion> ) else_.instrucciones;
            for(int index=elseInstrucciones.size()-1; index>=0; index--){
                string.append(elseInstrucciones.get(index).writeCode());
            }
            string.append("} \n");
        }
        
        return string.toString();
    }
    
    @Override
    public void execute(){
        boolean ejecutado=false;
        //manejamos el if
        if(condition()){
            ejecutado = true;
            for(int index=instrucciones.size()-1; index>=0; index--){
                if(instrucciones.get(index) instanceof Exit || instrucciones.get(index) instanceof Redirect){
                    instrucciones.get(index).execute();    
                    break;
                }
                instrucciones.get(index).execute();    
            }
            new SymbolTable().eliminateContext(this);
        }
        //manejamos los multiples else ifs
        if(elseif!=null){
            if(!ejecutado){
                //Aqui no hay problema porque el parser tiene la recursividad desde la izquierda
                for(int index=0; index<elseif.size(); index++){
                    if(ejecutado){
                        break;
                    }else{
                        if(elseif.get(index).condition()){
                            ejecutado=true;
                            //ejecutamos
                            elseif.get(index).execute();
                        }
                    }
                }
            }
        }
        
        //manejamos el else
        if(else_!=null){
            if(!ejecutado){
                //ejecutamos
                else_.execute();
            }
        }
    }
    
    public boolean condition(){
        Operation op = condition.execute();
        Parameter parameter = op.execute();
        if(parameter.getParameter().equalsIgnoreCase("boolean")){
            boolean boleano = Boolean.parseBoolean(parameter.value());
            return boleano;
        }
        return false;
    }
}
