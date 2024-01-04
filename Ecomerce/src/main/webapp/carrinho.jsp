<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.ecomerce.Produtos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Seu Carrinho</title>
    <link rel="stylesheet" type="text/css" href="Styles/style.css">
</head>
<body>

<div class="container">
    <h1>Seu Carrinho</h1>

    <% 
    List<Produtos> carrinho = (List<Produtos>) request.getSession().getAttribute("carrinho");
    
    if (carrinho != null && !carrinho.isEmpty()) {
        for (Produtos produto : carrinho) { 
    %>
        <div class="item-carrinho">
            <h2><%= produto.getNome() %></h2>
            <p>Valor: R$ <%= produto.getValor() %></p>
        </div>
    <% 
        }
    } else { 
    %>
        <p>Seu carrinho está vazio.</p>
    <% } %>

    <!-- Adicione outros elementos HTML conforme necessário -->
    
    <a href="CarrinhoComprasServlet" class="btn-carrinho">Continuar Comprando</a>
</div>

</body>
</html>
