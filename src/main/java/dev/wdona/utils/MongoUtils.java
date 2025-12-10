package dev.wdona.utils;

import dev.wdona.model.Libro;
import dev.wdona.services.interfaces.CRUDable;
import dev.wdona.services.interfaces.DBable;

public class MongoUtils implements DBable, CRUDable {
    @Override
    public boolean agregarLibro(Libro libro) {
        return false;
    }

    @Override
    public String consultarValorActual(String nombreAtributo) {
        return "";
    }

    @Override
    public boolean actualizarLibro() {
        return false;
    }

    @Override
    public void abrirConnection() {

    }

    @Override
    public void cerrarConnection() {

    }
}
