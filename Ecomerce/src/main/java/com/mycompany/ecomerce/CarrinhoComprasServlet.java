package com.mycompany.ecomerce;

import java.io.IOException;
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
        String produto = request.getParameter("produto");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
   
        session.setAttribute(produto, quantidade);
        response.sendRedirect("carrinho.jsp");
    }

    
    

}
