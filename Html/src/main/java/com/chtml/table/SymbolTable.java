/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.table;

import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.tag.Tag;
import com.chtml.code.*;
import com.chtml.error.Helper;
import com.chtml.tag.CGcic;
import com.chtml.tag.Parameter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author camran1234
 */
public class SymbolTable {
    public static ArrayList<SymbolV> symbols = new ArrayList();
    public static ArrayList<Function> funciones = new ArrayList();
    public static ArrayList<Tag> tags = new ArrayList();
    public static String captchaName = "";
    public static String captchaId = "";
    
    public void clearTable(){
        this.symbols = new ArrayList();
        this.funciones =new ArrayList();
        this.tags = new ArrayList();
        this.captchaName = "";
        this.captchaId = "";
    }
    
    public void clearVariable(){
        this.symbols = new ArrayList();
    }
    
    public String writeFunctions(){
        StringBuffer string = new StringBuffer();
        for(int index=0; index<funciones.size(); index++){
            string.append(funciones.get(index).writeProcess());
        }
        
        return string.toString();
    }
    
    
    public void addTag(Tag tag){
        String nameTag = tag.id.value();
        if(!nameTag.isEmpty()){
            boolean founded=false;
            for(int index=0; index<tags.size(); index++){
                if(tags.get(index).id.value().equals(nameTag)){
                    founded=true;
                    break;
                }
            }
            if(!founded){
                tags.add(tag);
                if(tag instanceof CGcic){
                    if(((CGcic) tag).id.isStarted()){
                        String name = ((CGcic) tag).id.value();
                        //Agregamos el id del Captcha en caso de que hubiera uno
                        this.captchaId = name;
                    }
                    if(((CGcic)tag).name.isStarted()){
                        this.captchaName = ((CGcic)tag).name.value();
                    }
                }
            }else{
                ErrorHandler.semanticErrors.add(new SemanticError("La etiqueta ya existe",nameTag,"cambiar el nombre",tag.line, tag.column));
            }
        }
    }
    
    public void addFunction(Function function){
        //Revisamos que no exista
        String name = function.getName() ;
        boolean founded=false;
        for(int index=0; index<funciones.size(); index++){
            if (funciones.get(index).getName().equals(name)){
                founded = true;
                break;
            }
        }
        if(!founded){
            funciones.add(function);
        }else{
            ErrorHandler.semanticErrorsScript.add(new SemanticError("La Funcion ya existe",name, "cambiar de nombre",function.getLine(), function.getColumn()));
        }
    }
    
    
    /**
     * Add new Symbol to the symbol Table
     * @param name
     * @param type
     * @param value
     * @param line
     * @param column
     * @param context 
     */
    public void addSymbol(String name, String type, Object value,int line, int column, Object context, boolean booleano){
        SymbolV newSymbol = new SymbolV(name, type, line, column, context, booleano);
        this.checkError(newSymbol);
    }
    
    
    /**
     * Remueve las variables de un contexto
     */
    public void eliminateContext(Object context){
        if(context instanceof Function){
            Function funcion = (Function)context;
            if(funcion.isOnLoad()){
                //Todo lo que este en el OnLoad no lo eliminamos
                return;
            }
        }
        
        
        for(int index=symbols.size()-1; index>=0; index--){
            //Comparamos
            //Las globales una vez declaradas no las podemos eliminar
            
            if(symbols.get(index).getContext()!=null){
                if(symbols.get(index).getContext().equals(context) && symbols.get(index).isGlobal()==false){
                    //Removemos
                    symbols.remove(index);
                }
            }
        }
    }
    
    /**
     * Actualiza el valor de una variable
     * @param variable
     * @param context 
     */
    public void updateVariable(String variable,Parameter parameter, int line, int column){
        //Empezamos desde el nivel mas bajo
        boolean flag=false;
        for(int index=symbols.size()-1; index>=0; index--){
            //Code
            if(symbols.get(index).getNameId().equals(variable)){
                SymbolV theSymbol = symbols.get(index);
                String typeS = theSymbol.getType();
                String typeP = parameter.getParameter();
                Helper helper = new Helper();
                //Miramos si son del mismo tipo
                if(helper.comprobacionIgualar(typeS, typeP)){
                    //actualizamos el valor
                    theSymbol.setValue(parameter);
                    theSymbol.setLine(line);
                    theSymbol.setColumn(column);
                }else{
                    //agregamos error si no son del mismo tipo
                    ErrorHandler.semanticErrorsScript.add(new SemanticError(typeS+" no puede asignar "+typeP,typeP,"Agregar un valor adecuado",line,column));
                }
                
                flag = true;
            }
        }
        if(!flag){
            ErrorHandler.semanticErrorsScript.add(new SemanticError("La variable "+variable+" no ha sido declarada",variable,"Declarar la variable",line, column));
        }
    }
    
    /**
     * Add a new symbol to the table
     * @param symbol 
     */
    public void addSymbol(SymbolV symbol){
        this.checkError(symbol);
    }
    
    /**
     * Return the value of the variable searched
     * @param variable
     * @param line
     * @param column
     * @return 
     */
    public Parameter getValueVariable(String variable, int line, int column){
        boolean flag = false;
        Parameter parameter=null;
        for(int index=symbols.size()-1; index>=0; index--){
            if(symbols.get(index).getNameId().equals(variable)){
                parameter = (Parameter)symbols.get(index).getValue();
                if(parameter==null){
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Valor de la variable "+variable+" es nulo",variable, "Asignar un valor", line, column));
                }
                flag=true;
            }
        }
        if(!flag){
            ErrorHandler.semanticErrorsScript.add(new SemanticError("No existe la variable "+variable,variable,"Declarar la variable",line, column));
        }
        return parameter;
    }
    
    public String getTypeVariable(String variable, int line, int column){
        boolean flag = false;
        String parameter="";
        for(int index=symbols.size()-1; index>=0; index--){
            if(symbols.get(index).getNameId().equals(variable)){
                parameter = symbols.get(index).getType();
                flag=true;
            }
        }
        if(!flag){
            ErrorHandler.semanticErrorsScript.add(new SemanticError("No existe la variable "+variable,variable,"Declarar la variable",line, column));
        }
        return parameter;
    }
    
    
    
    /**
     * Method to check if the symbol is validate to put in the table
     * @param symbol 
     */
    public void checkError(SymbolV symbol ){
        boolean founded = false;
        for(int index=0; index<symbols.size(); index++){
            if(symbols.get(index).compareSymbol(symbol)){
                founded=true;
            }
        }
        if(!founded){
            
            symbols.add(symbol);
        }else{
            String message="";
            if(symbol.getContext() instanceof Tag){
                message = "Id de la etiqueta ya existe en el contexto";
                ErrorHandler.semanticErrors.add(new SemanticError(message,symbol.getNameId(),"Cambiar el nombre",symbol.getLine(), symbol.getColumn()));
            }else if(symbol.getType().equalsIgnoreCase("int")||symbol.getType().equalsIgnoreCase("char")||
                        symbol.getType().equalsIgnoreCase("string") || symbol.getType().equalsIgnoreCase("decimal")
                    || symbol.getType().equalsIgnoreCase("boolean") || symbol.getType().equalsIgnoreCase("variable")){
                message = "La variable ya existe en el contexto actual";
                ErrorHandler.semanticErrorsScript.add(new SemanticError(message,symbol.getNameId(),"Cambiar el nombre",symbol.getLine(), symbol.getColumn()));
            }else if(symbol.getContext() instanceof Function){
                message = "La funcion etiqueta ya existe en el contexto";
                ErrorHandler.semanticErrorsScript.add(new SemanticError(message,symbol.getNameId(),"Cambiar el nombre",symbol.getLine(), symbol.getColumn()));
            }
        }       
    }

    public void refreshVariable(String name) {
        for(int index=0; index<symbols.size(); index++){
            if(symbols.get(index).getNameId().equalsIgnoreCase(name)){
                symbols.get(index).updateOne();
                break;
            }
        }
    }
    

    
    
    
    
}
