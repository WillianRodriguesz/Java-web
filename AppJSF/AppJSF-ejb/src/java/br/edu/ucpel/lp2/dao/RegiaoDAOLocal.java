package br.edu.ucpel.lp2.dao;

import br.edu.ucpel.lp2.jpa.Regiao;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface Local para a DAO de Regiao.
 */
@Local
public interface RegiaoDAOLocal {

    Regiao create(Regiao value);

    Regiao retrieve(Regiao value);

    void update(Regiao value);

    void delete(Regiao value);

    List<Regiao> listaTodos();

    boolean valida(Regiao value);
}
