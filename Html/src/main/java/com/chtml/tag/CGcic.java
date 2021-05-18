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
public class CGcic extends Tag{

    public CGcic(int line, int column) {
        super(line, column);
    }
    
    public void setId(String id, String line, String column){
        if(!id.isEmpty()){
            this.id.setValue(id);
            this.id.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro id","Agregar un Id",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    public void setName(String name, String line, String column){
        if(!name.isEmpty()){
            this.name.setValue(name);
            this.name.setPosition(line, column);
        }else{
            ErrorHandler.semanticErrors.add(new SemanticError("el parametro esta vacio"," el parametro name","Agregar un nombre identificador",Integer.parseInt(line), Integer.parseInt(column)));
        }
    }
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("<html>");
        for(int index=0; index<tags.size(); index++){
            string.append(tags.get(index).writeCode());
        }
        string.append("</html>");
        return string.toString();
    }
    
    @Override
    public void execute(){
        int head=0;
        int body=0;
        //check
        this.findErrors();
        for(int index=0; index<tags.size(); index++){
            if(tags.get(index) instanceof CHead){
                if(head >0){
                    ErrorHandler.semanticErrors.add(new SemanticError("No se puede colocar mas de una etiqueta C_Head","C_Head","Eliminar etiqueta", tags.get(index).line, tags.get(index).column));
                }
                head++;
                if(this.checkTags(this, tags.get(index))){
                    tags.get(index).execute();
                }
            }else if(tags.get(index) instanceof CBody){
                if(body>0){
                    ErrorHandler.semanticErrors.add(new SemanticError("No se puede colocar mas de una etiqueta C_Body","C_Body","Eliminar etiqueta", tags.get(index).line, tags.get(index).column));
                }
                body++;
                if(this.checkTags(this, tags.get(index))){
                    tags.get(index).execute();
                }
            }else if(tags.get(index) instanceof CGcic){
                ErrorHandler.semanticErrors.add(new SemanticError("No se puede colocar una etiqueta CGcic","CGcic","eliminar etiqueta",tags.get(index).line, tags.get(index).column));
            }else{
                if(this.checkTags(this, tags.get(index))){
                    tags.get(index).execute();
                }
            }
            
        }
    }
}
