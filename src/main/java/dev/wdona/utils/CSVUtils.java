package dev.wdona.utils;

import dev.wdona.model.RowCSV;
import dev.wdona.services.interfaces.Fileable;
import dev.wdona.services.interfaces.MyReadable;

import java.io.*;
import java.util.ArrayList;

public class CSVUtils implements MyReadable, Fileable {
    static File csvFile = new File("src/main/resources/salidapython.csv");
    static ArrayList<RowCSV> filas = new ArrayList<>();
    
    @Override
    public void leer() {
        if (!isArchivoExisting(csvFile)) {
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while (br.ready()) {
                String line = br.readLine();
                
                String[] valores = line.split(",");

                RowCSV fila = new RowCSV(valores[0], valores[1]);
                filas.add(fila);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<RowCSV> getFilas() {
        return filas;
    }

    public static void setFilas(ArrayList<RowCSV> filas) {
        CSVUtils.filas = filas;
    }
}
