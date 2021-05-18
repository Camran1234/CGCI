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
public class CImg extends Tag {
    
    public CImg(int line, int column){
        super(line, column);
    }
    
    
    public void setSrc(String src, String line, String column){
        if(!src.isEmpty()){
            this.src.setValue(src);
            this.src.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro src","Agregar una URL",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setWidth(String width, String line, String column){
        if(!width.isEmpty()){
            this.width.setValue(width);
            this.width.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro width","Agrega un ancho en px o %",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setHeight(String height, String line, String column){
        if(!height.isEmpty()){
            this.height.setValue(height);
            this.height.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro height","Agrega una altura en px o %",Integer.parseInt(line), Integer.parseInt(column)));
        }    
    }
    
    public void setAlt(String alt, String line, String column){
        if(!alt.isEmpty()){
            this.alt.setValue(alt);
            this.alt.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro alt","Agrega un titulo alternativo a la imagen ",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setId(String id, String line, String column){
        if(!id.isEmpty()){
            this.id.setValue(id);
            this.id.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro id","Agrega un Id ",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("<img ");
        string.append(this.getStringTags());
        string.append(">");
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
