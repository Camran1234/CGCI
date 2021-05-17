/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camran1234
 */
public class Else {
    List<Instruccion> instrucciones;
    int line,column;
    
    public Else( ArrayList<Instruccion> instrucciones, int line, int column) {
        if(instrucciones!=null){
            this.instrucciones=instrucciones;
            //Setting context
            for(int index=0; index<this.instrucciones.size(); index++){
                this.instrucciones.get(index).setContext(this);
            }
            this.line = line;
            this.column = column;
        }
    }        
    
    public void execute(){
        for (int index=instrucciones.size()-1; index>=0; index--){
            if(instrucciones.get(index) instanceof Exit || instrucciones.get(index) instanceof Redirect){
                    instrucciones.get(index).execute();    
                    break;
                }
            instrucciones.get(index).execute();    
        }
    }
    
    
}
