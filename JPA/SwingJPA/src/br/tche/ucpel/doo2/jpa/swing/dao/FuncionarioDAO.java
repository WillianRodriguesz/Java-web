package br.tche.ucpel.doo2.jpa.swing.dao;

import br.tche.ucpel.doo2.jpa.swing.factory.ConexaoFactory;
import br.ucpel.tche.doo2.jpa.bean.Funcionario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Pseudo DAO (Data Access Objetc) para realizar as operações de CRUD - expressão em língua 
 * IInglesa Create, Retrieve, Update e Delete.
 * * @author mertins
 */
public class FuncionarioDAO {

    private Connection conexao;

    /**
     * Construtor único, para garantir a existência de uma conexão com um SGBD
     * @param conexao Connection já aberta com um SGBD
     */
    public FuncionarioDAO() {
    }

    /**
     * Se o funcioanário for válido, este método irá fazer o INSERT no SGBD.
     * O Código será inserido pela Sequência e será colocado novamente no objeto Funcionário.
     * @param func Funcionario a ser inserido
     */
    public Funcionario create(Funcionario func) {
        if (this.valida(func)) {
            EntityManager em = ConexaoFactory.get();
            em.getTransaction().begin();
            em.persist(func);
            em.getTransaction().commit();
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
    public Funcionario retrieve(Funcionario func) {
        EntityManager em = ConexaoFactory.get();
        Funcionario funcRet = em.find(Funcionario.class, func.getCodigo());
        return funcRet;
    }

    /**
     * Atualiza o funcionario no SGBD.
     * @param func Funcionario a ser atualizado do SGBD
     */
    public void update(Funcionario func) {
        if (this.valida(func)) {
            EntityManager em = ConexaoFactory.get();
            em.getTransaction().begin();
            em.merge(func);
            em.getTransaction().commit();
        }
    }

    /**
     * Remove o código do funcionario do SGBD.
     * @param func Funcionario a ser excluído. Necessita apenas do atributo COD
     */
    public void delete(Funcionario func) throws SQLException {
        EntityManager em = ConexaoFactory.get();
        em.getTransaction().begin();
        em.remove(func);
        em.getTransaction().commit();
    }

    /**
     * Retorna uma Lista com todos os Funcionarios cadastrados no SGBD.
     * @return Lista com os funcionarios.
     */
    public List<Funcionario> listaTodos() {
        EntityManager em = ConexaoFactory.get();
        return (List<Funcionario>) em.createNamedQuery("Funcionario.findAll").getResultList();
    }

    /**
     * Aplica os testes para as regras de negócio. 
     * @param func Funcioanario a ser testado
     * @return true se o Funcionario atende as regras de negócio, ou false em caso contrário.
     */
    public boolean valida(Funcionario func) {
        boolean ret = false;
        if (func != null) {
            ret = true;
        }
        return ret;
    }
}
