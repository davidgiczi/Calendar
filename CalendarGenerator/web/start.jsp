<%-- 
    Document   : start
    Created on : 2020.01.29., 8:05:15
    Author     : GicziD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calendar Generator</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/calendar.css" />
    </head>
    <body style="background-color: #dfe5c9">

        <font style="color: grey" size="20">Kalendárium</font><br><hr>

        <br><br>

        <form action="create" method="POST" accept-charset="UTF-8" id="inputdata">
            
            <p id="yearinf" style="color: red"></p>
            <h2 style="color: grey">Évszám megadása:</h2>
            <input type="number" id="inyear" name="inputyear" min="1582" value="${thisyear}">
            <h2 style="color: grey">Hónap választása:</h2>   
            <select name="inputmonth">
                
                <c:forEach items="${monthsname}" begin="0" var="monthname" varStatus="i">
                    
                    <c:choose>
                        
                        <c:when test="${i.index == thismonth}">
                            
                            <option value="${i.index}" selected="selected">${monthname}</option>
                            
                        </c:when>
                            
                            
                        <c:otherwise>
                            
                            <option value="${i.index}">${monthname}</option>
                            
                        </c:otherwise>
                        
                        
                    </c:choose>
                    
                </c:forEach>
                
               
            </select>
            <div id="events"></div>
            
        </form>
        
        <h2 style="color: grey" id="txt">Havi események megadása:</h2>
        <button style="color: black" id="add">Mező hozzáadása</button><br><br><br>
        <button style="color: black" id="gen">Hónap generálása</button>
        
        <script src="script/startscript.js"></script>
    </body>
</html>
