/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.error;

import java.util.ArrayList;
import com.chtml.error.LexicalError;
import javax.swing.JOptionPane;
/**
 *
 * @author camran1234
 */
public class ErrorHandler {
    ///Lists for the errors generated in the html part
    public static ArrayList<LexicalError> lexicalErrors = new ArrayList();
    public static ArrayList<SyntaxError> syntaxErrors = new ArrayList();
    public static ArrayList<SemanticError> semanticErrors = new ArrayList();
    //List of the script part
    public static ArrayList<LexicalError> lexicalErrorsScript = new ArrayList();
    public static ArrayList<SyntaxError> syntaxErrorsScript = new ArrayList();
    public static ArrayList<SemanticError> semanticErrorsScript = new ArrayList();
    /**
     * The initialiaze of a new instace of ErrorHandler class will reset all the parameters that contains
     */
    public ErrorHandler(){
        
    }
    
    public boolean haveErrors(){
        if(lexicalErrors.size()!=0 || syntaxErrors.size()!=0 || semanticErrors.size()!=0 || lexicalErrorsScript.size()!=0 || 
                syntaxErrorsScript.size()!=0|| semanticErrorsScript.size()!=0){
            return true;
        }
        return false;
    }
    
    public boolean isCompilable(){
        boolean result=false;
        if(semanticErrors.size()==0 && lexicalErrorsScript.size()==0 && syntaxErrorsScript.size()==0 && semanticErrorsScript.size()==0){
            result=true;
        }
        return result;
    }
    
    public void resetHandler(){
        this.lexicalErrors = new ArrayList();
        this.syntaxErrors = new ArrayList();
        this.semanticErrors = new ArrayList();
        this.lexicalErrorsScript = new ArrayList();
        this.syntaxErrorsScript = new ArrayList();
        this.semanticErrorsScript = new ArrayList();
    }
    
    public void add(Error error){
        if(error instanceof LexicalError){
            lexicalErrors.add((LexicalError)error);
        }else if(error instanceof SyntaxError){
            syntaxErrors.add((SyntaxError)error);
        }else if(error instanceof SemanticError){
            semanticErrors.add((SemanticError)error);
        }
    }
    
    public void addScript(Error error){
        if(error instanceof LexicalError){
            lexicalErrorsScript.add((LexicalError)error);
        }else if(error instanceof SyntaxError){
            syntaxErrorsScript.add((SyntaxError)error);
        }else if(error instanceof SemanticError){
            semanticErrorsScript.add((SemanticError)error);
        }
    }
    
}
