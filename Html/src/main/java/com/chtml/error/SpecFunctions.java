/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.error;

import com.chtml.code.Operation;
import com.chtml.tag.Parameter;

/**
 *
 * @author camran1234
 */
public class SpecFunctions {

     int line, column;
    private String typeThrows="";
    private Operation value;
    
    public SpecFunctions(){
        //nothing
    }
    
    public SpecFunctions(String type, Operation value, int line, int column){
        this.typeThrows = type;
        this.value = value;
        this.line = line;
        this.column = column;
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        Parameter parameter;
        switch(typeThrows){
            case "ASC":
                string.append(" ASC("+value.writeCode()+") ");
                break;
            case "DESC":
                string.append(" DESC("+value.writeCode()+") ");
                break;
            case "LETPAR_NUM":
                string.append(" LETPAR_NUM("+value.writeCode()+") ");
                break;
            case "LETIMPAR_NUM":
                string.append(" LETIMPAR_NUM("+value.writeCode()+") ");
                break;
            case "Reverse":
                string.append(" Reverse("+value.writeCode()+") ");
                break;
            case "RandChar":
                string.append(" RandChar() ");
                break;
            case "RandInt":
                string.append(" RandInt() ");
                break;
        }
        
        return string.toString();
    }
    
    
    public Parameter execute(){
        Parameter parameter = null;
        
        if(typeThrows.equalsIgnoreCase("ASC")){
            if(value!=null){
                parameter = new Parameter("string",this.ASC(value.execute()),line, column);
            }
        }else if(typeThrows.equalsIgnoreCase("DESC")){
            if(value!=null){
                parameter = new Parameter("string",this.DESC(value.execute()),line, column);
            }
        }else if(typeThrows.equalsIgnoreCase("LETPAR_NUM")){
            if(value!=null){
                parameter = new Parameter("string",this.LETPAR_NUM(value.execute()),line, column);
            }
        }else if(typeThrows.equalsIgnoreCase("LETIMPAR_NUM")){
            if(value!=null){
                parameter = new Parameter("string",this.LETIMPAR_NUM(value.execute()),line, column);
            }
        }else if(typeThrows.equalsIgnoreCase("Reverse")){
            if(value!=null){
                parameter = new Parameter("string",this.Reverse(value.execute()),line, column);
            }
        }else if(typeThrows.equalsIgnoreCase("RandChar")){
            parameter = new Parameter("char",this.RandChar(), line, column);
        }else if(typeThrows.equalsIgnoreCase("RandInt")){
            parameter = new Parameter("int",this.RandInt(), line, column);
        }
        
        return parameter;
    }
    
    
    
    
    /**
     * Funcion que reemplaza los caracteres pares por su codigo ascii
     * @param cadena
     * @return 
     */
    public String LETPAR_NUM(Parameter parametro){
        StringBuffer string = new StringBuffer();
        if(parametro!=null){
            String type = parametro.getParameter();
            //Agrega la funcion
            if(type.equalsIgnoreCase("string")){
                String cadena = parametro.value();
                for (int index=0; index<cadena.length(); index++){
                    if((index+1)%2==0){
                        char auxiliar = cadena.charAt(index);
                        int ascii = (int)auxiliar;
                        string.append(ascii);
                    }else{
                        string.append(cadena.charAt(index));
                    }
                }
            }else{
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Se necesita un string",type,"Colocar una cadena",parametro.line, parametro.column));
            }
        }
        
        return string.toString();
    }
    
    public String LETIMPAR_NUM(Parameter parametro){
        StringBuffer string = new StringBuffer();
        
        if(parametro!=null){
            String type = parametro.getParameter();
            
            if(type.equalsIgnoreCase("string")){
                String cadena = parametro.value();
                for (int index=0; index<cadena.length(); index++){
                    if((index+1)%2==0){
                        string.append(cadena.charAt(index));
                    }else{
                        char auxiliar = cadena.charAt(index);
                        int ascii = (int)auxiliar;
                        string.append(ascii);
                    }
                }
            }else{
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Se necesita un string",type,"Colocar una cadena",parametro.line, parametro.column));
            }
            
        }
        
        return string.toString();
    }
    
    /**
     * Ordena ascendentemente una cadena segun su codigo ascci
     * @param word
     * @return 
     */
    public String ASC(Parameter parametro){
        StringBuffer string = new StringBuffer();
        
        if(parametro!=null){
            String type=parametro.getParameter();
            if(type.equalsIgnoreCase("string")){
                String word = parametro.value();
                char[] chars = word.toCharArray();
                char auxiliar;
                for(int i=0; i<chars.length;i++){
                    for(int j=1; j<(chars.length-i);j++){
                        if(chars[j-1]>chars[j]){
                            auxiliar = chars[j-1];
                            chars[j-1] = chars[j];
                            chars[j]=auxiliar;
                        }
                    }
                }

                for(int index=0; index<chars.length; index++){
                    string.append(chars[index]);
                }
                
            }else{
               ErrorHandler.semanticErrorsScript.add(new SemanticError("Se necesita un string",type,"Colocar una cadena",parametro.line, parametro.column)); 
            }
            
            
        }
        
        return string.toString();
    }
    
    /**
     * Ordena descendentemente una cadena segun su coigo ascci
     * @param word
     * @return 
     */
    public String DESC(Parameter parametro){
        StringBuffer string = new StringBuffer();
        
        if(parametro!=null){
            String type = parametro.getParameter();
            if(type.equalsIgnoreCase("string")){
                String word = parametro.value();
                char[] chars = word.toCharArray();
                char auxiliar;
                for(int i=0; i<chars.length;i++){
                    for(int j=1; j<(chars.length-i);j++){
                        if(chars[j-1]<chars[j]){
                            auxiliar = chars[j-1];
                            chars[j-1] = chars[j];
                            chars[j]=auxiliar;
                        }
                    }
                }

                for(int index=0; index<chars.length; index++){
                    string.append(chars[index]);
                }        
            }else{
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Se necesita un string",type,"Colocar una cadena",parametro.line, parametro.column)); 
            }
        }
        
        
        
        return string.toString();
    }
    
    /**
     * Da vuelta a una cadena
     * @param word
     * @return 
     */
    public String Reverse(Parameter parameter){
        StringBuffer string = new StringBuffer();
        
        if(parameter!=null){
            String type = parameter.getParameter();
            if(type.equalsIgnoreCase("string")){
                String word = parameter.value();
                char[] chars = word.toCharArray();     
                for(int index=chars.length-1; index>=0; index--){
                    string.append(chars[index]);
                }
            }else{
                ErrorHandler.semanticErrorsScript.add(new SemanticError("Se necesita un string",type,"Colocar una cadena",parameter.line, parameter.column)); 
            }
        }
        
        return string.toString();
    }
    
    /**
     * Lanza un caracter aleatorio entre a-z y A-Z
     * @return 
     */
    public String RandChar(){
        char value='a';
        int min=1;
        int max=2;
        int number;
        int typeChar = (int)Math.floor(Math.random()*(max-min+1)+min);
        //if its 1 return a az char
        if(typeChar==1){
            min = 97;
            max = 122;
            number = (int)Math.floor(Math.random()*(max-min+1)+min);
            value = (char) number;
        }// if its 2 return an AZ char
        else{
            min = 65;
            max = 90;
            number = (int)Math.floor(Math.random()*(max-min+1)+min);
            value = (char) number;
        }
        return String.valueOf(value);
    }
    
    /**
     * Lanza un numero aleatorio entre 0-9
     * @return 
     */
    public String RandInt(){
        int min=0;
        int max=9;
        int result = (int)Math.floor(Math.random()*(max-min+1)+min);
        return String.valueOf(result);
    }
    
    
    
    public String generarDivision(String leftType, String rightType, String left, String right, int line, int column){
        String resultado = "";
         if(leftType.equalsIgnoreCase("int")){
             int numero1 = Integer.parseInt(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
                
            }else if(rightType.equalsIgnoreCase("String")){
                //error
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                if(numero2){
                    resultado += numero1 / 1;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }
        }else if(leftType.equalsIgnoreCase("String")){            
            
            if(rightType.equalsIgnoreCase("int")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("String")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "";
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            double numero1 = Double.parseDouble(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }else if(rightType.equalsIgnoreCase("String")){
                //error
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                if(numero2){
                    resultado += numero1 / 1;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            char numero1 = left.charAt(0);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }else if(rightType.equalsIgnoreCase("String")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                if(numero2!=0){
                    resultado += numero1 / numero2;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                if(numero2){
                    resultado += numero1 + 1;
                }else{
                    ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                    line, column));
                }
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){          
            boolean numero1 = Boolean.parseBoolean(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                if(numero1){
                    resultado += 1 / numero2;
                }else{
                    if(numero2!=0){
                        resultado += 0 / numero2;
                    }else{
                        ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                        line, column));
                    }
                }
            }else if(rightType.equalsIgnoreCase("String")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                if(numero1){
                    resultado += 1 / numero2;
                }else{
                    if(numero2!=0){
                    resultado += 0 / numero2;
                    }else{
                        ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                        line, column));
                    }
                }
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                if(numero1){
                    resultado += 1 + numero2;
                }else{
                    if(numero2!=0){
                    resultado += 0 / numero2;
                    }else{
                        ErrorHandler.semanticErrorsScript.add(new SemanticError("Division Indefinida, no se puede dividir entre 0",""+numero2,"Cambiar el cero",
                        line, column));
                    }
                }
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "";
            }
        }        
        return resultado;
    }
    
    public String generarMultiplicacion(String leftType, String rightType, String left, String right){
        String resultado ="";
        if(leftType.equalsIgnoreCase("int")){
            int numero1 = Integer.parseInt(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("String")){
                resultado +="";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                if(numero2){
                    resultado += numero1 * 1;
                }else{
                    resultado += numero1 * 0;
                }
            }
        }else if(leftType.equalsIgnoreCase("String")){            
            String numero1 = left;
            if(rightType.equalsIgnoreCase("int")){
                resultado +="";
            }else if(rightType.equalsIgnoreCase("String")){
                resultado +="";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado +="";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado +="";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado +="";
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            double numero1 = Double.parseDouble(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("String")){
                resultado +="";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2=Double.parseDouble(right);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                if(numero2){
                    resultado += numero1 * 1;
                }else{
                    resultado += numero1 * 0;
                }
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            char numero1 = left.charAt(0);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("String")){
                resultado +="";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                resultado += numero1 * numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                if(numero2){
                    resultado += numero1 * 1;
                }else{
                    resultado += numero1 * 0;
                }
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            boolean numero1 = Boolean.parseBoolean(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                if(numero1){
                    resultado += 1 * numero2;
                }else{
                    resultado += 0*numero2;
                }
            }else if(rightType.equalsIgnoreCase("String")){
                resultado +="";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                if(numero1){
                    resultado += 1* numero2;
                }else{
                    resultado += 0 * numero2;
                }
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                if(numero1){
                    resultado += 1 * numero2;
                }else{
                    resultado += 0 * numero2;
                }
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                boolean answer = new Helper().multiplicacionBooleanos(left, right);
                if(answer){
                    resultado = "true";
                }else{
                    resultado = "false";
                }
            }
        }        
        
        return resultado;
    }
    
    public String generarResta(String leftType, String rightType, String left, String right){        
        String resultado = "";
        if(leftType.equalsIgnoreCase("int")){
            int numero1 = Integer.parseInt(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("String")){                
                //its error
                resultado = "";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                if(numero2){
                    resultado += numero1 -1;
                }else{
                    resultado += numero1-0;
                }
            }
        }else if(leftType.equalsIgnoreCase("String")){            
            String numero1 = left;
            if(rightType.equalsIgnoreCase("int")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("String")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("decimal")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("char")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado = "";
            }        
        }else if(leftType.equalsIgnoreCase("decimal")){            
            double numero1 = Double.parseDouble(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("String")){
                resultado = "";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = Boolean.parseBoolean(right);
                if(numero2){
                    resultado += numero1 - 1;
                }else{
                    resultado += numero1-0;
                }
            }           
        }else if(leftType.equalsIgnoreCase("char")){            
            char numero1 = left.charAt(0);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("String")){
                //error
                resultado = "";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = right.charAt(0);
                resultado += numero1 - numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                //error
                resultado = "";
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){  
            boolean numero1 = Boolean.parseBoolean(left);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(right);
                if(numero1){
                    resultado += 1 - numero2;
                }else{
                    resultado += 0 - numero2;
                }
            }else if(rightType.equalsIgnoreCase("String")){
                resultado += "";
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(right);
                if(numero1){
                    resultado += 1 - numero2;
                }else{
                    resultado +=  0 -numero2;
                }
            }else if(rightType.equalsIgnoreCase("char")){
                resultado += "";
            }else if(rightType.equalsIgnoreCase("boolean")){
                resultado += "";
            }
        }        
        return resultado;
    }
    
    public String generarSuma(String leftType, String rightType, String leftVal, String rightVal){
        Helper helper = new Helper();
        String resultado="";
        if(leftType.equalsIgnoreCase("int")){
            int numero1=Integer.parseInt(leftVal);
            if(rightType.equalsIgnoreCase("int")){
                
                int numero2=Integer.parseInt(rightVal);
                resultado += numero1+numero2;
            }else if(rightType.equalsIgnoreCase("decimal")){
                
                double numero2 = Double.parseDouble(rightVal);
                resultado += numero1+numero2;
            }else if(rightType.equalsIgnoreCase("string")){
                
                resultado += numero1 + rightVal;
            }else if(rightType.equalsIgnoreCase("char")){
                
                char numero2 = rightVal.charAt(0);
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                int numero2;
                if(rightVal.equalsIgnoreCase("false")){
                    numero2=0;
                }else{
                    numero2=1;
                }
                resultado += numero1 + numero2;
            }
        }else if(leftType.equalsIgnoreCase("decimal")){            
            double numero1 = Double.parseDouble(leftVal);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(rightVal);
                resultado += numero1+numero2;
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(rightVal);
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("string")){
                resultado += numero1 + rightVal;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = rightVal.charAt(0);
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                int numero2;
                if(rightVal.equalsIgnoreCase("false")){
                    numero2=0;
                }else{
                    numero2=1;
                }
                resultado += numero1 + numero2;
            }            
        }else if(leftType.equalsIgnoreCase("string")){            
            String numero1 = leftVal;
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(rightVal);
                resultado +=  numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(rightVal);
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("string")){
                String numero2 = rightVal;
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = rightVal.charAt(0);
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                //its error
                resultado = "";
            }            
        }else if(leftType.equalsIgnoreCase("char")){            
            char numero1 = leftVal.charAt(0);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(rightVal);
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(rightVal);
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("string")){
                String numero2 = rightVal;
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = rightVal.charAt(0);
                resultado += numero1 + numero2;
            }else if(rightType.equalsIgnoreCase("boolean")){
                int numero2;
                if(rightVal.equalsIgnoreCase("false")){
                    numero2 = 0;
                }else{
                    numero2 = 1;
                }
                resultado += numero1 + numero2;
            }            
        }else if(leftType.equalsIgnoreCase("boolean")){            
            boolean numero1 = Boolean.parseBoolean(leftVal);
            if(rightType.equalsIgnoreCase("int")){
                int numero2 = Integer.parseInt(rightVal);
                if(numero1){
                    resultado += 1 + numero2;
                }else{
                    resultado += 0 + numero2;
                }
                
            }else if(rightType.equalsIgnoreCase("decimal")){
                double numero2 = Double.parseDouble(rightVal);
                if(numero1){
                    resultado += 1 + numero2;
                }else{
                    resultado += 0 + numero2;
                }
                
            }else if(rightType.equalsIgnoreCase("string")){
                resultado = "";                
            }else if(rightType.equalsIgnoreCase("char")){
                char numero2 = rightVal.charAt(0);
                if(numero1){
                    resultado += 1+numero2;
                }else{
                    resultado += 0+numero2;
                }                
            }else if(rightType.equalsIgnoreCase("boolean")){
                boolean numero2 = helper.sumaBoleanos(leftVal, rightVal);
                if(numero2){
                    resultado = "true";
                }else{
                    resultado = "false";
                }
            }
        }        
        
        return resultado;
    }
    
}
