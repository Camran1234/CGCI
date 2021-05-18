/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.error.ErrorHandler;
import com.chtml.error.Helper;
import com.chtml.error.SemanticError;
import com.chtml.error.SpecFunctions;
import com.chtml.tag.Parameter;

/**
 *
 * @author camran1234
 */
public class Operation{
     int line, column;
    private Operation leftParameter;
    //Operadores: +,-,/,*
    private String operator="";
    private Operation rightParameter;
    //Puede ser int, boolean, string, char, decimal o variable
    private Parameter value;
    private Condition condition;
    private SpecFunctions funciones;
    boolean single=false;
    boolean inParenthesis=false;
    
    private SpecFunctions newFunction;

    // the value
    public Operation(Parameter value){
        if(value!=null){
            this.value=value;
            this.single=true;
            this.line = value.line;
            this.column = value.column;
        }else{
            SemanticError error = new SemanticError("Valor nulo","nulo","Agregar algun valor",line, column);
            ErrorHandler.semanticErrorsScript.add(error);
        }
    }
    
    public Operation(SpecFunctions funcion, int line, int column){
        this.newFunction = funcion;
        this.line = line;
        this.column = column;
    }
    
    //Operaciones Validas +,-,/,*
    public Operation (Operation left, String operator, Operation right,int line, int column){
        if(left == null || right == null){
            if(left == null && right!= null){
                SemanticError error = new SemanticError("Valor Izquierdo Nulo","nulo","Agregar algun valor",line, column);
                ErrorHandler.semanticErrorsScript.add(error);
            }else if(left!=null && right==null){
                SemanticError error = new SemanticError("Valor Derecho Nulo","nulo","Agregar algun valor",line, column);
                ErrorHandler.semanticErrorsScript.add(error);
            }else if(left == null && right==null){
                SemanticError error = new SemanticError("Operacion nula","nulo","Agregar algun valor",line, column);
                ErrorHandler.semanticErrorsScript.add(error);
            }
        }else{
            this.leftParameter = left;
            this.operator = operator;
            this.rightParameter = right;
            this.line = line;
            this.column = column;
        }
    }
    
    public Operation (Condition condition, int line, int column){
        this.condition = condition;
        this.line = line;
        this.column = column;
    }
    
    
    public void setParenthesis(){
        this.inParenthesis = true;
    }
    
    
    /**
     * (2*2)+2
     * Genera un resultado de una operacion aritmetica
     * Retorna un parametro
     * @return 
     */
    public Parameter execute(){
        if(leftParameter!=null && rightParameter!=null){
            Parameter resultado=null;
            Parameter left = leftParameter.execute();
            Parameter right = rightParameter.execute();
            Helper helper = new Helper();
            SpecFunctions functions = new SpecFunctions();
            if(operator.equalsIgnoreCase("+")){
                if(helper.resultadosSuma(left.getParameter(), right.getParameter(), line, column)){
                     resultado = new Parameter(helper.tipoSuma(left.getParameter(), right.getParameter()),
                        functions.generarSuma(left.getParameter(), right.getParameter(), left.value(), right.value()),
                        line,
                        column);
                }
            }else if(operator.equalsIgnoreCase("-")){
                if(helper.resultadosResta(left.getParameter(), right.getParameter(), line, column)){
                     resultado = new Parameter(helper.tipoSuma(left.getParameter(), right.getParameter()),
                        functions.generarResta(left.getParameter(), right.getParameter(), left.value(), right.value()),
                        line,
                        column);
                }
            }else if(operator.equalsIgnoreCase("*")){
                if(helper.resultadosMultiplicacion(left.getParameter(), right.getParameter(), line, column)){
                     resultado = new Parameter(helper.tipoSuma(left.getParameter(), right.getParameter()),
                        functions.generarMultiplicacion(left.getParameter(), right.getParameter(), left.value(), right.value()),
                        line,
                        column);
                }
            }else if(operator.equalsIgnoreCase("/")){
                if(helper.resultadosDivision(left.getParameter(), right.getParameter(), line, column)){
                     resultado = new Parameter(helper.tipoSuma(left.getParameter(), right.getParameter()),
                        functions.generarDivision(left.getParameter(), right.getParameter(), left.value(), right.value(), line, column),
                        line,
                        column);
                }
            }
            
            return resultado;
        }else if(newFunction!=null){
            Parameter parametro = newFunction.execute();
            return parametro;
        }else if(value!=null){
            return value;
        }else if (condition !=null){
            return condition.execute().execute();
        }
        return new Parameter("null","null",line, column);
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        if(this.inParenthesis){
            string.append("(");
            string.append(helperToCode());
            string.append(")");
        }else{
            string.append(helperToCode());
        }
        return string.toString();
    }
    
    public String helperToCode(){
        StringBuffer string = new StringBuffer();
        
        if(leftParameter !=null && rightParameter!=null){
            string.append(leftParameter.writeCode());
            string.append(operator);
            string.append(rightParameter.writeCode());
        }else if(newFunction!=null){
            string.append(newFunction.writeCode());
        }else if(value !=null){
            string.append(value.writeCode());
        }else if(condition !=null){
            string.append(condition.writeCode());
        }
        
        return string.toString();
    }
    
    
    
}
