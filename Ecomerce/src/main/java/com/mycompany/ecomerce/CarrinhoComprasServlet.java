package com.mycompany.ecomerce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author willian
 */
@WebServlet(name = "CarrinhoComprasServlet", urlPatterns = {"/CarrinhoComprasServlet"})
public class CarrinhoComprasServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        List<Produtos> carrinho = (List<Produtos>) session.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new ArrayList<Produtos>();
            session.setAttribute("carrinho", carrinho);
        }

        String acao = request.getParameter("acao");

        if ("adicionarAoCarrinho".equals(acao)) {
            String produtoNome = request.getParameter("produto");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));

            List<Produtos> produtosDisponiveis = criaProdutos();

            Produtos produtoSelect = null;
            for (Produtos produto : produtosDisponiveis) {
                if (produto.getNome().equals(produtoNome)) {
                    produtoSelect = produto;
                }
            }

            if (produtoSelect != null) {
                for (int i = 0; i < quantidade; i++) {
                    carrinho.add(produtoSelect);
                }
            }
            
             response.sendRedirect(request.getRequestURI());
            
        }else if("verCarrinho".equals(acao) ){
            response.sendRedirect("carrinho.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produtos> produtosDisponiveis = criaProdutos();
        request.setAttribute("produtos", produtosDisponiveis);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private List<Produtos> criaProdutos() {

        List<Produtos> produtos = new ArrayList<Produtos>();
        produtos.add(new Produtos("Produto1", 10.0));
        produtos.add(new Produtos("Produto2", 20.0));
        produtos.add(new Produtos("Produto3", 15.0));

        return produtos;

    }

}
