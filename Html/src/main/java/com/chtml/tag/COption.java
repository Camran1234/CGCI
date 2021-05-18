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
public class COption extends Tag{
    
    public COption(int line, int column){
        super(line, column);
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("\n<option ");
        string.append("value=\""+text.value()+"\" ");
        string.append(">");
        string.append(text.value());
        string.append("</option>\n");
        return string.toString();
    }
    
    @Override
    public void execute(){
        
    }
}
