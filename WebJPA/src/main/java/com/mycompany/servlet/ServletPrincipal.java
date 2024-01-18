package com.mycompany.servlet;

import com.mycompany.controller.LoginController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author willian
 */
@WebServlet(name = "ServletPrincipal", urlPatterns = {"/principal"})
public class ServletPrincipal extends HttpServlet {
  
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String acao = req.getParameter("acao");

            if (acao.equals("login")) {
                LoginController loginController = new LoginController(req, resp);
                loginController.processo(req, resp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            dispatcherErro(req, resp, ex.getMessage());
        }

    }

    public static void dispatcherErro(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
        req.setAttribute("mensagem", msg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("formerro.jsp");
        dispatcher.forward(req, resp);

    }

}
