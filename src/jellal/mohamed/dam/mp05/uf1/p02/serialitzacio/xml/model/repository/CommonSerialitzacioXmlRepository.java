package jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.xml.model.repository;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommonSerialitzacioXmlRepository {

    private static CommonSerialitzacioXmlRepository instance = null;

    private CommonSerialitzacioXmlRepository() {
    }

    public static CommonSerialitzacioXmlRepository getInstance() {
        if (instance == null) {
            instance = new CommonSerialitzacioXmlRepository();
        }
        return instance;
    }

    public void serialitza(Object object, String nomFitxer) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nomFitxer)))) {
            encoder.writeObject(object);
        }
    }

    public Object deserialitza(String nomFitxer) throws IOException {
        Object object;
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(nomFitxer)))) {
            object = decoder.readObject();
        }
        return object;
    }
}
