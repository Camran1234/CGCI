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
public class CButton extends Tag{
    
     public void setBackground(String background, String line, String column){
        if(!background.isEmpty()){
            this.background.setValue(background);
            this.background.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro background","Agregar un color hexadecimal o color normal como black,olive,teal...",Integer.parseInt(line), Integer.parseInt(column)));
        }
        
    }
     
    public void setOnClick(String onClick, String line, String column){
        if(!onClick.isEmpty()){
            this.onclick.setValue(onClick);
            this.onclick.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro onclick","Agregar una funcion (Process_...) de script existente ",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setColor(String color, String line, String column){
        if(!color.isEmpty()){
            this.color.setValue(color);
            this.color.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro color","Agregar un color hexadecimal o color normal como black,olive,teal...",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setFontSize(String fontSize, String line, String column){
        if(!fontSize.isEmpty()){
            this.fontsize.setValue(fontSize);
            this.fontsize.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro Font-Size","Agregar un tamaño,Ejemplo: \"20px\" ",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setFontFamily(String fontFamily, String line, String column){
        if(!fontFamily.isEmpty()){
            this.fontfamily.setValue(fontFamily);
            this.fontfamily.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro Font-Family","Agregar un tipo de letra",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setTextAlign(String textAlign, String line, String column){
        if(!textAlign.isEmpty()){
            this.textAlign.setValue(textAlign);
            this.textAlign.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro TextAlign","Agregar left, right, center o justify",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setId(String id, String line, String column){
        if(!id.isEmpty()){
            this.id.setValue(id);
            this.id.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro id","Agregar un Id",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    @Override
    public String writeCode(){
        return "";
    }
}
