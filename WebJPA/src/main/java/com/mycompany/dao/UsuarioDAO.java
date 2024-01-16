
package com.mycompany.dao;

import com.mycompany.entity.Usuario;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author willian
 */

@Stateless
public class UsuarioDAO {
    
    private final EntityManager entityManager = null;
    
    public Optional<Usuario> retrieve(String login) {
        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.login = :login";
            Usuario usuario = entityManager.createQuery(jpql, Usuario.class)
                                           .setParameter("login", login)
                                           .getSingleResult();
            return Optional.ofNullable(usuario);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    
}
