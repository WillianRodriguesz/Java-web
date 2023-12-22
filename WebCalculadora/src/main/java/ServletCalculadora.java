/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/Welcome"})
public class ServletCalculadora extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performCalculation(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performCalculation(request, response);
    }

    private void performCalculation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String operation = request.getParameter("oper");
        int num1 = Integer.parseInt(request.getParameter("elem1"));
        int num2 = Integer.parseInt(request.getParameter("elem2"));
        int result = 0;

        if ("soma".equals(operation)) {
            result = num1 + num2;
        } else if ("subtracao".equals(operation)) {
            result = num1 - num2;
        }

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("Resultado da operação: " + result);
    }

}
