<%-- 
    Document   : index
    Created on : Oct 27, 2010, 11:38:05 PM
    Author     : mertins
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Departamentos</title>
    </head>
    <body style="color: darkcyan">
        <table border="0" cellspacing="3" cellpadding="3">
            <c:forEach  var="dept" items="${listaDept}">
                <tr>
                    <td>${dept.codigo}</td>
                    <td>${dept.descricao}</td>
                </tr>
            </c:forEach>
        </table>
        <h1><a style="color: red" href="./index.jsp">Voltar</a></h1>
    </body>
</html>