package com.mycompany.webappjdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
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

    @Resource(lookup = "jdbc/teste_aula")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String escolha = request.getParameter("tipoUsuario");

        if (escolha.equals("funcionario")) {
            Connection conexao = null;

            try {
                conexao = dataSource.getConnection();
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conexao);
                List<Funcionario> funcionarios = funcionarioDAO.listaTodos();

                request.setAttribute("funcionarios", funcionarios);
                request.setAttribute("escolha", escolha);

                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conexao != null) {
                    try {
                        conexao.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (escolha.equals("aluno")) {

            Connection conexao = null;

            try {
                conexao = dataSource.getConnection();
                AlunoDAO alunoDAO = new AlunoDAO(conexao);
                List<Aluno> alunos = alunoDAO.listaTodos();

                request.setAttribute("alunos", alunos);
                request.setAttribute("escolha", escolha);

                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException e) {
            } finally {
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
