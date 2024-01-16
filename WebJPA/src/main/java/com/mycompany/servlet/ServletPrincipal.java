
package com.mycompany.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author willian
 */
@WebServlet(name = "ServletPrincipal", urlPatterns = {"/ServletPrincipal"})
public class ServletPrincipal extends HttpServlet {

     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = null;
        Connection conn = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/teste_aula");
            conn = dataSource.getConnection();            String acao = req.getParameter("acao");
            if ("login".equals(acao)) {
                //LoginController lc=new LoginController(req, resp, conn);
                //lc.processo();
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
            ServletPrincipal.dispatcherErro(req, resp, ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }

    }

    

    public static void dispatcherErro(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
        req.setAttribute("mensagem", msg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("formerro.jsp");
        dispatcher.forward(req, resp);

    }

}
