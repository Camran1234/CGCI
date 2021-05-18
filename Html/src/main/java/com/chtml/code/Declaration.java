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
public class Declaration {
    private Operation value;
    private int line, column;
    private boolean assign=false;
    
    public Declaration(Operation op){
        this.value = op;
        if(value!=null){
            line = value.line;
            column = value.column;            
        }
    }
    
    public Parameter execute(){
        if(value!=null){
            return value.execute();
        }else{
            return null;
        }
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append(value.writeCode());
        return string.toString();
    }
    
    public boolean isEmpty(){
        if(this.value==null){
            return true;
        }else {
            return false;
        }
    }
}
