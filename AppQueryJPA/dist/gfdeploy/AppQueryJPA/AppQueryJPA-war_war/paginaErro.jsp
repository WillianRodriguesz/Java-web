<%-- 
    Document   : paginaerro
    Created on : Sep 2, 2010, 6:31:40 PM
    Author     : mertins
--%>

<%@page import="java.io.PrintStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Erroo</title>
    </head>
    <body style="background-color: red;color:black">
        <h1>Erro crítico</h1>
        <div style="background-color: darkseagreen"><%=exception%></div>
        <div style="font-size: 6pt;background-color: yellow">
            <%
                        if (exception != null) {
                            %>
                            <div style="background-color: yellow"><%=response.getStatus()%></div>
                            <%
                            exception.printStackTrace(new java.io.PrintWriter(out));
                            exception.printStackTrace();
                        }
            %>
        </div>
    </body>
    <h1><a style="color: white" href="./index.jsp">Voltar</a></h1>
</html>
