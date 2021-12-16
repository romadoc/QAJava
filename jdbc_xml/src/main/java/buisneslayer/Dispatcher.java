package buisneslayer;

import connectors.DataGetable;
import connectors.sqlconnectors.CarShopSqlGenerator;
import connectors.xmlconnectors.XmlDataConnector;
import models.CarShop;

public class Dispatcher implements DataGetable {
    static String mode;
    public Dispatcher(String mode) {
        Dispatcher.mode = mode;
    }
    CarShop carShop;
    @Override
    public CarShop getCarShop() {

        if (mode.equals("sql")){
            CarShopSqlGenerator carShopSqlGenerator = new CarShopSqlGenerator();
            carShop = carShopSqlGenerator.getCarShop();
        }
        if (mode.equals("xml")) {
            XmlDataConnector xmlDataConnector = new XmlDataConnector();
            carShop = xmlDataConnector.deserializeXml();

        }
        return carShop;
    }
}
