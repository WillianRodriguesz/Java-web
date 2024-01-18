package br.tche.ucpel.doo2.jpa.swing.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mertins
 */
public class ConexaoFactory {

    private static EntityManager em;

    public static EntityManager get() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SwingJPAPU");
            em = emf.createEntityManager();
        }
        return em;
    }

    public static void close() {
        if (em != null) {
            em.close();
        }
        em = null;
    }
}
