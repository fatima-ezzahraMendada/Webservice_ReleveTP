package releve;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {
    public static void main(String[] args) throws ParseException, JAXBException {
     Operations op=new Operations(new Date(2022,01,12),new Date(2022,12,12));
     op.getOperation().add(new Operation(TypeOperation.Credit, new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2022"),9800,"Vers Espèce"));
     op.getOperation().add(new Operation(TypeOperation.Debit, new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2022"), 7000.01, "Chèque Guichet"));
     op.getOperation().add(new Operation(TypeOperation.Credit, new SimpleDateFormat("dd/MM/yyyy").parse("25/08/2022"), 8953, "Chèque Guichet"));
     Releve releve=new Releve("123456789",new SimpleDateFormat("dd/MM/yyyy").parse("26/12/2022"),3652,op);

     //Marshaller
        JAXBContext jaxbContext=JAXBContext.newInstance(Releve.class);
        Marshaller marshaller=jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(releve,new File("Releve.xml"));
    }

}
