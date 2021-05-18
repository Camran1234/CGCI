/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.save;

import com.chtml.html.ChtmlLex;
import com.chtml.html.HtmlParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author camran1234
 */
public class SaveReader {
    private String relativePathDb = "./Resources/dbCaptcha.sqgcic";
    
    public SaveReader(){
        //Solo lo declaramos para que nos genere el archivo y la carpeta
        new SaveWriter();
    }
    
    public ArrayList readCaptcha(){
        StringBuffer string = new StringBuffer();
         try(BufferedReader br = new BufferedReader(new FileReader(this.relativePathDb))){
            //Reading file
            String sCurrentLine;
            while((sCurrentLine=br.readLine())!=null){
                string.append(sCurrentLine+"\n");
            }
             //get the code
        StringReader reader = new StringReader(string.toString());
        SaveLex lexico = new SaveLex(reader);
        SaveParser parser = new SaveParser(lexico);
        parser.parse();
        return parser.getCaptchas();
        }catch(Throwable e){
            
            e.printStackTrace();
        }
        return new ArrayList();
    }
    
    public String readCode(String path){
        StringBuffer string = new StringBuffer();
         try(BufferedReader br = new BufferedReader(new FileReader("./"+path))){
            //Reading file
            String sCurrentLine;
            while((sCurrentLine=br.readLine())!=null){
                string.append(sCurrentLine+"\n");
            }
        }catch(Throwable e){
            
            e.printStackTrace();
        }
         return string.toString();
    }
    
    
}
