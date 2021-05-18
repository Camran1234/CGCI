/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.save;

import com.chtml.table.HolderCaptcha;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camran1234
 */
public class SaveWriter {
    private String relativePathDb = "./Resources/dbCaptcha.sqgcic";
    
    public SaveWriter(){
        this.checkRoute();
    }
    
    public void writeCaptcha(ArrayList<HolderCaptcha> array){
        StringBuffer string = new StringBuffer();
        
        try(FileOutputStream outputStream = new FileOutputStream(relativePathDb)){
                string.append("db.captcha {\n");
                for(int index=0; index<array.size(); index++){
                    HolderCaptcha aux = array.get(index);
                    string.append("\t[\n");
                    string.append("\t\tID = \""+aux.getIdCaptcha()+"\" ;\n");
                    string.append("\t\tNAME = \""+aux.getNameCaptcha()+"\" ;\n");
                    string.append("\t\tINTENTOS = "+aux.getIntentos()+";\n");
                    string.append("\t\tACIERTOS = "+aux.getAceirtos()+";\n");
                    string.append("\t\tFALLOS = "+aux.getFallos()+";\n");
                    string.append("\t\tDATE = \""+aux.getDate()+"\";\n");
                    string.append("\t\tHREF = \""+aux.getHref()+"\";\n");
                    string.append("\t\tCODE = \"./"+aux.getPrintCode()+"\";\n");
                    this.writeHtml(aux.getCode(), aux.getPrintCode());
                    string.append("\t]\n");
                }
                string.append("}\n");
                writeString(outputStream, string.toString());
                outputStream.close();
        }catch(Throwable ex){
            ex.printStackTrace();
        }
        
    }
    
    public void writeHtml(String text, String path) throws IOException{
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
         try(FileOutputStream outputStream = new FileOutputStream("./"+path)){
                writeString(outputStream, text);
                outputStream.close();
        }catch(Throwable ex){
            ex.printStackTrace();
        }
    }
    
    
    
    public void checkRoute(){
        File file = new File("Resources");
        if(!file.exists() && !file.isDirectory()){
            file.mkdir();
        }
        //check if form.sqf exists
        file = new File("Resources/dbCaptcha.sqgcic");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(SaveWriter.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Method to write
     * @param output
     * @param text
     * @throws IOException 
     */
    private String writeString(FileOutputStream output, String text) throws IOException{
        String addText = text;
        if(output!=null){
            output.write(addText.getBytes());
        }
        return addText;
    }
}
