<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirecionador de pagina</title>
        
        <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 50px;
        }
        
        h2 {
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            background-color: #4285f4;
            color: #fff;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border: none;
        }
    </style>
    
    </head>
    <body>
        <h2>Clique no botão para redirecionamento aleatorio</h1>
        <form action="AppServlet" method="get">
            <input type="submit" value="Redirecionar">
      
        </form>
    
    
    </body>
</html>
