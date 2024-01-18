package br.tche.ucpel.doo2.jpa.ejb.dao;

import br.ucpel.tche.doo2.jpa.bean.Funcionario;
import javax.ejb.Remote;

/**
 *
 * @author mertins
 */
@Remote
public interface FuncionarioDAORemote {

    public Funcionario create(Funcionario func);

    public Funcionario retrieve(Funcionario func);

    public void update(Funcionario func);

    public void delete(Funcionario func) throws java.sql.SQLException;

    public java.util.List<Funcionario> listaTodos();

    public boolean valida(Funcionario func);
}
