/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.webappjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author willian
 */
@WebServlet(name = "AppServlet", urlPatterns = {"/AppServlet"})

public class AppServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Resource(lookup = "jdbc/_teste_aula")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String escolha = request.getParameter("tipoUsuario");

        if (escolha != null) {
            if (escolha.equals("funcionario")) {

                // Implemente lógica para funcionários, se necessário
            } else if (escolha.equals("aluno")) {

                Connection conexao = null;
                try {
                    conexao = dataSource.getConnection();
                    AlunoDAO alunoDAO = new AlunoDAO(conexao);
                    List<Aluno> alunos = alunoDAO.listaTodos();

                    // Define a lista de alunos como um atributo na solicitação
                    request.setAttribute("alunos", alunos);
                    request.setAttribute("escolha", escolha); // Adiciona a escolha para usar no JSP

                    // Encaminha a solicitação para a página JSP
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Certifique-se de fechar a conexão no bloco finally para evitar vazamentos
                    if (conexao != null) {
                        try {
                            conexao.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("Nenhum");
            }

        }

    }
}
