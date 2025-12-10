package dev.wdona.controller;

import dev.wdona.model.Libro;
import dev.wdona.model.RowCSV;
import dev.wdona.services.LibroService;
import dev.wdona.utils.JPAUtils;
import dev.wdona.view.MainView;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    static EntityManager em = JPAUtils.getEntityManager();
    static MainView view = new MainView();
    
    public static void run() {
        // Crear tablas en la base de datos en caso de que no existan
        JPAUtils.crearTablas();

        // Guardar todos los libros en una lista
        List<Libro> libros = LibroService.buscarLibros();

        // Guardar las filas CSV en una lista
        List<RowCSV> filas = LibroService.getFilasCSV();

        // Actualizar las cantidades en XML, Mongo y SQLite/ORM
        for (RowCSV fila : filas) {
            Libro libroAActualizar = LibroService.buscarLibro(fila.getIsbn());

            if (libroAActualizar == null) {
                continue;
            }

            libroAActualizar.setStock
                    (libroAActualizar.getStock() - Integer.parseInt(fila.getUnidades()));

            LibroService.actualizarLibro(libroAActualizar);
        }

        // Mostrar menu
        try {
            view.mostrarAccionesIniciales();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1 -> {
                    String isbn = view.pedirString("ISBN del nuevo libro: ");
                    
                    if (LibroService.buscarLibro(isbn) != null) { 
                        view.mostrarMsg("Ese isbn ya existe");
                        continue; 
                    }
                    
                    String titulo = view.pedirString("Titulo del nuevo libro: ");
                    String autor = view.pedirString("Autor del nuevo libro: ");
                    int precio = view.pedirInt("Precio del nuevo libro: ");
                    int stock = view.pedirInt("Stock del nuevo libro: ");
                    LibroService.agregarLibro(new Libro(isbn, titulo, autor, precio, stock));
                    
                    view.mostrarMsg("Libro agregado");
                }
                
                case 2 -> {
                    String isbn = view.pedirString("ISBN del libro: ");
                    Libro libro = LibroService.buscarLibro(isbn);
                    
                    if (libro == null) {
                        view.mostrarMsg("Ese libro no existe");
                    }
                    
                    
                    
                }
                case 3 -> {}
                case 0 -> {}
            }
        } while (opcion != 0);


        JPAUtils.close();
    }
}
