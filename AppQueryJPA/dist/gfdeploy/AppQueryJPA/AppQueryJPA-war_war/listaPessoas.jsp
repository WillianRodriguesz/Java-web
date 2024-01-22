<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Pessoas</title>
    </head>
    <body style="color: darkcyan">
        <form action="/AppQueryJPA-war/jpaquerycontrol" method="post">
            Pesquisar por Nome: <input type="text" name="nomePesquisa">
            <input type="submit" value="Pesquisar">
        </form>
        <br>
        <c:if test="${not empty lstPessoas}">
            <table border="0" cellspacing="3" cellpadding="3">
                <c:forEach var="pessoa" items="${lstPessoas}">
                    <tr>
                        <td>${pessoa.id}</td>
                        <td>${pessoa.nome}</td>
                        <td>${pessoa.dtNascimento}</td>
                        <td>${pessoa.ativo}</td>
                        <td>${pessoa.sexo}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        
        <c:if test="${empty lstPessoas and not empty requestScope['mensagem']}">
            <p>${requestScope['mensagem']}</p>
        </c:if>

        <h1><a style="color: red" href="/index.jsp">Voltar</a></h1>
    </body>
</html>