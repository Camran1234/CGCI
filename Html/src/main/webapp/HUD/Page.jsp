<%-- 
    Document   : Page
    Created on : May 16, 2021, 6:15:12 AM
    Author     : camran1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
    .row:after {
    content: "";
    display: table;
    clear: both;
    }
    .column {
    float: left;
    }
    
function ASC(a){
    	var word = a;
        var array = a.split('');
        var auxiliar;
        for(var i=0; i<array.length; i++){
        	for(var j=0; j<(array.length-1); j++){
            	if(array[j-1]>array[j]){
                	auxiliar = array[j-1];
                    array[j-1] = array[j];
                    array[j] = auxiliar;
                }
            }
        }
        var z="";
        for(var i=0; i<array.length; i++){
        	z += array[i];
        }
        
        return z;
}    

function DESC(a){
    	var word = a;
        var array = a.split('');
        var auxiliar;
        for(var i=0; i<array.length; i++){
        	for(var j=0; j<(array.length-1); j++){
            	if(array[j-1]<array[j]){
                	auxiliar = array[j-1];
                    array[j-1] = array[j];
                    array[j] = auxiliar;
                }
            }
        }
        var z="";
        for(var i=0; i<array.length; i++){
        	z += array[i];
        }
        
        return z;
}

function Reverse(a){
    var word = a;
        var array = word.split('');
        var z="";
        for(var index=array.length-1; index>=0; index--){
        	z += array[index];
        }
        return z;
}

function LETPAR_NUM(){
    var word = a.split('');
        var z="";
        for(var index=0; index<word.length; index++){
        	if((index+1)%2==0){
            	var auxiliar = a.charCodeAt(index);
                z += auxiliar;
            }else{
            	z+= word[index]
            }
        }
        return z;
}

function LETIMPAR_NUM(){
    var word = a.split('');
        var z="";
        for(var index=0; index<word.length; index++){
            if((index+1)%2==0){
            	z+= word[index];
            }else{
                var auxiliar = a.charCodeAt(index);
                z += auxiliar;
            }
        }
        return z;
}


</script>
