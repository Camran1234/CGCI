<%-- 
    Document   : ListadoCaptchas
    Created on : May 18, 2021, 12:57:11 AM
    Author     : camran1234
--%>

<%@page import="com.chtml.table.HolderCaptcha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chtml.table.Holder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    body {
        background-image: url("../Resources/fondo2.jpg");
    }
    navbar-brand {
        width:130px;
        height:130px;
    }
    .container{
        margin: 50px;
        border-style: solid;
        border-width: 2px;
        height: 400px;
        width: 100px;
        position: relative;
        background: rgb(246, 255, 246);
        opacity: 0.7;
        
    }
    #formsText{
        display: block;
        text-align: center;
        font-family: Verdana;
        font-size: 16px;
        font-weight: bolder;
        color: black;
        text-decoration: underline;
    }
    
    #TittleText{
        font-family: Verdana;
        font-size: 25px;
        font-weight: normal;
        color: black;
    }
    #componentA{align-content: center;}
    #nav1{  
        opacity: 0.8;     
    }
    #text{
        font-size: 25px
    }
    #textImage{
        font-size: 35px;
    }
    #viewNice{
        opacity: 0.8;
    }
    #textLi{
        display: block;
        text-align: center;
        font-family: Verdana;
        font-size: 12px;
        color: black;
    }
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
}
    
</style>

<html>
    <head>
        <meta http-equiv="Pragma" content="no-cache">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Captchas</title>
    </head>
    <body >
        <!-- Barra de busqueda -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id='nav1'>
        <a class="navbar-brand" href="../index.jsp" id='textImage'><img src ="data:image/jpeg;base64,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" 
                    height="100" width="100"   />GCIC Online</a>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="../index.jsp" id='text'>Editor</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../HUD/ListadoCaptchas.jsp" id='text'>Captchas Creados</a>
            </li>
            </ul>
        </nav>
        
        <div id='viewNice' class="card text-white bg-primary mb-3" style="max-width: 35rem;">
            <div class="card-header">Tus Captchas</div>
            <div class="card-body">
                <div class="list-group">
                <%
                    Holder holder = new Holder();
                    if(holder.isEmpty()){%>
                    <li class="list-group-item list-group-item-action list-group-item-warning">Sin Captchas</li>
                    <%}%>
              <%
                  ArrayList<HolderCaptcha> captchas = holder.captchas();
                  for(int index=0; index<captchas.size();index++){
                      HolderCaptcha auxiliar = captchas.get(index);
                  %>
                    <form method='POST' action='./Page.jsp'>
                        <h6>CAPTCHA <%=auxiliar.getNameCaptcha()%></h6>
                        <li id='textLi' class="list-group-item list-group-item-info" value="<%=auxiliar.getIdCaptcha()%>"><%="ID: "+auxiliar.getIdCaptcha()%></li>
                        <li id='textLi' class="list-group-item list-group-item-info" value="<%=auxiliar.getNameCaptcha()%>"><%="INTENTOS: "+auxiliar.getIntentos()%></li>
                        <li id='textLi' class="list-group-item list-group-item-info" value="<%=auxiliar.getNameCaptcha()%>"><%="ACIERTOS: "+auxiliar.getAceirtos()%><%="_____FALLOS: "+auxiliar.getFallos()%></li>
                        <li id='textLi' class="list-group-item list-group-item-info" value="<%=auxiliar.getNameCaptcha()%>"><%="ULTIMA VEZ USADO: "+auxiliar.getDate()%></li>
                        <input type="hidden" name="captchaId" value="<%=auxiliar.getIdCaptcha()%>" >
                        <input type="submit" value="Ver"><br><br>
                    </form>
                  <%
                    }
                      %>
                 </div>
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
