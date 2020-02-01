<%-- 
    Document   : display
    Created on : 2020.01.23., 11:17:28
    Author     : GicziD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${month}</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/calendar.css" />
    </head>
    <body>

        <br><br>
        <table style="width: 100%">

            <tr>
                <th><font size="6" face="Arial">Hétfő</font></th>
                <th><font size="6" face="Arial">Kedd</font></th>
                <th><font size="6" face="Arial">Szerda</font></th>
                <th><font size="6" face="Arial">Csütörtök</font></th>
                <th><font size="6" face="Arial">Péntek</font></th>
                <th><font size="6" face="Arial">Szombat</font></th>
                <th><font size="6" face="Arial">Vasárnap</font></th>    
            </tr>


            <c:forEach  begin="0"  end="${rows}" varStatus="i">


                <c:forEach  begin="0"  end="6" varStatus="j">


                    <td style="text-align: right">
                    <br><font style="color: red" size="2" face="Arial">${holidays[i.index*7+j.index]}&nbsp;&nbsp;&nbsp;</font><br>
                        <font style="color: black" size="2" face="Arial">${names[i.index*7+j.index]}</font>
                        <font size="6" face="Arial" style="color: ${colors[i.index*7+j.index]}">&nbsp;${daynumbers[i.index*7+j.index]}&nbsp;</font></td>


                </c:forEach>

            </tr>


        </c:forEach>

    </table>

        <font id="yearmonth" size="6" face="Arial">${year}<b> |  ${month} </b></font>
        
        <br><br><br><br>
        
        <button id="prev" style="float: left; background-color: white; color: grey; cursor: pointer"><<</button>
        
        <a href="http://localhost:8080/calendar/" style="color: grey">kezdőoldalra</a>
        
        <button id="next" style="float: right; background-color: white; color: grey; cursor: pointer">>></button>
        
        <form action="create" method="POST" id="stepper">
            <input type="hidden" id="actyear" value="${year}" name="inputyear">
            <input type="hidden" id="actmonth" value="${month}" name="inputmonth">
        </form>

        <script src="script/dispscript.js"></script>
        
</body>
</html>
