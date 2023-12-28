package com.mycompany.redirecionadorweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author willian
 */
@WebServlet(name = "AppServlet", urlPatterns = {"/AppServlet"})
public class AppServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       String[] urls = {
            "https://www.google.com.br",
            "https://www.facebook.com.br",
            "https://www.youtube.com.br",
            "https://www.instagram.com.br"
        };
       
       
        Random random = new Random();
        int pos = random.nextInt(urls.length);
        
        response.sendRedirect(urls[pos]);
   }
}
