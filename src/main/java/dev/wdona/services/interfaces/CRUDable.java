package dev.wdona.services.interfaces;

import dev.wdona.model.Libro;

public interface CRUDable {
    boolean agregarLibro(Libro libro);
    
    String consultarValorActual(String nombreAtributo);
    
    boolean actualizarLibro();
}