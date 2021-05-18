/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chtml.table;

import com.chtml.code.Function;
import com.chtml.error.ErrorHandler;
import com.chtml.html.ChtmlLex;
import com.chtml.html.HtmlParser;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.chtml.save.*;
import com.chtml.tag.Tag;
import java.util.ArrayList;
/**
 *
 * @author camran1234
 */
public class HolderCaptcha {
    private String href="https://www.google.com";
    private int intentos=0;
    private int fallos = 0;
    private int aceirtos=0;
    private HtmlData data=null;
    private String idCaptcha="unid";
    private String nameCaptcha="untitled";
    private String code="";
    private Date lastDate=new Date();
    
    public HolderCaptcha(){
        
    }
    
    public HolderCaptcha(HtmlData data, String href, String code){
        this.data = data;
        this.href= href;
        this.code = code;
        this.idCaptcha = new SymbolTable().captchaId;
        this.nameCaptcha = new SymbolTable().captchaName;
    }

    public void createData(String code){
        try {
            new ErrorHandler().resetHandler();
            SymbolTable table =new SymbolTable();
            ArrayList<SymbolV> symbols = table.symbols;
            ArrayList<Function> funciones = table.funciones;
            ArrayList<Tag> tags = table.tags;
            table.clearTable();
            SaveReader help = new SaveReader();
            String codigo = help.readCode(code);
            StringReader reader = new StringReader(codigo);
            ChtmlLex lexico = new ChtmlLex(reader);
            HtmlParser parser = new HtmlParser(lexico);
            parser.parse();
            
            table.clearTable();
            this.data = parser.getHtmlData();
            table.clearTable();
            this.data.execute();
            table.clearTable();
            this.code = codigo;
            table.clearTable();
            //regresamos los parametros de la tabla a donde pertenecen
            table.symbols = symbols;
            table.funciones = funciones;
            table.tags = tags;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void incrementarIntentos(){
        intentos++;
        fallos++;
    }
    
    public String writeCode(){
        intentos++;
        fallos++;
        if(this.data!=null){
            data.execute();
            String text = data.writeCode();
            return text;
        }
        return "";
    }
    
    public String getDate(){
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
         return formatter.format(lastDate);
    }
    
    public void setHref(String href) {
        this.href = href;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    
    public void setDate(String fecha){
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
         Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public void setAceirtos(int aceirtos) {
        this.aceirtos = aceirtos;
    }

    public void setData(HtmlData data) {
        this.data = data;
    }

    public void setIdCaptcha(String idCaptcha) {
        this.idCaptcha = idCaptcha;
    }

    public void setNameCaptcha(String nameCapthca) {
        this.nameCaptcha = nameCapthca;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
    
    public String getPrintCode(){
        StringBuffer string = new StringBuffer();
        string.append("Resources/"+this.getIdCaptcha()+".sqgcic");
        return string.toString();
    }
    
    public String getHref() {
        return href;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getFallos() {
        return fallos;
    }

    public int getAceirtos() {
        return aceirtos;
    }

    public HtmlData getData() {
        return data;
    }

    public String getIdCaptcha() {
        return idCaptcha;
    }

    public String getNameCaptcha() {
        return nameCaptcha;
    }

    public String getCode() {
        return code;
    }
    
    
    
}
