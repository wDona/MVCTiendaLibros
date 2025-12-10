package dev.wdona.utils;

import dev.wdona.model.Libro;
import dev.wdona.services.interfaces.CRUDable;
import dev.wdona.services.interfaces.Fileable;
import dev.wdona.services.interfaces.MyReadable;
import dev.wdona.services.interfaces.Saveable;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLUtils implements Saveable, MyReadable, CRUDable, Fileable {
    static File xmlFile = new File("src/main/resources/Libros.xml");
    DocumentBuilder builder;
    Document doc;
    
    public XMLUtils() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFile);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

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
    public void leer() {
        
    }

    @Override
    public void save() {
        
    }
}
