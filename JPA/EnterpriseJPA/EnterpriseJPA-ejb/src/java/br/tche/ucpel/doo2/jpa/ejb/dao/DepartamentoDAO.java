package br.tche.ucpel.doo2.jpa.ejb.dao;

import br.ucpel.tche.doo2.jpa.bean.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mertins
 */
@Stateless
public class DepartamentoDAO implements DepartamentoDAORemote {

    @PersistenceContext
    private EntityManager em;

    /**
     * Se o departamento for válido, este método irá fazer o INSERT no SGBD.
     * O Código será inserido pela Sequência e será colocado novamente no objeto Departamento.
     * @param dept Departamento a ser inserido
     */
    @Override
    public Departamento create(Departamento dept) {
        if (this.valida(dept)) {
            em.persist(dept);
            return dept;
        } else {
            return null;
        }
    }

    /**
     * Retorna o departamento do SGBD de acordo com o código do departamento recebido.
     * @param dept Departamento a ser carregado do SGBD
     * @return Departamento do SGBD
     */
    @Override
    public Departamento retrieve(Departamento dept) {
        Departamento deptRet = em.find(Departamento.class, dept.getCodigo());
        return deptRet;
    }

    /**
     * Atualiza o departamento no SGBD.
     * @param dept Departamento a ser atualizado do SGBD
     */
    @Override
    public void update(Departamento dept) {
        if (this.valida(dept)) {
            em.merge(dept);
        }
    }

    /**
     * Remove o código do departamento do SGBD.
     * @param dept Departamento a ser excluído. Necessita apenas do atributo COD
     */
    @Override
    public void delete(Departamento dept) {
        em.remove(dept);
    }

    /**
     * Retorna uma Lista com todos os Departamentos cadastrados no SGBD.
     * @return Lista com os departamentos.
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco será devolvido nesta Exceção
     */
    @Override
    public List<Departamento> listaTodos() {
        return (List<Departamento>) em.createNamedQuery("Departamento.findAll").getResultList();
    }

    /**
     * Aplica os testes para as regras de negócio.
     * @param dept Departamento a ser testado
     * @return true se o Departamento atende as regras de negócio, ou false em caso contrário.
     */
    @Override
    public boolean valida(Departamento dept) {
        boolean ret = false;
        if (dept != null) {
            ret = true;
        }
        return ret;
    }
}
