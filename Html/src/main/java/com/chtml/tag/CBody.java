/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.tag;

import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;

/**
 *
 * @author camran1234
 */
public class CBody extends Tag{

    public CBody(int line, int column) {
        super(line, column);
    }
    
    
    public void setBackground(String background, String line, String column){
        if(!background.isEmpty()){
            this.background.setValue(background);
            this.background.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro background","Agregar un color hexadecimal o color normal como black,olive,teal...",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("<body ");
        string.append(this.getStringTags());
        string.append(">\n");
        for(int index=0; index<tags.size(); index++){
            if(this.checkTags(this, tags.get(index))){
                string.append(tags.get(index).writeCode());
            }
        }
        string.append("</body>\n");
        return string.toString();
    }
    
    @Override
    public void execute(){
        this.findErrors();
        for(int index=0; index<tags.size(); index++){
            if(this.checkTags(this, tags.get(index))){
                tags.get(index).execute();
            }
        }
    }
}
