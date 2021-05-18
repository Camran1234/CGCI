/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import com.chtml.error.Helper;
import com.chtml.tag.Parameter;

/**
 *
 * @author camran1234
 */
public class Condition {        
    
    
    private Condition left;
    //Puede ser &&, ||, !
    private String operador="";
    private Condition right;
    
    private String specialOperador="";
    private Condition comparation;
    
    private Comparation value;
    private int line,column;
    
    private boolean onParenthesis=false;
    
    public void setParenthesis(){
        this.onParenthesis=true;
    }
    
    //Analiza booleanamente los resultados
    public Condition(Condition left, String operador, Condition right, int line, int column){
        if(left!=null && right!=null){
            this.line = line;
            this.column = column;
            this.left = left;
            this.right = right;
            this.operador = operador;
        }
    }
    
    public Condition(Comparation value, int line, int column){
        if(value!=null){
           this.value = value;
           this.line = line;
           this.column = column;
        }
    }
    
    public Condition(String specialOperador, Condition condition, int line, int column){
        if(condition != null){
            this.specialOperador = specialOperador;
            this.comparation = condition;
            this.line = line;
            this.column = column;
        }
    }
    
    public Operation execute(){        
        if(this.left !=null & this.right !=null){
            //generate results
            Operation operationL = left.execute();
            Operation operationR = right.execute();
            boolean l = Boolean.parseBoolean(operationL.execute().value());
            boolean r = Boolean.parseBoolean(operationR.execute().value());
            Helper helper = new Helper();
            boolean resultado;
            //Este parte maneja el parametro AND y OR
            if(operador.equalsIgnoreCase("&&")){
                resultado = helper.multiplicacionBooleanos(operationL.execute().value(), operationR.execute().value());
                Parameter parameter = new Parameter("boolean");
                parameter.setRawValue(Boolean.toString(resultado));
                return new Operation(parameter);
            }else if(operador.equalsIgnoreCase("||")){
                resultado = helper.sumaBoleanos(operationL.execute().value(), operationR.execute().value());
                Parameter parameter = new Parameter("boolean");
                parameter.setRawValue(Boolean.toString(resultado));
                return new Operation(parameter);
            }
        }else if(this.comparation!=null){
            //Esta parte maneja el parametro not
            Operation operation = this.comparation.execute();
            if(specialOperador.equals("!")){
                //Obtenemos el parametro
                //En este punto ya solo es un parametro raw
                Parameter parametro = operation.execute();
                boolean answer = Boolean.parseBoolean(parametro.value());
                if(answer){
                    answer = false;
                }else{
                    answer = true;
                }   
                parametro.setRawValue(Boolean.toString(answer));
                return new Operation(parametro);
            }
        }else if(this.value!=null){
            return this.value.execute();
        }
        
        
        return null;
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        if(onParenthesis){
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
        if(this.left!=null && this.right!=null){
            string.append(left.writeCode());
            string.append(operador);
            string.append(right.writeCode());
        }else if(this.comparation!=null){
            string.append(comparation.writeCode());
        }else if(this.value!=null){
            string.append(value.writeCode());
        }
        return string.toString();
    }
    
    
    
}
