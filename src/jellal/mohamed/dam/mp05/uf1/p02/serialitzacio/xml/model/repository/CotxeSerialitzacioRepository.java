package jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.xml.model.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.xml.model.domain.Cotxe;

public class CotxeSerialitzacioRepository {

    private static CotxeSerialitzacioRepository instance = null;

    private CotxeSerialitzacioRepository() {
    }

    public static CotxeSerialitzacioRepository getInstance() {
        if (instance == null) {
            instance = new CotxeSerialitzacioRepository();
        }
        return instance;
    }

    public void serialitzaUnCotxe(Cotxe cotxe, String nomFitxer) throws IOException {
    	CommonSerialitzacioXmlRepository.getInstance().serialitza(cotxe, nomFitxer);
    }

    public Cotxe deserialitzaUnCotxe(String nomFitxer) throws IOException, ClassNotFoundException {
        Cotxe resultat = null;
        Object object = CommonSerialitzacioXmlRepository.getInstance().deserialitza(nomFitxer);
        if (object != null && object instanceof Cotxe) {
            resultat = (Cotxe) object;
        }
        return resultat;
    }

    public void serialitzaLlistaCotxes(List<Cotxe> cotxes, String nomFitxer) throws IOException {
        Cotxe[] arrayCotxes = null;
        if (cotxes != null && !cotxes.isEmpty()) {
            arrayCotxes = cotxes.toArray(new Cotxe[0]);
        }
        CommonSerialitzacioXmlRepository.getInstance().serialitza(arrayCotxes, nomFitxer);
    }

    public List<Cotxe> deserialitzaLlistaCotxes(String nomFitxer) throws IOException, ClassNotFoundException {
        List<Cotxe> resultat = null;
        Object object = CommonSerialitzacioXmlRepository.getInstance().deserialitza(nomFitxer);
        if (object != null && object.getClass().isArray()) {
            Cotxe[] arrayCotxes = (Cotxe[]) object;
            resultat = new ArrayList<>(Arrays.asList(arrayCotxes));
        }
        return resultat;
    }
}
