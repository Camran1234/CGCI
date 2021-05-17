/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.table;

import com.chtml.tag.Tag;
import java.util.ArrayList;
/**
 *
 * @author camran1234
 */
public class HtmlData {
    public ArrayList<Tag> tags = new ArrayList();
    
    public HtmlData(){
        this.tags = new ArrayList();
    }
    
    public void pushTag(Tag tag){
        if(tag!=null){
            this.tags.add(tag);
        }
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        for(int index=0; index<tags.size(); index++){
            string.append(tags.get(index).writeCode());
        }
        return string.toString();
    }
    
    public void execute(){
        for(int index=0; index<tags.size(); index++){
            tags.get(index).execute();
        }
    }
    
    
    
}
