/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.table;

/**
 *
 * @author camran1234
 */
public class Captcha {
    public static String href="www.google.com";
    public static HtmlData data=null;
    public static int intentos = 0;
    public static int fallos =0;
    public static int aciertos=0;
    
    public Captcha(){
    }
    
    public void reset(){
        data = null;
        href = "www.google.com";
    }
    
    public void setnewLink(String link){
        this.href = link;
    }
    
    public void setData(HtmlData newData){
        this.data = newData;
    }
    
}
