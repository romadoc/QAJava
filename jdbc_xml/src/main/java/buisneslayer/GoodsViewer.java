package buisneslayer;

import actionsimpl.ViewAllCarsImpl;
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


public class GoodsViewer implements ViewAllCarsImpl {
    String mode = Dispatcher.mode;
    private List<Cars> carsList = new ArrayList<>();
    public List<Cars> getCarsList() {
        return carsList;
    }

    @Override
    public List<Cars> viewAllCars(CarShop carShop) {
        if (mode.equals("sql")) {
            String sql = "SELECT  cars_name, cars_model, cars_description, cars_category, cars_price from cars;";
            SqlExecutor sqlExecutor = new SqlExecutor(sql);
            sqlExecutor.executeQuery();
            BaseDbConnector baseDbConnector = new BaseDbConnector();
            Connection connection = baseDbConnector.connection;
            QueryRunner queryRunner = baseDbConnector.queryRunner;
            try {
                ResultSetHandler<List<Cars>> carlist = new BeanListHandler<>(Cars.class);
                carsList = queryRunner.query(connection, sql, carlist);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (mode.equals("xml")) {
            XmlDataConnector xmlDataConnector = new XmlDataConnector();
            xmlDataConnector.deserializeXml();
            carsList = xmlDataConnector.deserializeXml().getCarsList();
        }

        for (Cars cars : carsList) {
            System.out.println(cars.getCars_name() + " " + cars.getCars_model() + "; " +
                    cars.getCars_description() + "; category code " + cars.getCars_category() + "; price " +
                    cars.getCars_price());
        }

        return carsList;
    }
}
