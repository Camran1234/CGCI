/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.table.SymbolTable;
import com.chtml.tag.Parameter;
import java.util.ArrayList;

/**
 *
 * @author camran1234
 */
public class ElseIf extends If{

    public ElseIf(Condition condition, ArrayList<Instruccion> instrucciones, int line, int column) {
        super(condition, instrucciones, line, column);
    }
    
    
    
    public void execute(){
        for(int index=instrucciones.size()-1; index>=0; index--){
            if(instrucciones.get(index) instanceof Exit || instrucciones.get(index) instanceof Redirect){
                    instrucciones.get(index).execute();    
                    break;
                }
                instrucciones.get(index).execute();    
            }
            new SymbolTable().eliminateContext(this);
    }
    
}
