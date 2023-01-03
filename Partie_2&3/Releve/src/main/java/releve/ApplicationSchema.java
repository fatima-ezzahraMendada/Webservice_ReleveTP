package releve;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.SchemaOutputResolver;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ApplicationSchema {
    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext=JAXBContext.newInstance(Releve.class);
        jaxbContext.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String s, String s1) throws IOException {
                File file=new File("Releve.xsd");
                StreamResult streamResult=new StreamResult(file);
                streamResult.setSystemId(file.getName());
                return streamResult;
            }
        });
    }
}
