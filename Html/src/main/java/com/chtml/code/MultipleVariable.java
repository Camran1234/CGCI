/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import java.util.ArrayList;

/**
 * class just to handle multiple variables
 * @author camran1234
 */
public class MultipleVariable extends Instruccion{
    private ArrayList<Variable> variables;
    
    public MultipleVariable(ArrayList<Variable> variables){
        this.variables = variables;
    }
    
    public ArrayList<Variable> getVariables(){
        return variables;
    }
    
    @Override
    public void execute(){
        for(int index=0; index<variables.size(); index++){
            variables.get(index).execute();
        }
    }
}
