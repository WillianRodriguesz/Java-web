/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.colorchooserservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author willian
 */
@WebServlet(name = "ChooserColorServlet", urlPatterns = {"/ChooserColorServlet"})
public class ChooserColorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String escolha = request.getParameter("time");
        
        if(escolha.equals("colorado")){
            response.sendRedirect("pageRed.jsp");
        }else{
            response.sendRedirect("pageBlue.jsp");
        }
        
        
    }
    
}
