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
    <body style="text-align: center">


        <br><br>



        <table style="width:75%; border: 0px solid transparent; border-collapse: collapse" align="center">

            <tr>
                <th style="border: 0px solid transparent; border-collapse: collapse"><font size="4" face="Arial">Hétfő</font></th>
                <th  style="border: 0px solid transparent; border-collapse: collapse"><font size="4" face="Arial">Kedd</font></th>
                <th  style="border: 0px solid transparent; border-collapse: collapse"><font size="4" face="Arial">Szerda</font></th>
                <th  style="border: 0px solid transparent; border-collapse: collapse"><font size="4" face="Arial">Csütörtök</font></th>
                <th  style="border: 0px solid transparent; border-collapse: collapse"><font size="4" face="Arial">Péntek</font></th>
                <th  style="border: 0px solid transparent; border-collapse: collapse"><font size="4" face="Arial">Szombat</font></th>
                <th  style="border: 0px solid transparent; border-collapse: collapse"><font size="4" face="Arial">Vasárnap</font></th>    
            </tr>


            <c:forEach  begin="0"  end="${rows}" varStatus="i">

                <tr>
                    <c:forEach  begin="0"  end="6" varStatus="j">


                        <td style="text-align: right; border: 1px solid black; border-collapse: collapse; vertical-align: top; height: 90px">
                    <font style="color: red" size="1" face="Arial">${holidays[i.index*7+j.index]}&nbsp;&nbsp;&nbsp;</font><br>
                            <font style="color: black" size="1" face="Arial">${names[i.index*7+j.index]}</font>
                            <font size="4" face="Arial" style="color: ${colors[i.index*7+j.index]}">&nbsp;${daynumbers[i.index*7+j.index]}&nbsp;</font></td>


                    </c:forEach>

                </tr>


            </c:forEach>

        </table>

        <font id="yearmonth" size="4" face="Arial">${year}<b> |  ${month} </b></font>



        <br><br><br><br><br><br><br><br><br><br>

        <button id="prev" style="float: left; background-color: white; color: grey; cursor: pointer"><<</button>

        <button id="next" style="float: right; background-color: white; color: grey; cursor: pointer">>></button>

        <a id="start" style="color: grey;cursor: pointer">Kezdőoldalra&nbsp;&nbsp;</a>

        <a id="del" style="color: grey;cursor: pointer">Havi események törlése&nbsp;&nbsp;</a>

        <a id="print" style="color: grey;cursor: pointer">Oldal nyomtatása</a>




        <form action="create" method="POST" id="stepper">

            <input type="hidden" id="actyear" value="${year}" name="inputyear">
            <input type="hidden" id="actmonth" value="${month}" name="inputmonth">


        </form>

        <form action="delete" method="POST" id="delForm">

            <input type="hidden" value="${year}" name="inputyear">
            <input type="hidden" id="delmonth" value="" name="inputmonth">


        </form>

        <form action="print" method="POST" id="printForm" accept-charset="UTF-8" >

            <input type="hidden" name="html" id="str" value="">

        </form>   


        <script src="script/dispscript.js"></script>


    </body>
</html>
