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
public class CTitle extends Tag {
    
    public CTitle(int line, int column){
        super(line, column);
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        
        string.append("<title>");
        for(int index=0; index<tags.size(); index++){
            if(this.checkTags(this, tags.get(index))){
                string.append(tags.get(index).writeCode());
            }
        }
        string.append("</title>");
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
