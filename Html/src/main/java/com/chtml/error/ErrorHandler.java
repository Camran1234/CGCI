/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.error;

import java.util.ArrayList;
import com.chtml.error.LexicalError;
/**
 *
 * @author camran1234
 */
public class ErrorHandler {
    public static ArrayList<LexicalError> lexicalErrors = new ArrayList();
    public static ArrayList<SyntaxError> syntaxErrors = new ArrayList();
    public static ArrayList<SemanticError> semanticErrors = new ArrayList();
    
    /**
     * The initialiaze of a new instace of ErrorHandler class will reset all the parameters that contains
     */
    public ErrorHandler(){
        this.lexicalErrors = new ArrayList();
        this.syntaxErrors = new ArrayList();
        this.semanticErrors = new ArrayList();
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
}
