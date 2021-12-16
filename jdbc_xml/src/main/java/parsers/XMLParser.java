package parsers;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XMLParser {

    public static Object deserialize(File sourceFile, File schemaFile, Class clazz){
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaFile);
            unmarshaller.setSchema(schema);
            return unmarshaller.unmarshal(sourceFile);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void serialize(Object obj, File destFile){
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, destFile);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
