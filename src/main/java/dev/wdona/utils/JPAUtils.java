package dev.wdona.utils;

import jakarta.persistence.*;

public class JPAUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienda");

    public static EntityManager create() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}
