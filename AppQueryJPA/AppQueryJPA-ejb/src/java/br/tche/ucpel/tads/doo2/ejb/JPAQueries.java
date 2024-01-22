package br.tche.ucpel.tads.doo2.ejb;

import br.tche.ucpel.tads.doo2.persisty.Departamento;
import br.tche.ucpel.tads.doo2.persisty.Funcionario;
import br.tche.ucpel.tads.doo2.persisty.Pessoa;
import br.tche.ucpel.tads.doo2.persisty.Disciplina;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author mertins
 */
@Stateless
public class JPAQueries implements JPAQueriesRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void popula() {
        try {
            Departamento dept = new Departamento();
            dept.setDescricao("Desenvolvimento");
            em.persist(dept);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Funcionario func = new Funcionario();
            func.setDepartamento(dept);
            func.setDtContratacao(new Date());
                
            func.setSalario(1200.0);
            
            func.setDtNascimento(sdf.parse("23/02/1999"));
            func.setNome("Willian");
            func.setCpf("122342");
            em.persist(func);
            
            func = new Funcionario();
            func.setDepartamento(dept);
            func.setDtContratacao(new Date());
            func.setDtNascimento(sdf.parse("23/09/1982"));
            func.setNome("Marcos");
            func.setSalario(3000.0);
            func.setCpf("45421345");
            em.persist(func);
        } catch (ParseException ex) {
            Logger.getLogger(JPAQueries.class.getName()).log(Level.SEVERE, "Provavelmente Data Inválida", ex);
        }
    
        //addDisciplina(280, "Programação Orientada a Objetos");
        //addDisciplina(140, "Estrutura de Dados");
    }
    
    public void addDisciplina(int cargaHoraria, String descricao){
        try {
            Disciplina disc = new Disciplina();
            disc.setCargaHoraria(cargaHoraria);
            disc.setDescricao(descricao);
            em.persist(disc);
            
        } catch (Exception e) {
        }
            
    }
    
    public void addAluno(){
        
    }

    @Override
    public List<Departamento> findDepartamentos() {
        Query query = em.createNamedQuery("departamento.findAll");
        return query.getResultList();
    }

    @Override
    public List<Pessoa> findPessoasPorNome(String partenome) {
        Query query = em.createNamedQuery("pessoa.findPartNome");
        query.setParameter("partNome", partenome.toUpperCase());
        query.setMaxResults(20);
        return query.getResultList();
    }

    @Override
    public Pessoa findPessoaCPF(String cpf) {
        Query query = em.createQuery("select o from Pessoa o where o.cpf=:cpfParam");
        query.setParameter("cpfParam", cpf);
        Pessoa pessoa = null;
        try {
            pessoa = (Pessoa) query.getSingleResult();
        } catch (NoResultException ex) {
        }
        return pessoa;
    }

    @Override
    public List<Pessoa> findPessoasPorNomeDepartamento(String nomeDept) {
        Query query = em.createQuery("select o from Funcionario o join o.departamento d where d.descricao=:nomeDept");
        query.setParameter("nomeDept", nomeDept);
        return query.getResultList();
    }

    @Override
    public int aumentoSalario(Integer porcentagem) {
        Query query = em.createQuery("update Funcionario o set o.salario =  o.salario * :porcent/100 + o.salario");
        query.setParameter("porcent", porcentagem);
        return query.executeUpdate();
    }
}
