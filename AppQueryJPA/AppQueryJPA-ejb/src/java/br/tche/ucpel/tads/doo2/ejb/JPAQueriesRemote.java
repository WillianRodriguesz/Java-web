package br.tche.ucpel.tads.doo2.ejb;

import br.tche.ucpel.tads.doo2.persisty.Departamento;
import br.tche.ucpel.tads.doo2.persisty.Pessoa;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author mertins
 */
@Remote
public interface JPAQueriesRemote {
    void popula();
    List<Departamento> findDepartamentos();

    List<Pessoa> findPessoasPorNome(String partenome);

    Pessoa findPessoaCPF(String cpf);

    List<Pessoa> findPessoasPorNomeDepartamento(String nomeDept);

    int aumentoSalario(Integer porcentagem);
}
