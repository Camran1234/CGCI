/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.semantic;

import java.util.ArrayList;

/**
 *
 * @author camran1234
 */
public class ErrorHandler {
    private ArrayList<LexicalError> lexicalErrors= new ArrayList<>();
    private ArrayList<SyntaxError> syntaxErrors = new ArrayList<>();
    
    
    public void addLexicalError(LexicalError error){
        this.lexicalErrors.add(error);
    }
    
    public void addSyntaxError(SyntaxError error){
        this.syntaxErrors.add(error);
    }
}
