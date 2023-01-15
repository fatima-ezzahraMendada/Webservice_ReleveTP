import proxy.*;

public class ReleveClient {
    public static void main(String[] args) throws JAXBException_Exception {
        ReleveWs stub=new ReleveWebService().getReleveWsPort();
        Releve rel=stub.getReleve();
        System.out.println(rel.getRib());


    }
}
