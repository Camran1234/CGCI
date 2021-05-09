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
public class CText extends Tag{
    
    
    public CText(String text,String line, String column){
        this.setText(text, line, column);
    }
    
    @Override 
    public String writeCode(){
        return "";
    }
}
