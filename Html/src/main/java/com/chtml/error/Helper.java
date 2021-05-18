/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.error;

/**
 *
 * @author camran1234
 */
public class Helper {
    
    /**
     * Comprobacion para las igualaciones
     * @param left
     * @param right
     * @return 
     */
    public Boolean comprobacionIgualar(String left, String right){
        if(left.equalsIgnoreCase("int")){
            if(right.equalsIgnoreCase("int")){
                return true;
            }else if(right.equalsIgnoreCase("decimal")){
                return true;
            }else if(right.equalsIgnoreCase("char")){
                return true;
            }else if(right.equalsIgnoreCase("string")){
                return false;
            }else if(right.equalsIgnoreCase("boolean")){
                return false;
            }
        }else if(left.equalsIgnoreCase("decimal")){
            if(right.equalsIgnoreCase("int")){
                return true;
            }else if(right.equalsIgnoreCase("decimal")){
                return true;
            }else if(right.equalsIgnoreCase("char")){
                return true;
            }else if(right.equalsIgnoreCase("string")){
                return false;
            }else if(right.equalsIgnoreCase("boolean")){
                return false;
            }
        }else if(left.equalsIgnoreCase("char")){
            if(right.equalsIgnoreCase("int")){
                return true;
            }else if(right.equalsIgnoreCase("decimal")){
                return false;
            }else if(right.equalsIgnoreCase("char")){
                return true;
            }else if(right.equalsIgnoreCase("string")){
                return false;
            }else if(right.equalsIgnoreCase("boolean")){
                return false;
            }
        }else if(left.equalsIgnoreCase("string")){
            if(right.equalsIgnoreCase("int")){
                return false;
            }else if(right.equalsIgnoreCase("decimal")){
                return false;
            }else if(right.equalsIgnoreCase("char")){
                return false;
            }else if(right.equalsIgnoreCase("string")){
                return true;
            }else if(right.equalsIgnoreCase("boolean")){
                return false;
            }
        }else if(left.equalsIgnoreCase("boolean")){
            if(right.equalsIgnoreCase("int")){
                return false;
            }else if(right.equalsIgnoreCase("decimal")){
                return false;
            }else if(right.equalsIgnoreCase("char")){
                return false;
            }else if(right.equalsIgnoreCase("string")){
                return false;
            }else if(right.equalsIgnoreCase("boolean")){
                return true;
            }
        }
        
        return false;
    }
    
    public String tipoDivision(String leftType, String rightType){
        String resultado = "";
        if(leftType.equalsIgnoreCase("int")){
            if(rightType.equalsIgnoreCase("int")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "int";
            }
        }else if(leftType.equalsIgnoreCase("string")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "null";
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "decimal";
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "int";
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "null";
            }
        }        
        return resultado;
    }
    
    public String tipoMultiplicacion(String leftType, String rightType){
        String resultado = "";
        if(leftType.equalsIgnoreCase("int")){
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "int";
            }
        }else if(leftType.equalsIgnoreCase("string")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "null";
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "decimal";
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "int";
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "boolean";
            }
        }        
        return resultado;
    }
    
    public String tipoResta(String leftType, String rightType){
        String resultado = "";
        if(leftType.equalsIgnoreCase("int")){
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "int";
            }
        }else if(leftType.equalsIgnoreCase("string")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "null";
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "decimal";
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "null";
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "null";
            }
        }        
        return resultado;
    }
    
    public String tipoSuma(String leftType, String rightType){
        String resultado = "";
        if(leftType.equalsIgnoreCase("int")){
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "string";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "int";
            }
        }else if(leftType.equalsIgnoreCase("string")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "string";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "string";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "string";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "string";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "null";
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "string";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "decimal";
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "string";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "int";
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "null";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "decimal";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "int";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "boolean";
            }
        }        
        return resultado;
    }
    
    public boolean resultadosDivision(String leftType, String rightType, int line, int column){
        if(leftType.equalsIgnoreCase("int")){
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }
        }else if(leftType.equalsIgnoreCase("string")){            
            if(rightType.equalsIgnoreCase("int")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor int",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor decimal",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("char")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor char",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("boolean")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor boolean",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                SemanticError error = new SemanticError("No se puede dividir "+leftType+" con "+rightType,"","Cambiar el valor boolean",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }
        }        
        return false;
    }
    
    public boolean resultadosMultiplicacion(String leftType, String rightType, int line, int column){        
        if(leftType.equalsIgnoreCase("int")){
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }
        }else if(leftType.equalsIgnoreCase("string")){            
            if(rightType.equalsIgnoreCase("int")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor int",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor decimal",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("char")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor char",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("boolean")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor boolean",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }
        }        
        return false;
    }
    
    public boolean resultadosResta(String leftType, String rightType, int line, int column){        
        if(leftType.equalsIgnoreCase("int")){
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }
        }else if(leftType.equalsIgnoreCase("string")){            
            if(rightType.equalsIgnoreCase("int")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor int",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor decimal",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("char")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor char",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("boolean")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor boolean",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor boolean",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor char",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("boolean")){
                SemanticError error = new SemanticError("No se puede multiplicar "+leftType+" con "+rightType,"","Cambiar el valor boolean",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }
        }        
        return false;
    }
    
    public boolean resultadosSuma(String leftType, String rightType, int line, int column){        
        if(leftType.equalsIgnoreCase("int")){
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }
        }else if(leftType.equalsIgnoreCase("decimal")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }            
        }else if(leftType.equalsIgnoreCase("string")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                SemanticError error = new SemanticError("No se puede sumar "+leftType+" con "+rightType,"","Cambiar el valor boolean",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }            
        }else if(leftType.equalsIgnoreCase("char")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                return true;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            if(rightType.equalsIgnoreCase("int")){
                return true;
            }else if(rightType.equalsIgnoreCase("decimal")){
                return true;
            }else if(rightType.equalsIgnoreCase("string")){
                SemanticError error = new SemanticError("No se puede sumar "+leftType+" con "+rightType,"","Cambiar el valor String",line, column);
                new ErrorHandler().addScript(error);
                return false;
            }else if(rightType.equalsIgnoreCase("char")){
                return true;
            }else if(rightType.equalsIgnoreCase("boolean")){
                return true;
            }
        }        
        return false;
    }
    
    public String getType(Object value){
        String string = String.valueOf(value);
        
        if(isInt(string)){
            return "int";
        }else if(isDecimal(string)){
            return "decimal";
        }else if(isString(string)){
            return "string";
        }else if(isChar(string)){
            return "char";
        }else if(isBoolean(string)){
            return "boolean";
        }

        return "";
    }
    
    /**
     * Genera un resultado segun la tabla OR
     * @param leftV
     * @param rightV
     * @return 
     */
    public boolean sumaBoleanos(String leftV, String rightV){
        try {
            boolean left = Boolean.parseBoolean(leftV);
            boolean right = Boolean.parseBoolean(rightV);
            if(left && right){
                return true;
            }else if(!left && right){
                return true;
            }else if(left && !right){
                return true;
            }else if(!left && !right){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * Genera un resultado segun la tabla AND
     * @param leftV
     * @param rightV
     * @return 
     */
    public boolean multiplicacionBooleanos(String leftV, String rightV){
        try {
            boolean left = Boolean.parseBoolean(leftV);
            boolean right = Boolean.parseBoolean(rightV);
            if(left && right){
                return true;
            }else if(!left && right){
                return false;
            }else if(left && !right){
                return false;
            }else if(!left && !right){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int booleanToNumber(String value){
        if(value.equalsIgnoreCase("true")){
            return 1;
        }else if(value.equalsIgnoreCase("false")){
            return 0;
        }
        
        return 0;
    }
    
    public boolean isInt(String value){
        try {
            int number = Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isDecimal(String value){
        try {
            float number = Float.parseFloat(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isString(String value){
        if(value.charAt(0)=='\"' && value.charAt(value.length()-1)=='\"'){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isChar(String value){
        if(value.charAt(0)=='\'' && value.charAt(value.length()-1)=='\''){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isBoolean(String value){
        if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")){
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
