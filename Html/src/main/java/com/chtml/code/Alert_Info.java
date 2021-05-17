/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.tag.Parameter;
import javax.swing.JOptionPane;

/**
 *
 * @author camran1234
 */
public class Alert_Info extends Instruccion{
    private Operation operation;
    
    
    public Alert_Info(Operation op, int line, int column){
        this.operation= op;
        this.line = line;
        this.column = column;
    }
    
    @Override
    public void execute(){
        Parameter parameter = operation.execute();
        //nothing just execute
    }
    public String writeCode(){
        Parameter parameter = operation.execute();
        StringBuffer string = new StringBuffer();
        string.append("alert(");
        string.append(parameter.value());
        string.append(");\n");
        return string.toString();
    }
    
}
