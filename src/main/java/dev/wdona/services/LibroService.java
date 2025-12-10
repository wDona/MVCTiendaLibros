package dev.wdona.services;

import dev.wdona.model.Libro;
import dev.wdona.model.RowCSV;
import dev.wdona.utils.*;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class LibroService {
    static final CSVUtils csv = new CSVUtils();
    static final MongoUtils mongo = new MongoUtils();
    static final SQLUtils sql = new SQLUtils();
    static final XMLUtils xml = new XMLUtils();
    static final EntityManager em = JPAUtils.getEntityManager();
    
    public static boolean agregarLibro(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        return false;
    }
    
    public static Libro buscarLibro(String isbn) {
        
        return null;
    }
    
    public static List<Libro> buscarLibros() {
        return em.createQuery("SELECT l from Libro l", Libro.class).getResultList(); // Es JPQL, no SQL
    }
    
    public static boolean eliminarLibro(String isbn) {
        
        return false;
    }
    
    public static void actualizarLibro(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }
    
    public static ArrayList<RowCSV> getFilasCSV() {
        csv.leer();
        return CSVUtils.getFilas();
    } 
}
