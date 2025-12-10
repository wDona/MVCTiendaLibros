package dev.wdona.view;

import dev.wdona.model.Libro;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);
    
    public int mostrarMenu() {
        System.out.println("""
                MENU
                1) Insertar libro
                2) Buscar por ISBN
                3) Borrar libro
                4) Editar libro
                
                0) Salir
                """);
        
        return scanner.nextInt();
    }
    
    public void mostrarAccionesIniciales() throws InterruptedException {
        System.out.println("Comprobando bases de datos...");
        Thread.sleep(2000);

        System.out.println("Comprobando CSV...");
        Thread.sleep(2000);

        System.out.println("Comprobando XML...");
        Thread.sleep(2000);

        System.out.println("Terminado");
    }
    
    public void mostrarLibros(List<Libro> libros) {
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }
    
    public String pedirString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    public int pedirInt(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    
    public void mostrarMsg(String mensaje) {
        System.out.println(mensaje);
    }
}
