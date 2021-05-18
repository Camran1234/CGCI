/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.table;
import com.chtml.save.SaveReader;
import com.chtml.save.SaveWriter;
import java.util.ArrayList;
/**
 *
 * @author camran1234
 */
public class Holder {
    private ArrayList<HolderCaptcha> array = new ArrayList();
    
    public Holder(){
        this.getAllData();
    }
    
    /**
     * Agrega o actualiza un captcha
     * @param captcha 
     */
    public void addCaptcha(HolderCaptcha captcha){
        //Miramos si ya existe
        boolean founded=false;
        int indexUpdate=0;
        for(int index=0; index<array.size(); index++){
            String id1 = array.get(index).getIdCaptcha();
            String id2 = captcha.getIdCaptcha();
            if(id1.equalsIgnoreCase(id2)){
                indexUpdate=index;
                founded=true;
                break;
            }
        }
        
        if(!founded){
            //Agregamos el captcha
            array.add(captcha);
        }else{
            //Actualizamos el captcha
            array.set(indexUpdate, captcha);
        }
        writeAllData();
    }
    
    
    
    public ArrayList captchas(){
        return array;
    }
    
    public boolean isEmpty(){
        if(array.size()==0){
            return true;
        }else{
            return false;
        }
    }
    
    public HolderCaptcha getCaptchaById(String id){
        for(int index=0; index<array.size(); index++){
            HolderCaptcha captcha = array.get(index);
            if(captcha.getIdCaptcha().equals(id)){
                return captcha;
            }
        }
        return null;
    }
    
    /**
     * Recupera todos los captchas generados
     */
    public void getAllData(){
        //recuperar la info de la base de datos
        SaveReader reader = new SaveReader();
        array = reader.readCaptcha();
    }
    
    /**
     * Escribe el array en formato save para guardarlo en un archivo de texto
     */
    public void writeAllData(){
        SaveWriter writer = new SaveWriter();
        writer.writeCaptcha(array);
    }
    
}
