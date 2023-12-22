<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        .calculator-container {
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        form {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
            margin: 0 auto; /* Centraliza o formulário */
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="calculator-container">
        <h1>Calculadora</h1>

        <form action="Welcome" method="post">
            <label for="elem1">Elemento 1:</label>
            <input type="text" name="elem1" id="elem1" required>
            <br>
            
            <label for="elem2">Elemento 2:</label>
            <input type="text" name="elem2" id="elem2" required>
            <br>

            <label for="oper">Operação:</label>
            <select name="oper" id="oper">
                <option value="soma">Soma</option>
                <option value="subtracao">Subtração</option>
            </select>
            <br>

            <button type="submit">Calcular</button>
        </form>
    </div>

</body>
</html>