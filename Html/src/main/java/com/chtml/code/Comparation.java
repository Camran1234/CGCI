/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;

import Operadores.*;
import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.tag.Parameter;
import javax.swing.JOptionPane;

/**
 *
 * @author camran1234
 */
public class Comparation {
    private Operation left;
    //Puede ser ==,!=,<=,<,>=,>
    private String comparador;
    private Operation right;
    //Execute the command to get the value
    private Operation value;
    private int line,column;
    
    
    public Comparation (Operation leftV, String comparador, Operation rightV, int line, int column){
        if(leftV!=null & rightV !=null){
            this.left = leftV;
            this.right = rightV;
            this.comparador = comparador;
            this.line = line;
            this.column = column;
        }
    }
    
    public Comparation(Operation operation){
        if(operation !=null){
            this.value = operation;
            this.line = operation.line;
            this.column = operation.column;
        }
    }
    
    public Operation execute(){
        if(left != null && right != null){
            Operation operation = null;
            switch(comparador){
                case "==":
                    //Genera los resultados, solo colocar la operacion
                    //Retorna un parametro booleano
                    operation = new Operation(new Equalization().Compare(left, right, line, column));
                   break;
                case "!=":
                    operation = new Operation(new Differentiation().Compare(left,right, line, column));
                    break;
                case "<":
                    operation = new Operation(new Less().Compare(left,right, line, column));
                    break;
                case "<=":
                    operation = new Operation(new LessThan().Compare(left,right, line, column));
                    break;
                case ">":
                    operation = new Operation(new Greater().Compare(left,right, line, column));
                    break;
                case ">=":
                    operation = new Operation(new GreaterThan().Compare(left,right, line, column));
                    break;
            }
            return operation;
        }else if(value !=null){
            return value;
        }
        
        return null;
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        if(left !=null && right!=null){
            switch(comparador){
                case "==":
                    Parameter leftP = left.execute();
                    Parameter rightP = right.execute();
                    if(leftP.getParameter().equalsIgnoreCase("string") && rightP.getParameter().equalsIgnoreCase("string")){
                        string.append(left.writeCode() + ".localeCompare("+right.writeCode()+") == 0");
                    }else{
                        string.append(left.writeCode()+" ");
                        string.append("== ");
                        string.append(right.writeCode()+" ");
                    }
                    break;
                case "!=":
                    string.append(left.writeCode()+" ");
                    string.append("!= ");
                    string.append(right.writeCode()+" ");
                    break;
                case "<":
                    string.append(left.writeCode()+" ");
                    string.append("< ");
                    string.append(right.writeCode()+" ");
                    break;
                case "<=":
                    string.append(left.writeCode()+" ");
                    string.append("<= ");
                    string.append(right.writeCode()+" ");
                    break;
                case ">":
                    string.append(left.writeCode()+" ");
                    string.append("> ");
                    string.append(right.writeCode()+" ");
                    break;
                case ">=":
                    string.append(left.writeCode()+" ");
                    string.append(">= ");
                    string.append(right.writeCode()+" ");
                    break;
            }
        }else if(value!=null){
            string.append(value.writeCode());
        }
        
        return string.toString();
    }
    
}
