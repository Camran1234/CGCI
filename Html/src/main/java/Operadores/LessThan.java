/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operadores;

import com.chtml.code.Operation;
import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.tag.Parameter;

/**
 *
 * @author camran1234
 */
public class LessThan implements Compare{
 @Override
    public Parameter Compare(Operation left, Operation right, int line, int column) {
        //Execute the operation to get the result
        Parameter leftP = left.execute();
        Parameter rightP = right.execute();
        if(left!=null && right !=null){
            Parameter resultado = new Parameter("boolean");
            resultado.setRawValue(Boolean.toString(Calculate(leftP,rightP)));
            return resultado;
        }else{
            if(left == null && right !=null){
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Valor izquierdo nulo","En comparacion logica","Asignar un valor",line, column));
            }else if(left !=null && right !=null){
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Valor derecho nulo","En comparacion logica","Asignar un valor",line, column));
            }else{
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Comparacion Nula","En comparacion logica","Asignar un valor",line, column));
            }
        }
        
        return null;
    }

    @Override
    public boolean Calculate(Parameter left, Parameter right) {
        String typeL = left.getParameter();
        String typeR = right.getParameter();
        if(typeL.equalsIgnoreCase("int")){
            int A = Integer.parseInt(left.value());
            if(typeR.equalsIgnoreCase("int")){
                int B = Integer.parseInt(right.value());
                if(A<=B){
                    return true;
                }else{
                    return false;
                }
            }else if(typeR.equalsIgnoreCase("decimal")){
                double B = Double.parseDouble(right.value());
                if(A<=B){
                    return true;
                }else{
                    return false;
                }
            }else if(typeR.equalsIgnoreCase("char")){
                char B = right.value().charAt(0);
                if(A<=B){
                    return true;
                }else{
                    return false;
                }
            }else if(typeR.equalsIgnoreCase("string")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("boolean")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }
        }else if(typeL.equalsIgnoreCase("decimal")){
            double A = Double.parseDouble(left.value());
            if(typeR.equalsIgnoreCase("int")){
                int B = Integer.parseInt(right.value());
                if(A<=B){
                    return true;
                }else {
                    return false;
                }
            }else if(typeR.equalsIgnoreCase("decimal")){
                double B = Double.parseDouble(right.value());
                if(A<=B){
                    return true;
                }else{
                    return false;
                }
            }else if(typeR.equalsIgnoreCase("char")){
                char B = right.value().charAt(0);
                if(A <=B){
                    return true;
                }else{
                    return false;
                }
                
            }else if(typeR.equalsIgnoreCase("string")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("boolean")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }
        }else if(typeL.equalsIgnoreCase("char")){
            char A = left.value().charAt(0);
            if(typeR.equalsIgnoreCase("int")){
                int B = Integer.parseInt(right.value());
                if(A<=B){
                    return true;
                }else{
                    return false;
                }
            }else if(typeR.equalsIgnoreCase("decimal")){
                double B = Double.parseDouble(right.value());
                if(A<=B){
                    return true;
                }else{
                    return false;
                }
            }else if(typeR.equalsIgnoreCase("char")){
                char B = right.value().charAt(0);
                if(A<=B){
                    return true;
                }else{
                    return false;
                }
            }else if(typeR.equalsIgnoreCase("string")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("boolean")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }
        }else if(typeL.equalsIgnoreCase("string")){
            if(typeR.equalsIgnoreCase("int")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("decimal")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("char")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("string")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("boolean")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }
        }else if(typeL.equalsIgnoreCase("boolean")){
            if(typeR.equalsIgnoreCase("int")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("decimal")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("char")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("string")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }else if(typeR.equalsIgnoreCase("boolean")){
                String B = right.value();
                ErrorHandler.semanticErrorsScript.add(new SemanticError("No se puede comparar un "+typeL+" con un "+typeR,B,"Modificar la operacion",
                left.line, left.column));                
            }
        }
        
        
        return false;
    }
    
}
