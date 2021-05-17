/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.tag;

import com.chtml.code.Function;
import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.table.SymbolTable;
import com.chtml.table.SymbolV;
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
    public Parameter id = new Parameter("id");
    public Parameter name= new Parameter("name");
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
    
     public int line=0;
    public int column=0;
     ArrayList<Tag> tags = new ArrayList();
    
    public Tag(int line, int column) {
        this.line = line;
        this.column = column;
    }
     
    public String getStringTags(){
        StringBuffer string = new StringBuffer();
        string.append(href.writeCode());
        string.append("style=\" ");
        string.append(background.writeCode());
        string.append(color.writeCode());
        string.append(fontsize.writeCode());
        string.append(fontfamily.writeCode());
        string.append(textAlign.writeCode());
        string.append(" \" ");
        string.append(type.writeCode());
        string.append(id.writeCode());
        string.append(name.writeCode());
        string.append(cols.writeCode());
        string.append(rows.writeCode());
        string.append(classDiv.writeCode());
        string.append(src.writeCode());
        string.append(width.writeCode());
        string.append(height.writeCode());
        string.append(alt.writeCode());
        string.append(onclick.writeCode());
        return string.toString();
    }
    
    public void pushTags(ArrayList<Tag> newTags){
        if(newTags!=null){
            for(int index=newTags.size()-1; index>=0; index--){
                tags.add(newTags.get(index));
                if(newTags.get(index).id.isStarted()  ){
                    new SymbolTable().addSymbol(newTags.get(index).id.value(), "Tag", newTags.get(index), newTags.get(index).line, newTags.get(index).line, this, false);
                }
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
        
        if(background.isStarted()){
            this.checkColor(background.value(), background);
        }
        if(color.isStarted()){
            this.checkColor(color.value(), color);
        }
        if(fontsize.isStarted()){
            this.checkPixel(fontsize.value(), fontsize);
        }
        if(width.isStarted()){
            this.checkPixel(width.value(), width);
        }
        if(height.isStarted()){
            this.checkPixel(height.value(), height);
        }
        if(onclick.isStarted()){
            boolean founded=false;
            for(int index=0; index<procesos.size(); index++){
                if(onclick.value().equalsIgnoreCase(procesos.get(index))){
                    founded=true;
                    break;
                }
            }
            if(founded){
                ErrorHandler.semanticErrors.add(new SemanticError("Funcion no encontrada onclick",onclick.value(),"Validar correctamente la funcion a la que se refiere",onclick.line, onclick.column));
            }
        }
        
        if(fontfamily.isStarted()){
            if(!fontfamily.value().equalsIgnoreCase("Courier")&&
                !fontfamily.value().equalsIgnoreCase("Verdana")&&
                !fontfamily.value().equalsIgnoreCase("Arial")&&
                !fontfamily.value().equalsIgnoreCase("Geneva")&&
                !fontfamily.value().equalsIgnoreCase("sans-serif")){
            ErrorHandler.semanticErrors.add(new SemanticError("Valor no reconocido font-family",fontfamily.value(),"Valores aceptados, Courirer, Verdana, Arial, Geneva o sans-serif",fontfamily.line, fontfamily.column));
            }
        }
        if(textAlign.isStarted()){
            if(!textAlign.value().equalsIgnoreCase("left")&&
                !textAlign.value().equalsIgnoreCase("right")&&
                !textAlign.value().equalsIgnoreCase("center")&&
                !textAlign.value().equalsIgnoreCase("justify")){
                ErrorHandler.semanticErrors.add(new SemanticError("Valor no reconocido text-align",textAlign.value(),"Valores aceptados, left, right, center, justify",textAlign.line, textAlign.column));
            }   
        }     
            
        if(type.isStarted()){
            if(!type.value().equalsIgnoreCase("text")&&
                !type.value().equalsIgnoreCase("number")&&
                !type.value().equalsIgnoreCase("radio")&&
                !type.value().equalsIgnoreCase("checkbox")){    
            ErrorHandler.semanticErrors.add(new SemanticError("Valor no reconocido en type",type.value(),"Tipos aceptados: number, radio, checkbox",type.line, type.column));
            }
        }
        
        if(id.isStarted()){
            if(!id.value().contains("_")&&!id.value().contains("-")&&!id.value().contains("$")){
                ErrorHandler.semanticErrors.add(new SemanticError("El id no contiene _,- o $ en id",id.value(),"Agregar _,- o $ al nombre del id",id.line, id.column));
            }else{
                //Agregamos el Id
                SymbolTable table = new SymbolTable();
                table.addTag(this);
            }
        }
        
        if(cols.isStarted()){
            if(!isNumber(cols.value())){
                ErrorHandler.semanticErrors.add(new SemanticError("El valor no es un entero en cols",cols.value(),"Colocar un numero",cols.line, cols.column));
            }
        }
        
        if(rows.isStarted()){
            if(!isNumber(rows.value())){
                ErrorHandler.semanticErrors.add(new SemanticError("El valor no es un entero en row",rows.value(),"Colocar un numero",rows.line, rows.column));
            }
        }
        
        if(classDiv.isStarted()){
            if(!classDiv.value().equalsIgnoreCase("row")
                    &&!classDiv.value().equalsIgnoreCase("column")){
                ErrorHandler.semanticErrors.add(new SemanticError("Valor no reconocido de div",classDiv.value(),"parametro aceptados: row o column -indica comportamiento-",classDiv.line, classDiv.column));
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
    
    public void execute(){
        
    }
    
    public void findErrors(){
        SymbolTable table=new SymbolTable();
        ArrayList<Function> funciones = table.funciones;
        ArrayList<String> procesos = new ArrayList();
        for(int index=0; index<funciones.size(); index++){
            if(!funciones.get(index).isOnLoad()){
                procesos.add(funciones.get(index).getName());
            }
        }
        //Comprobamos errores
        this.checkSemanticErrors(procesos);   
    }
    
    public boolean checkTags(Tag tag, Tag child){
        //always accept the script
        if(child instanceof CScripting){
            return true;
        }
        
        if(tag instanceof CBody){
            //acepta todas
            if(child instanceof CGcic|| child instanceof CBody || child instanceof CHead){
                return false;
            }
            return true;
        }else if(tag instanceof CButton){
            //Solo acepta texto
            if(child instanceof CText){
                return true;
            }else{
                return false;
            }
        }else if(tag instanceof CDiv){
            //acepta todas
            if(child instanceof CHead || child instanceof CBody || child instanceof CGcic){
                return false;
            }
            return true;
        }else if(tag instanceof CGcic){
            //acepta todas
            if(child instanceof CGcic){
                return false;
            }
            return true;
        }else if(tag instanceof CH1){
            if(child instanceof CText || child instanceof CH1){
                return true;
            }else{
                return false;
            }
        }else if(tag instanceof CHead){
            if(child instanceof CLink || child instanceof CScripting||
                    child instanceof CTitle || child instanceof CText){
                return true;
            }else{
                return false;
            }
        }else if(tag instanceof CImg){
            //must have nothing
            return false;
        }else if(tag instanceof CInput){
            if(child instanceof CText){
                return true;
            }
        }else if(tag instanceof CLink){
            return false;
        }else if(tag instanceof COption){
            //just get text and not CText
            return false;
        }else if(tag instanceof CP){
            if(child instanceof CText || child instanceof CSpam){
                return true;
            }else{
                return false;
            }
        }else if(tag instanceof CScripting){
            //generalmente acepta texto
            
        }else if(tag instanceof CSelect){
            if(child instanceof COption){
                return true;
            }
        }else if(tag instanceof CSpam){
            if(child instanceof CSpam || child instanceof CText){
                return true;
            }else{
                return false;
            }
            
        }else if(tag instanceof CText){
            //Ctext just throw his data
            return false;
        }else if(tag instanceof CTextArea){
            if(child instanceof CText){
                return true;
            }else{
                return false;
            }
        }else if(tag instanceof CTitle){
            if(child instanceof CText){
                return true;
            }else{
                return false;
            }
        }
        
        return false;
    }
    
    public String getType(Tag tag){
        if(tag instanceof CGcic){
            return "C_GCIC";
        }else if(tag instanceof CBody){
            return "C_BODY";
        }else if(tag instanceof CBr){
            return "C_Br";
        }else if(tag instanceof CButton){
            return "C_BUTTON";
        }else if(tag instanceof CDiv){
            return "C_DIV";
        }else if(tag instanceof CH1){
            return "C_H1";
        }else if(tag instanceof CHead){
            return "C_HEAD";
        }else if(tag instanceof CImg){
            return "C_IMG";
        }else if(tag instanceof CInput){
            return "C_INPUT";
        }else if(tag instanceof CLink){
            return "C_LINK";
        }else if(tag instanceof COption){
            return "C_OPTION";
        }else if(tag instanceof CP){
            return "C_P";
        }else if(tag instanceof CScripting){
            return "C_SCRIPTING";
        }else if(tag instanceof CSelect){
            return "C_SELECT";
        }else if(tag instanceof CSpam){
            return "C_SPAM";
        }else if(tag instanceof CText){
            return "C_TEXT";
        }else if(tag instanceof CTextArea){
            return "C_TEXTAREA";
        }else if(tag instanceof CTitle){
            return "C_TITLE";
        }
        
        return "";
    }
    
}
