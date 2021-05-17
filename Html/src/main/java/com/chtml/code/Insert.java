/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.code;
import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.html.ChtmlLex;
import com.chtml.html.HtmlParser;
import com.chtml.table.HtmlData;
import com.chtml.tag.Parameter;
import java.io.StringReader;
/**
 *
 * @author camran1234
 */
public class Insert extends Instruccion{
    private Parameter parametro;
    
    public Insert(Parameter newParameter, int line, int column){
        this.parametro = newParameter;
        this.line = line;
        this.column = column;
    }
    
    
    @Override
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        
        return string.toString();
    }
    
    @Override
    public void execute(){
        if(parametro.getParameter().equalsIgnoreCase("string")==false){
            ErrorHandler.semanticErrorsScript.add(new SemanticError("En la funcion insert solo pueden ir string","Insert","Agregar string",line, column));
        }
        this.cleanCode();
    }
    
    /**
     * Parsea lo que tiene adentro del html
     * @return 
     */
    public String cleanCode(){
        HtmlData data = null;
        try {
            String code = parametro.value();
            StringReader reader = new StringReader(code);
            ChtmlLex lexico = new ChtmlLex(reader);
            HtmlParser parser = new HtmlParser(lexico);
            parser.line = this.line;
            parser.column = this.column;
            parser.parse();
            data = parser.getHtmlData();
            data.execute();
            return data.writeCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    
}
