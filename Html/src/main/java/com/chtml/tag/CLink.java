/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.tag;

import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.table.Captcha;
import javax.swing.JOptionPane;

/**
 *
 * @author camran1234
 */
public class CLink extends Tag{
    
    public CLink(int line, int column){
        super(line, column);
    }
    
    public void setHref(String href, String line, String column){
        if(!href.isEmpty()){
            this.href.setValue(href);
            this.href.setPosition(line, column);
            Captcha captcha = new Captcha();
            captcha.setnewLink(this.href.value());
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro href","Agregar una URL",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        //Agregamos el link del captcha
       Captcha captcha = new Captcha();
        captcha.setnewLink(captcha.getHref());
        return string.toString();
    }
    
    @Override
    public void execute(){
        //Agregamos el link del captcha
        String link="www.google.com";
        if(href.isStarted()){
            link = href.value();
        }
       Captcha captcha = new Captcha();
        captcha.setnewLink(link);
        this.findErrors();
        for(int index=0; index<tags.size(); index++){
            if(this.checkTags(this, tags.get(index))){
                tags.get(index).execute();
            }
        }
    }
    
}
