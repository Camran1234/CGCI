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
        string.append(">");
        for(int index=0; index<tags.size(); index++){
            if(this.checkTags(this, tags.get(index))){
                string.append(tags.get(index).writeCode());
            }
        }
        string.append("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n" +
"        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n" +
"        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>");
        string.append("</body>");
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
