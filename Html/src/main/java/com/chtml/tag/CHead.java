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
        string.append("<head>");
        string.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">");
        for(int index=0; index<tags.size(); index++){
            string.append(tags.get(index).writeCode());
        }
        string.append("</head>");
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
