package com.mycompany.consultafuncionario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author willian
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/funcionarioservlet"})
public class FuncionarioServlet extends HttpServlet {

    @Resource(name = "jdbc/teste_aula")
    private DataSource dataSource;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String nomeFuncionario = request.getParameter("nome");

            List<String> resultados = consulta(nomeFuncionario);

            // Monta a resposta como uma lista de opções para um elemento <select>
            StringBuilder resposta = new StringBuilder("<ul>");

            for (String nome : resultados) {
                resposta.append("<li>").append(nome).append("</li>");
            }
            resposta.append("</ul>");

            response.setContentType("text/html");
            response.getWriter().write(resposta.toString());

        } catch (Exception e) {
            out.println("ERRO: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            out.close();
        }
    }

    private List<String> consulta(String nome) throws SQLException {
        List<String> resultados = new ArrayList<String>();

            String sql = "SELECT nome FROM funcionario WHERE nome LIKE ?";
            PreparedStatement statement = dataSource.getConnection().prepareStatement(sql);
            statement.setString(1, "%" + nome + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultados.add(resultSet.getString("nome"));
            }
            
            resultSet.close();
            statement.close();
        

        return resultados;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
