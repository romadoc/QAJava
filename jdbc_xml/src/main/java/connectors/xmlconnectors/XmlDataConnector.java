package connectors.xmlconnectors;

import models.CarShop;
import parsers.XMLParser;

import java.io.File;

public class XmlDataConnector {
    final String userDir = System.getProperty("user.dir");
    final File sourceFile = new File(userDir + "/datasource/carShop.xml");
    final File schemaFile = new File(userDir + "/datasource/schema.xsd");
    public CarShop deserializeXml() {
        final CarShop parsedCarShop = (CarShop) XMLParser.deserialize(sourceFile, schemaFile, CarShop.class);
        System.out.println(parsedCarShop.getCarsList());
        return parsedCarShop;
    }
    public void serializeXml(CarShop carShop) {
        XMLParser.serialize(carShop, sourceFile);
    }

}
