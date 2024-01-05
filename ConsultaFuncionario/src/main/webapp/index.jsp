<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consulta de Funcionários</title>
    <script src="Scripts/AjaxScript.js"></script>
</head>
<body>
    <h1>Consulta de Funcionários</h1>
    
    <label for="nome">Digite o nome do funcionário:</label>
    <input type="text" id="nome" onkeyup="buscarFuncionarios()">

    <div id="resultado"></div>
</body>
</html>
