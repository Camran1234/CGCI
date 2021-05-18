/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.table.Captcha;
import javax.swing.JOptionPane;

/**
 *
 * @author camran1234
 */
public class Exit extends Instruccion{
    
    public Exit(int line, int column){
        this.line = line;
        this.column = column;
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        String f = new Captcha().getHref();
        string.append("location.replace(\""+f+"\");\n");
        return string.toString();
    }
}
