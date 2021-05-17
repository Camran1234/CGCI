/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.tag;

import com.chtml.code.Function;
import com.chtml.error.ErrorHandler;
import com.chtml.error.SemanticError;
import com.chtml.script.ScriptLex;
import com.chtml.script.ScriptParser;
import java.io.StringReader;
import com.chtml.table.SymbolTable;
import java.util.ArrayList;

/**
 *
 * @author camran1234
 */
public class CScripting extends Tag{
    ArrayList<Function> funciones = new ArrayList();
    
    public CScripting(int line, int column){
        super(line, column);
    }
    
    @Override 
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("<script>\n");
        for(int index=0; index<funciones.size(); index++){
            if(funciones.get(index).isOnLoad()){
                string.append(funciones.get(index).writeCode());
            }
        }
        string.append("</script>\n");
        return string.toString();
    }
    
    @Override
    public void execute(){
        String code = text.value();
        try {
            StringReader reader = new StringReader(code);
            ScriptLex lexic = new ScriptLex(reader);
            ScriptParser parser = new ScriptParser(lexic);
            parser.setLine(line-1);
            parser.setColumn(0);
            parser.parse();
            //Obtenemos todas las funciones
            this.funciones = parser.getFunctions();
            int onload=0;
            int onloadLine =0;
            int onloadColumn=0;
            String extraFun = "";
            //Comprobamos de que solo haya 0 o 1 funcion onload
            for(int index=0; index<funciones.size(); index++){
                if(funciones.get(index).isOnLoad()){
                    if(onload!=0){
                        onloadLine = funciones.get(index).getLine();
                        onloadColumn = funciones.get(index).getColumn();
                        extraFun = funciones.get(index).getName();ErrorHandler.semanticErrorsScript.add(new SemanticError("Solo puede haber como maximo una funcion OnLoad",extraFun,"Remover una funcion",onloadLine, onloadColumn));
                    }
                    onload++;
                }
            }
            
            if(onload<=1){
                //Colocamos las funciones en la tabla
                SymbolTable table = new SymbolTable();
                for(int index=0; index<funciones.size(); index++){
                    if(funciones.get(index).isOnLoad()==false){
                        table.addFunction(funciones.get(index));
                    }
                    
                }
                
                //ejecutamos las funciones si estan
                for(int index=0; index<funciones.size(); index++){ 
                    if(funciones.get(index).isOnLoad()==true){
                        funciones.get(index).execute();
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
