<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
                background: rgb(18, 18, 20);
            }

            form {
                background-color: rgb(32, 32, 36);
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 300px;
                text-align: center;
            }

            h2 {
                color: white;
            }

            a {
                color: rgb(130, 52, 233);
                text-decoration: none;
                display: block;
                text-align: left;
                margin-bottom: 8px; /* Adicione espaço abaixo do link */
            }

            input {
                width: 100%;
                padding: 10px;
                margin: 8px 0;
                box-sizing: border-box;
            }

            button {
                background: rgb(130, 52, 233);
                color: white;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
                border: none;
                border-radius: 3px;
                font-weight: bold;
                margin-top: 20px;
            }

            .error {
                color: #ff0000;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>

        <form action="LoginServlet" method="post">
            <h2>Faça seu login na plataforma</h2>

            <c:if test="${not empty requestScope.error}">
                <p class="error">Login ou senha incorretos. Tente novamente.</p>
            </c:if>


            <input type="text" id="username" name="username" placeholder="Username" required>
            <input type="password" id="password" name="password" placeholder="Password" required>
            <a href="#">Esqueci minha senha</a>
            <button type="submit">LOGIN</button>
        </form>

    </body>
</html>
