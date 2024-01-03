<!DOCTYPE html>
<html>
    <head>
        <title>Minha Loja Online</title>
        <link rel="stylesheet" type="text/css" href="Styles/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    </head>
    <body>      
            <div class="container">
                <h1>Bem-vindo à Minha Loja Online</h1>

                <form method="post" action="CarrinhoComprasServlet">
                    Produto: <input type="text" name="produto"><br>
                    Quantidade: <input type="text" name="quantidade"><br>
                    <input type="submit" value="Adicionar ao Carrinho">
                </form>

                <a href="carrinho.jsp" class="btn-carrinho">Ver Carrinho</a>
            </div>

        </div>
    </body>
</html>
