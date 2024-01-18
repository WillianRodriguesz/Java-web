package com.mycompany.dao;

import com.mycompany.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * @author willian
 */

@Stateless
public class UsuarioDAO implements UsuarioService {
      
    @PersistenceContext (unitName = "my_persistence_unit") 
    private EntityManager entityManager;
    
    public Usuario retrieve(String login) {
        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.login = :login";
            return entityManager.createQuery(jpql, Usuario.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; 
        }
    }
}
