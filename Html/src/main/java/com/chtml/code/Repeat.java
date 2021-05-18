/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.table.SymbolTable;
import com.chtml.tag.Parameter;
import java.util.ArrayList;

/**
 *
 * @author camran1234
 */
public class Repeat extends Instruccion{
    private int line=0;
    private int column=0;
    private Variable variable;
    private Huntil huntil;
    
    public Repeat(Variable variable, Huntil huntil, int line, int column){
        this.variable = variable;
        if(variable!=null){
            this.variable.setContext(this);
        }
        this.huntil = huntil;
        if(huntil!=null){
            this.huntil.setContext(this);
        }
        this.line = line;
        this.column = column;
    }
    
    @Override
    public void execute(){
        
        try {
            if(variable!=null){
                variable.execute();
                SymbolTable table = new SymbolTable();
                Parameter parametroA = new Parameter("variable",variable.getName(),line,column);
                if(variable.getType().equalsIgnoreCase("int") || parametroA.getParameter().equalsIgnoreCase("int")){
                    Declaration declaration = variable.getValue();
                    if(declaration!=null){
                        Parameter parametro = declaration.execute();
                        int valor = Integer.parseInt(parametro.value());
                        huntil.execute(valor, variable.getName());
                    }
                    new SymbolTable().eliminateContext(this);
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Variable de tipo "+variable.getType()+"no aceptada en el repeat",variable.getName(),"Declarar como int en lugar de "+variable.getType(),line, column));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("for ( ");
        string.append(variable.writeCode());
        string.append(huntil.writeCode(variable.getName()));
        return string.toString();
    }
    
}
