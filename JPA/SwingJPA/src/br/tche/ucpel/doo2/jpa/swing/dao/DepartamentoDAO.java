package br.tche.ucpel.doo2.jpa.swing.dao;

import br.tche.ucpel.doo2.jpa.swing.factory.ConexaoFactory;
import br.ucpel.tche.doo2.jpa.bean.Departamento;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Pseudo DAO (Data Access Objetc) para realizar as operações de CRUD - expressão em língua Inglesa Create, Retrieve, Update e Delete.
 * 
 * @author mertins
 */
public class DepartamentoDAO {

    /**
     * Construtor único, para garantir a existência de uma conexão com um SGBD
     */
    public DepartamentoDAO() {
    }

    /**
     * Se o departamento for válido, este método irá fazer o INSERT no SGBD.
     * O Código será inserido pela Sequência e será colocado novamente no objeto Departamento.
     * @param dept Departamento a ser inserido
     */
    public Departamento create(Departamento dept) {
        if (this.valida(dept)) {
            EntityManager em = ConexaoFactory.get();
            em.getTransaction().begin();
            em.persist(dept);
            em.getTransaction().commit();
            return dept;
        }else{
            return null;
        }
    }

    /**
     * Retorna o departamento do SGBD de acordo com o código do departamento recebido.
     * @param dept Departamento a ser carregado do SGBD
     * @return Departamento do SGBD
     */
    public Departamento retrieve(Departamento dept) {
        EntityManager em = ConexaoFactory.get();
        Departamento deptRet = em.find(Departamento.class, dept.getCodigo());
        return deptRet;
    }

    /**
     * Atualiza o departamento no SGBD.
     * @param dept Departamento a ser atualizado do SGBD
     */
    public void update(Departamento dept) {
        if (this.valida(dept)) {
            EntityManager em = ConexaoFactory.get();
            em.getTransaction().begin();
            em.merge(dept);
            em.getTransaction().commit();
        }
    }

    /**
     * Remove o código do departamento do SGBD.
     * @param dept Departamento a ser excluído. Necessita apenas do atributo COD
     */
    public void delete(Departamento dept) {
        EntityManager em = ConexaoFactory.get();
        em.getTransaction().begin();
        em.remove(dept);
        em.getTransaction().commit();
    }

    /**
     * Retorna uma Lista com todos os Departamentos cadastrados no SGBD.
     * @return Lista com os departamentos.
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco será devolvido nesta Exceção
     */
    public List<Departamento> listaTodos() {
        EntityManager em = ConexaoFactory.get();
        return (List<Departamento>) em.createNamedQuery("Departamento.findAll").getResultList();
    }

    /**
     * Aplica os testes para as regras de negócio. 
     * @param dept Departamento a ser testado
     * @return true se o Departamento atende as regras de negócio, ou false em caso contrário.
     */
    public boolean valida(Departamento dept) {
        boolean ret = false;
        if (dept != null) {
            ret = true;
        }
        return ret;
    }
}
