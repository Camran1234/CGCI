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
    public static String href="https://www.google.com";
    public static HtmlData data=null;
    public static int intentos = 0;
    public static int fallos =0;
    public static int aciertos=0;
    public static String actualId="";
    
    public Captcha(){
    }
    
    public Captcha(String id){
        this.actualId = id;
    }
    
    public String getActualId(){
        return actualId;
    }
    
    public void reset(){
        data = null;
        href = "https://www.google.com";
    }
    
    public void setnewLink(String link){
        this.href = link;
    }
    
    public void setData(HtmlData newData){
        this.data = newData;
    }
    
    public String writeCode(){
        StringBuffer string = new StringBuffer();
        string.append("<script>\n");
        string.append("function RandInt(){\n" +
"    const random = (min, max) => Math.floor(Math.random() * (max - min)) + min;\n" +
"    return random(0,10);\n" +
"}    \n" +
"    \n" +
"function RandChar(){\n" +
"    const random = (min, max) => Math.floor(Math.random() * (max - min)) + min;\n" +
"    	var z = \"\";\n" +
"        var mayus = random(0,2);\n" +
"        if(mayus == 0){\n" +
"        	mayus = random(97,123);\n" +
"        }else if(mayus == 1){\n" +
"        	mayus = random(65,91);\n" +
"        }\n" +
"        z = String.fromCharCode(mayus);\n" +
"        return z;\n" +
"}\n" +
"\n" +
"function ASC(a){\n" +
"    	var word = a;\n" +
"        var array = a.split('');\n" +
"        var auxiliar;\n" +
"        for(var i=0; i<array.length; i++){\n" +
"        	for(var j=0; j<(array.length-1); j++){\n" +
"            	if(array[j-1]>array[j]){\n" +
"                	auxiliar = array[j-1];\n" +
"                    array[j-1] = array[j];\n" +
"                    array[j] = auxiliar;\n" +
"                }\n" +
"            }\n" +
"        }\n" +
"        var z=\"\";\n" +
"        for(var i=0; i<array.length; i++){\n" +
"        	z += array[i];\n" +
"        }\n" +
"        \n" +
"        return z;\n" +
"}    \n" +
"\n" +
"function DESC(a){\n" +
"    	var word = a;\n" +
"        var array = a.split('');\n" +
"        var auxiliar;\n" +
"        for(var i=0; i<array.length; i++){\n" +
"        	for(var j=0; j<(array.length-1); j++){\n" +
"            	if(array[j-1]<array[j]){\n" +
"                	auxiliar = array[j-1];\n" +
"                    array[j-1] = array[j];\n" +
"                    array[j] = auxiliar;\n" +
"                }\n" +
"            }\n" +
"        }\n" +
"        var z=\"\";\n" +
"        for(var i=0; i<array.length; i++){\n" +
"        	z += array[i];\n" +
"        }\n" +
"        \n" +
"        return z;\n" +
"}\n" +
"\n" +
"function Reverse(a){\n" +
"    var word = a;\n" +
"        var array = word.split('');\n" +
"        var z=\"\";\n" +
"        for(var index=array.length-1; index>=0; index--){\n" +
"        	z += array[index];\n" +
"        }\n" +
"        return z;\n" +
"}\n" +
"\n" +
"function LETPAR_NUM(){\n" +
"    var word = a.split('');\n" +
"        var z=\"\";\n" +
"        for(var index=0; index<word.length; index++){\n" +
"        	if((index+1)%2==0){\n" +
"            	var auxiliar = a.charCodeAt(index);\n" +
"                z += auxiliar;\n" +
"            }else{\n" +
"            	z+= word[index]\n" +
"            }\n" +
"        }\n" +
"        return z;\n" +
"}\n" +
"\n" +
"function LETIMPAR_NUM(){\n" +
"    var word = a.split('');\n" +
"        var z=\"\";\n" +
"        for(var index=0; index<word.length; index++){\n" +
"            if((index+1)%2==0){\n" +
"            	z+= word[index];\n" +
"            }else{\n" +
"                var auxiliar = a.charCodeAt(index);\n" +
"                z += auxiliar;\n" +
"            }\n" +
"        }\n" +
"        return z;\n" +
"}");
        string.append("</script>\n");
        if(data!=null){
            string.append(data.writeCode());
        }else{
            string.append("");
        }
        return string.toString();
    }

    public String getHref() {
        return href;
    }

    public HtmlData getData() {
        return data;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getFallos() {
        return fallos;
    }

    public int getAciertos() {
        return aciertos;
    }
    
    
    
}
