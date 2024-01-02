<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Início</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #000;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #fff;
        }

        .container {
            text-align: center;
            padding: 20px;
            background-color: #111; /* um tom mais escuro de preto */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.1); /* sombra branca sutil */
        }

        h1 {
            color: #800080; /* roxo */
        }

        p {
            color: #fff; /* branco */
        }

        /* Adicione estilos para o botão de logout */
        #logoutBtn {
            background-color: #800080; /* Cor de fundo roxa */
            color: #fff; /* Cor do texto branco */
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bem-vindo à Página Inicial</h1>
        <p>Esta é a página inicial do seu aplicativo.</p>
        
        <!-- Adicione o botão de logout -->
        <form action="LoginServlet" method="post">
            <input type="hidden" name="action" value="logout">
            <button id="logoutBtn" type="submit">Logout</button>
        </form>
    </div>
</body>
</html>
