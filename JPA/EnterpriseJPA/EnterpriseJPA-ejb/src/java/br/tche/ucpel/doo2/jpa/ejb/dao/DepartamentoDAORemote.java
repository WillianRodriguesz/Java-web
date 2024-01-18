package br.tche.ucpel.doo2.jpa.ejb.dao;

import br.ucpel.tche.doo2.jpa.bean.Departamento;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author mertins
 */
@Remote
public interface DepartamentoDAORemote {

    public Departamento create(Departamento dept);

    public Departamento retrieve(Departamento dept);

    public void update(Departamento dept);

    public void delete(Departamento dept);

    public List<Departamento> listaTodos();

    public boolean valida(Departamento dept);
}
