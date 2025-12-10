package dev.wdona.utils;

import jakarta.persistence.*;

public class JPAUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienda");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }

    // Las crea en el SQLite si no existen
    public static void crearTablas() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }
}
