<%-- 
    Document   : CompilerMenu
    Created on : May 6, 2021, 1:43:16 AM
    Author     : camran1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    body {
        background-image: url("./Resources/backgroundCompiler.jpeg");
    }
    
    #output{
        height: 400px; 
	
	margin: 1rem;
	padding: 1rem;
        overflow:scroll;
        width: 800px;
        background: white;
        opacity: 0.7;
        margin-left: auto;
        margin-right: auto;
        display:block;
    }
    #first{
         
  display: flex;
  flex-direction: column;
  justify-content: right;
  text-align: center;
  
    }
    #second{
         
  display: flex;
  flex-direction: column;
  justify-content: right;
  text-align: right;
    }
    
    #compile{
        margin-left:auto;
        margin-right: auto;
        display:block;
    }
    
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <title>GCIC Online</title>
    </head>
    <body >
        
        <div>
        <h1>GCIC Online</h1>
        <form method="post" action="./Compilador">
            <textarea id="output" name="code" onclick="countLiner()" onkeyup="countLiner()"><%
                          String newCode = (String)request.getSession().getAttribute("newCode");
                          request.getSession().removeAttribute("newCode");
                          if(newCode!=null){
                              %><%=newCode%><%
                          }
                          %></textarea>
                          <script>
                              
                          </script>    
            <h3 id="first" >Line: Column: </h3>
            <input value="Compilar" type="submit" id="compile"\>
        </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-lpyLfhYuitXl2zRZ5Bn2fqnhNAKOAaM/0Kr9laMspuaMiZfGmfwRNFh8HlMy49eQ" crossorigin="anonymous"></script>
    </body>
    
    <script>
        document.getElementById('output').addEventListener('keydown', function(e) {
            if (e.key == 'Tab') {
              e.preventDefault();
              var start = this.selectionStart;
              var end = this.selectionEnd;

              // set textarea value to: text before caret + tab + text after caret
              this.value = this.value.substring(0, start) +
                "\t" + this.value.substring(end);

              // put caret at right position again
              this.selectionStart =
                this.selectionEnd = start + 1;
            }
        });
        
        function countLiner(){
            var textarea = document.getElementById("output")
           var textLines = textarea.value.substr(0, textarea.selectionStart).split("\n");
            var currentLineNumber = textLines.length;
        var currentColumnIndex = textLines[textLines.length-1].length;
            document.getElementById("first").innerHTML="Line: "+currentLineNumber+"\t Column: "+currentColumnIndex;
        }
    </script>
    
    
</html>
