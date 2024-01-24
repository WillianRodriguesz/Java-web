package br.edu.ucpel.lp2.dao;

import br.edu.ucpel.lp2.jpa.Regiao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RegiaoDAO implements RegiaoDAOLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Regiao create(Regiao value) {
        if (valida(value)) {
            em.persist(value);
            return value;
        } else {
            return null;
        }
    }
    
    @Override
    public Regiao retrieve(Regiao value) {
        return em.find(Regiao.class, value.getCodigo());
    }
   
    @Override
    public void update(Regiao value) {
        if (valida(value)) {
            em.merge(value);
        }
    }
    
    @Override
    public void delete(Regiao value) {
        value = retrieve(value);
        if (value != null) {
            em.remove(value);
        }
    }
   
    @Override
    public List<Regiao> listaTodos() {
        return em.createNamedQuery("Regiao.findAll", Regiao.class).getResultList();
    }

    @Override
    public boolean valida(Regiao value) {
        return (value != null);
    }
}
