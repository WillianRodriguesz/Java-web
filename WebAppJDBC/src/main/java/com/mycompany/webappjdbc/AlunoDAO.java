/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webappjdbc;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private Connection conexao;

    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Aluno> listaTodos() throws SQLException {

        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        String sql = "select matricula, nome, email, telefone, idade, dtnascimento  from aluno order by nome";

        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Aluno func = new Aluno();
            func.setMatricula(rs.getInt("MATRICULA"));
            func.setNome(rs.getString("NOME"));
            func.setEmail(rs.getString("EMAIL"));
            func.setTelefone(rs.getString("TELEFONE"));
            func.setIdade(rs.getInt("IDADE"));
            func.setDtNascimento(rs.getDate("DTNASCIMENTO"));
            lista.add(func);
        }

        rs.close();
        st.close();
        return lista;
    }

}
