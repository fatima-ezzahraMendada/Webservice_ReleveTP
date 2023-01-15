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

        System.out.println("RIB: "+ releve.getRIB());
        System.out.println("Date de releve: "+releve.getDateReleve());
        System.out.println("Solde: "+releve.getSolde());
        System.out.println("Date debut operation: "+releve.getOp().getDateDebut());
        System.out.println("Date fin operation: "+releve.getOp().getDateFin());
        for (Operation opera : releve.getOp().getOperation()){
            System.out.println("-----------------------------");
            System.out.println("Type: "+opera.getType());
            System.out.println("Date: "+opera.getDate());
            System.out.println("Montant: "+opera.getMontant());
            System.out.println("Description: "+opera.getDescription());
        }

    }
    }

