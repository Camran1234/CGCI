/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.error.ErrorHandler;
import com.chtml.error.Helper;
import com.chtml.error.SemanticError;
import com.chtml.table.SymbolTable;
import com.chtml.table.SymbolV;
import com.chtml.tag.Parameter;
import javax.swing.JOptionPane;

/**
 *
 * @author camran1234
 */
public class Variable extends Instruccion{
    private String name = "";
    private String type = "";
    private String mode = "";
    private Declaration value ;
    private int line;
    private int column;

    public Variable(String name, int line, int column){
        this.name = name;
        this.line = line;
        this.column = column;
    }
    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMode() {
        return mode;
    }
    
    

    public Declaration getValue() {
        return value;
    }
    
    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
     
    public void setValue(Declaration declaration){
        this.value = declaration;
    }
    
    public void setValue(String type, Declaration declaration){
        this.type = type;
        this.value = declaration;
    }
    
    public void setMode(String mode){
        this.mode = mode;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    @Override
    public String writeCode(){
        StringBuffer string =  new StringBuffer();
        if(!type.isEmpty() && value!=null){
            string.append("var "+name+" ");
            if(value.isEmpty()){
                string.append(";\n");
            }else{
                string.append(" = ");
                string.append(value.writeCode());
                string.append(";\n");
            }
        }else if(type.isEmpty() && value!=null){
            string.append(name+" ");
            string.append(" = "+value.writeCode() + " ;\n");
        }
        this.execute();
        return string.toString();
    }
    
    //Comprueba semanticamente
    @Override
    public void execute(){
        SymbolTable symbol = new SymbolTable();
        if(!type.isEmpty() && value!=null){
            if(value.isEmpty()){
                boolean finalMode=false;
                if(mode.isEmpty()==false){
                    finalMode=true;
                }
                SymbolV symbolV = new SymbolV (name, type, line, column, null, context, finalMode );
                symbol.addSymbol(symbolV);
            }else{
                //Declaracion
                Parameter parametro = value.execute();
                if(parametro!=null){
                    String tipo = parametro.getParameter();
                    String value = parametro.value();
                    int line = parametro.line;
                    int column = parametro.column;
                    boolean finalMode=false;
                    if(mode.isEmpty()==false){
                        finalMode=true;
                    }

                    SymbolV symbolV = new SymbolV(name, type,line, column,parametro,context, finalMode);

                    String typeVariable = this.type;
                    String typeValue = tipo;
                    Helper helper = new Helper();
                    if(helper.comprobacionIgualar(typeVariable, typeValue)){
                        //agregamos el simbolo
                        symbol.addSymbol(symbolV);
                    }else{
                        ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede agregar "+typeValue+" a un "+typeVariable, typeValue,"Agregar un valor correcto",
                        line, column));
                    }
                }
            } 
        }else if(type.isEmpty() && value!=null){
            
                //Actualizacion
                Parameter parametro = value.execute();
                int line = parametro.line;
                int column = parametro.column;
                symbol.updateVariable(name, parametro, line, column);
                //actualizamos valores
        }
    }
    
    /**
     * Manejo de valores de las variables
     * Contiene manejo de errores de tipo
     * @param value
     * @param line
     * @param column 
     */
    /*public void setValue(Parameter value, int line, int column){
        if(type.equalsIgnoreCase("int")){
            if(isInt(value.value())){
                this.value = value;
            }else{
                if(value.value().equalsIgnoreCase("true") || value.value().equalsIgnoreCase("false")){
                    Parameter parameter = new Parameter("boolean");
                    if(value.value().equalsIgnoreCase("true")){
                        parameter.setValue("1");
                        this.value = parameter ;
                    }else{
                        parameter.setValue("0");
                        this.value = parameter ;
                    }
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Tipos incompatibles, el valor no es un int",value.value(), "",line, column));
                }
            }
        }else if(type.equalsIgnoreCase("string")){
            if(isString(value.value())){
                this.value = value;
                
            }
        }else if(type.equalsIgnoreCase("char")){
            if(value.value().charAt(0)=='\'' && value.value().charAt(value.value().length()-1)=='\''){
                this.value = value;
            }else{
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Tipos incompatibles, el valor no es un char", value.value(), "colocar false o true",line, column));
            }
        }else if(type.equalsIgnoreCase("boolean")){
            if(value.value().equalsIgnoreCase("false") || value.value().equalsIgnoreCase("true")){
                this.value = value;
            }else{
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Tipos incompatibles, el valor no es un booleano", value.value(), "colocar false o true",line, column ));
            }
        }else if(type.equalsIgnoreCase("decimal")){
            if(isDecimal(value.value())){
                this.value = value;
            }else{
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Tipos incompatibles, el valor no es un decimal", value.value(), "colocar false o true",line, column));
            }
        }    
    }*/
    
    
    
    
    
}
