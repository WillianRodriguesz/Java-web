<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Seleção de Usuário</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
                flex-direction: column;
            }

            #formulario {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                margin-bottom: 20px;
                width: 50%;
                max-width: 400px;
            }

            #tabela {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 100%;
                overflow-x: auto;
                box-sizing: border-box;
            }

            label {
                display: block;
                margin-bottom: 8px;
            }

            select {
                width: 100%;
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
            }

            button {
                background-color: #4caf50;
                color: #fff;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            button:hover {
                background-color: #45a049;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
                font-family: Arial, sans-serif;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 12px;
                text-align: left;
            }

            th {
                background-color: #4caf50;
                color: white;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #ddd;
            }
        </style>
    </head>
    <body>

        <div id="formulario">
            <h2>Selecione o Tipo de Usuário</h2>

            <form action="AppServlet" method="get">
                <label for="tipoUsuario">Escolha:</label>
                <select id="tipoUsuario" name="tipoUsuario">
                    <option value="funcionario">Funcionário</option>
                    <option value="aluno">Aluno</option>
                </select>

                <button type="submit">Selecionar</button>
            </form>
        </div>

        <div id="tabela">
    <c:choose>
        <c:when test="${escolha eq 'aluno'}">
            <h2>Lista de Alunos</h2>
            <table>
                <thead>
                    <tr>
                        <th>Matrícula</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Idade</th>
                        <th>Data de Nascimento</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${alunos}">
                        <tr>
                            <td>${item.matricula}</td>
                            <td>${item.nome}</td>
                            <td>${item.email}</td>
                            <td>${item.telefone}</td>
                            <td>${item.idade}</td>
                            <td>${item.dtNascimento}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:when test="${escolha eq 'funcionario'}">
            <h2>Lista de Funcionários</h2>
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Cargo</th>
                        <th>Data de Contratação</th>
                        <th>Código do Gerente</th>
                        <th>Salário</th>
                        <th>Código do Departamento</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${funcionarios}">
                        <tr>
                            <td>${item.cod}</td>
                            <td>${item.nome}</td>
                            <td>${item.cargo}</td>
                            <td>${item.dtContratacao}</td>
                            <td>${item.gerente}</td>
                            <td>${item.salario}</td>
                            <td>${item.departamento}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
    </c:choose>
</div>


    </body>
</html>
