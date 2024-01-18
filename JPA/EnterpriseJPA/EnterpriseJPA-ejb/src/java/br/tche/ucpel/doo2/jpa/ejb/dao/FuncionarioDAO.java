package br.tche.ucpel.doo2.jpa.ejb.dao;

import br.ucpel.tche.doo2.jpa.bean.Funcionario;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mertins
 */
@Stateless
public class FuncionarioDAO implements FuncionarioDAORemote {

    @PersistenceContext
    private EntityManager em;

    /**
     * Se o funcioanário for válido, este método irá fazer o INSERT no SGBD.
     * O Código será inserido pela Sequência e será colocado novamente no objeto Funcionário.
     * @param func Funcionario a ser inserido
     */
    @Override
    public Funcionario create(Funcionario func) {
        if (this.valida(func)) {
            em.persist(func);
            return func;
        } else {
            return null;
        }
    }

    /**
     * Retorna o funcionario do SGBD de acordo com o código do funcionario recebido.
     * @param func Funcionario a ser carregado do SGBD
     * @return Funcionario do SGBD
     */
    @Override
    public Funcionario retrieve(Funcionario func) {
        Funcionario funcRet = em.find(Funcionario.class, func.getCodigo());
        return funcRet;
    }

    /**
     * Atualiza o funcionario no SGBD.
     * @param func Funcionario a ser atualizado do SGBD
     */
    @Override
    public void update(Funcionario func) {
        if (this.valida(func)) {
            em.merge(func);
        }
    }

    /**
     * Remove o código do funcionario do SGBD.
     * @param func Funcionario a ser excluído. Necessita apenas do atributo COD
     */
    @Override
    public void delete(Funcionario func) throws SQLException {
        em.remove(func);
    }

    /**
     * Retorna uma Lista com todos os Funcionarios cadastrados no SGBD.
     * @return Lista com os funcionarios.
     */
    @Override
    public List<Funcionario> listaTodos() {
        return (List<Funcionario>) em.createNamedQuery("Funcionario.findAll").getResultList();
    }

    /**
     * Aplica os testes para as regras de negócio.
     * @param func Funcioanario a ser testado
     * @return true se o Funcionario atende as regras de negócio, ou false em caso contrário.
     */
    @Override
    public boolean valida(Funcionario func) {
        boolean ret = false;
        if (func != null) {
            ret = true;
        }
        return ret;
    }
}
