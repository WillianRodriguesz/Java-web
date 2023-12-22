/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ipdetectweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
@WebServlet(name = "DetectIPServlet", urlPatterns = {"/DetectIPServlet"}) public class DetectIPServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String serverIPAddress = request.getRemoteAddr();
        String clientIPAddress = request.getRemoteAddr();
        String connectionType = (serverIPAddress.equals(clientIPAddress)) ? "CASA" : "ESTRANGEIRO";

      
        Locale clientLocale = request.getLocale();
        String localeString = clientLocale.getLanguage();

      
        System.out.println("IP do Cliente: " + clientIPAddress);
        Date horarioF = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String horario= formato.format(horarioF);

       
        request.setAttribute("serverIPAddress", serverIPAddress);
        request.setAttribute("clientIPAddress", clientIPAddress);
        request.setAttribute("connectionType", connectionType);
        request.setAttribute("localeString", localeString);
        request.setAttribute("horario", horario);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

}
