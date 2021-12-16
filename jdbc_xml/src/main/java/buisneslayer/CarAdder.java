package buisneslayer;

import actionsimpl.AddCarImpl;
import connectors.sqlconnectors.BaseDbConnector;
import connectors.sqlconnectors.SqlExecutor;
import connectors.xmlconnectors.XmlDataConnector;
import models.CarShop;
import models.Cars;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarAdder implements AddCarImpl {
    private List<Cars> carsListInBase = new ArrayList<>();

    public List<Cars> getCarsListInBase() {

        return carsListInBase;

    }

    @Override
    public void addCar(CarShop carShop, String cars_name, String cars_model, String cars_description, int cars_category,
                       int cars_manufacturer, double cars_price) {
        String mode = Dispatcher.mode;
        Cars cars = new Cars();
        cars.setCars_name(cars_name);
        cars.setCars_model(cars_model);
        cars.setCars_description(cars_description);
        cars.setCars_category(cars_category);
        cars.setCars_manufacturer(cars_manufacturer);
        cars.setCars_price(cars_price);
        List<Cars> carsList = carShop.getCarsList();
        carsList.add(cars);
        carShop.setCarsList(carsList);


        if (mode.equals("sql")) {
            String sql = "INSERT INTO cars(cars_name, cars_model, cars_description, cars_category, cars_manufacturer," +
                    " cars_price) VALUES ('"+ cars_name + "','" + cars_model + "','" + cars_description + "'," + cars_category +
                    "," + cars_manufacturer + "," + cars_price + ");";
            SqlExecutor sqlExecutor = new SqlExecutor(sql);
            sqlExecutor.executeQuery();
            BaseDbConnector baseDbConnector = new BaseDbConnector();
            Connection connection = baseDbConnector.connection;
            QueryRunner queryRunner = baseDbConnector.queryRunner;

            try {
                ResultSetHandler<List<Cars>> carlist = new BeanListHandler<>(Cars.class);
                carsListInBase = queryRunner.query(connection, "SELECT * from cars", carlist);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (mode.equals("xml")) {
            XmlDataConnector xmlDataConnector = new XmlDataConnector();
            carShop.setCarsList(carsList);
            xmlDataConnector.serializeXml(carShop);
        }

    }

}
