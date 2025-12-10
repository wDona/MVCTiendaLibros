package dev.wdona.model;

public class RowCSV {
    private String isbn;
    private String unidades;

    public RowCSV(String isbn, String unidades) {
        this.isbn = isbn;
        this.unidades = unidades;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "FilaCSV [isbn=" + isbn + ", unidades=" + unidades + "]";
    }
}
