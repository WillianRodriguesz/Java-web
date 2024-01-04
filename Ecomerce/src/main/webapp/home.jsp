<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.ecomerce.Produtos" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Minha Loja Online</title>
    <link rel="stylesheet" type="text/css" href="Styles/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>

<div class="container">
    <h1>Bem-vindo à Minha Loja Online</h1>

    <!-- Exibir cards de produtos -->
    <% List<Produtos> produtos = (List<Produtos>) request.getAttribute("produtos"); %>
    <div class="cards-container">
        <% for (Produtos produto : produtos) { %>
            <div class="card">
                <h2><%= produto.getNome() %></h2>
                <p>Valor: R$ <%= produto.getValor() %></p>
                <form method="post" action="CarrinhoComprasServlet">
                    <input type="hidden" name="produto" value="<%= produto.getNome() %>">
                    Quantidade: <input type="text" name="quantidade" value="1"><br>
                    <input type="hidden" name="acao" value="adicionarAoCarrinho">
                    <input type="submit" value="Adicionar ao Carrinho">
                </form>
            </div>
        <% } %>

        <!-- Formulário para o botão "Ver Carrinho" -->
        <form method="post" action="CarrinhoComprasServlet">
            <input type="hidden" name="acao" value="verCarrinho">
            <input type="submit" class="btn-carrinho" value="Ver Carrinho">
        </form>
    </div>
</div>

</body>
</html>