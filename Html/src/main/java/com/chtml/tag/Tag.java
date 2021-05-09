/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.tag;

import java.util.ArrayList;

/**
 *
 * @author camran1234
 */
public class Tag {
    //Name of the tag
    Parameter href=new Parameter("href");
    Parameter background= new Parameter("background");
    Parameter color = new Parameter("color");
    Parameter fontsize=new Parameter("font-size");
    Parameter fontfamily=new Parameter("font-family");
    Parameter textAlign= new Parameter("text-align");
    //Type must be class like text, number, radio, checkbox
    Parameter type=new Parameter("type");
    Parameter id = new Parameter("id");
    Parameter name= new Parameter("name");
    Parameter cols=new Parameter("cols");
    Parameter rows=new Parameter("rows");
    Parameter classDiv=new Parameter("class");
    Parameter src=new Parameter("src");
    Parameter width=new Parameter("width");
    Parameter height=new Parameter("height");
    Parameter alt=new Parameter("alt");
    Parameter onclick=new Parameter("onclick");
    Parameter text = new Parameter("text");
    boolean isError=false;
    
    private int line=0;
    private int column=0;
    private ArrayList<Tag> tags = new ArrayList();
    
    public void pushTags(ArrayList<Tag> newTags){
        if(newTags!=null){
            for(int index=newTags.size()-1; index>=0; index--){
                tags.add(newTags.get(index));
            }
        }
        
    }
    
    /**
     * Set position
     * @param line
     * @param column 
     */
    public void setPosition(String line, String column){
        this.line = Integer.parseInt(line);
        this.column = Integer.parseInt(column);
    }
    /**
     * Push text
     * @param text
     * @param line
     * @param column 
     */
    public void setText(String text, String line, String column){
        this.text.pushValue(text);
        this.text.setPosition(line, column);
    }
    
    public void checkSemanticErrors(ArrayList<String> procesos){
        if(!background.isEmpty()){
            this.checkColor(background.value, background);
        }
        if(!color.isEmpty()){
            this.checkColor(color.value, color);
        }
        if(!fontsize.isEmpty()){
            this.checkPixel(fontsize.value, fontsize);
        }
        if(!width.isEmpty()){
            this.checkPixel(width.value, width);
        }
        if(!height.isEmpty()){
            this.checkPixel(height.value, height);
        }
        if(!onclick.isEmpty()){
            boolean founded=false;
            for(int index=0; index<procesos.size(); index++){
                if(onclick.value.equalsIgnoreCase(procesos.get(index))){
                    founded=true;
                    break;
                }
            }
            if(founded){
                //throw Semantic Error
            }
        }
        
        if(!fontfamily.isEmpty()){
            if(!fontfamily.value.equalsIgnoreCase("Courier")&&
                !fontfamily.value.equalsIgnoreCase("Verdana")&&
                !fontfamily.value.equalsIgnoreCase("Arial")&&
                !fontfamily.value.equalsIgnoreCase("Geneva")&&
                !fontfamily.value.equalsIgnoreCase("sans-serif")){
            //Semantic Error
            }
        }
        if(!textAlign.value.equalsIgnoreCase("left")&&
                !textAlign.value.equalsIgnoreCase("right")&&
                !textAlign.value.equalsIgnoreCase("center")&&
                !textAlign.value.equalsIgnoreCase("justify")){
            //Throw Semantic Error
        }
        
            
        if(!type.value.equalsIgnoreCase("text")&&
                !type.value.equalsIgnoreCase("number")&&
                !type.value.equalsIgnoreCase("radio")&&
                !type.value.equalsIgnoreCase("checkbox")){    
            //throw semantic Error
        }
        
        if(!id.isEmpty()){
            if(!id.value.contains("_")&&!id.value.contains("-")&&!id.value.contains("$")){
                //throw Semantic error
            }
        }
        
        if(!cols.isEmpty()){
            if(!isNumber(cols.value)){
                //throw Semantic Error
            }
        }
        
        if(!rows.isEmpty()){
            if(!isNumber(rows.value)){
                //throw Semantic Error
            }
        }
        
        if(!classDiv.isEmpty()){
            if(!classDiv.value.equalsIgnoreCase("row")
                    &&!classDiv.value.equalsIgnoreCase("column")){
                //Throw Semantic Error
            }
        }
        
        
    }
    
    
    
    
    //Helper functions    
    public void checkPixel(String number, Object parameter){
        String auxiliar = number.replace("px", "");
        auxiliar = auxiliar.replace("%", "");
        if(!isNumber(auxiliar)){
                //Semantic error where auxiliar is not a number        
        }                        
        char p = auxiliar.charAt(auxiliar.length()-2);        
        char x = auxiliar.charAt(auxiliar.length()-1);        
        if(x!='x'){        
            if(x!='%'){
                    //Semantic Error            
            }            
        }else{        
            if(p!='p'){
                    //Semantic Error            
            }            
        }
    }
    
    public boolean isNumber(String number){
        try {
            Integer newNumber = Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void checkColor(String color, Object parameter){
        if(color.charAt(0)=='#'){
                //checking size
                if(color.length()==7){
                    for(int index=1; index<7; index++){
                        char letter = color.charAt(index);
                        if(!(letter>=48 && letter<=57)||!(letter>=65 && letter<=70)||!(letter>=97 && letter<=102)){
                            //errorHandling
                        }
                    }
                }else{
                    //ErrorHandling
                }
            }else{
                if(!color.equalsIgnoreCase("black")&&
                        !color.equalsIgnoreCase("olive")&&
                        !color.equalsIgnoreCase("teal")&&
                        !color.equalsIgnoreCase("red")&&
                        !color.equalsIgnoreCase("blue")&&
                        !color.equalsIgnoreCase("maroon")&&
                        !color.equalsIgnoreCase("navy")&&
                        !color.equalsIgnoreCase("gray")&&
                        !color.equalsIgnoreCase("lime")&&
                        !color.equalsIgnoreCase("fuchsia")&&
                        !color.equalsIgnoreCase("green")&&
                        !color.equalsIgnoreCase("white")&&
                        !color.equalsIgnoreCase("purple")&&
                        !color.equalsIgnoreCase("silver")&&
                        !color.equalsIgnoreCase("yellow")&&
                        !color.equalsIgnoreCase("aqua")){
                    //ErrorHandling
                }
            }   
    }
    
    public void setAsError(){
        this.isError = true;
    }
    
    public String writeCode(){
        return "";
    }
    
    
}
