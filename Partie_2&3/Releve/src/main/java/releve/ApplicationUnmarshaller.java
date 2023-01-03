package releve;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class ApplicationUnmarshaller {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Releve.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Releve releve = (Releve) unmarshaller.unmarshal(new File("Releve.xml"));

        System.out.println(releve.getRIB());
        System.out.println(releve.getDateReleve());
        System.out.println(releve.getSolde());
        for (Operation opera : releve.getOp().getOperation()){
          System.out.println(opera.toString());
     }
    }
    }

