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
public class CHead extends Tag{
    
    public CHead(int line, int column){
        super(line, column);
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("<head>\n");
        for(int index=0; index<tags.size(); index++){
            string.append(tags.get(index).writeCode());
        }
        string.append("</head>\n");
        return string.toString();
    }
    
    public void execute(){
        this.findErrors();
        for(int index=0; index<tags.size(); index++){
            if(this.checkTags(this, tags.get(index))){
                tags.get(index).execute();
            }
        }
    }
}
