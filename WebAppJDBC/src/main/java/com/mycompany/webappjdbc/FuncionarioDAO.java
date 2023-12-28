
package com.mycompany.webappjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private Connection conexao;

    public FuncionarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Funcionario> listaTodos() throws SQLException {

        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        String sql = "select cod, nome, cargo, dtcontratacao, codgerente, salario, coddepartamento from funcionario order by nome";

        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Funcionario func = new Funcionario();
            func.setCod(rs.getInt("cod"));
            func.setNome(rs.getString("nome"));
            func.setCargo(rs.getString("cargo"));
            func.setDtContratacao(rs.getDate("dtcontratacao"));
            func.setGerente(rs.getInt("codgerente"));
            func.setSalario(rs.getBigDecimal("salario"));
            func.setDepartamento(rs.getInt("coddepartamento"));
            
            lista.add(func);
        }

        rs.close();
        st.close();
        return lista;
    }

}
