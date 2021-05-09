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
public class SymbolTable {
    public ArrayList<Variable> variables = new ArrayList();
    public ArrayList<Tag> tags = new ArrayList();
    public ArrayList<String> idTags = new ArrayList();
    
    public SymbolTable(){
        this.variables = new ArrayList();
        this.tags = new ArrayList();
        this.idTags = new ArrayList();
    }
    
    public void pushTag(Tag tag){
        if(tag!=null){
            this.tags.add(tag);
        }
    }
    
    public boolean mojoFunction(){
        return true;
    }
    
    
}
