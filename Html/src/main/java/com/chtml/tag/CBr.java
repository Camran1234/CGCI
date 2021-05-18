/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.tag;

/**
 *
 * @author camran1234
 */
public class CBr extends Tag{

    public CBr(int line, int column) {
        super(line, column);
    }
    
    
    @Override
    public String writeCode(){
        return "<br>";
    }
    
    @Override
    public void execute(){
        
    }
}
