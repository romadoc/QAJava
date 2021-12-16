package buisneslayer;

import actionsimpl.ViewCarDetailInfoImpl;
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
import java.util.List;
import java.util.stream.Collectors;

public class DetailViewer implements ViewCarDetailInfoImpl {
    String mode = Dispatcher.mode;
    private List<Cars> carsListInBase;
    private List<Cars> modelCarsList;

    public List<Cars> getCarsListInBase() {
        return carsListInBase;
    }

    public List<Cars> getModelCarsList() {
        return modelCarsList;
    }

    @Override
    public void viewAllCarsAllInfo(CarShop carShop, int id) {

        if (mode.equals("sql")) {
            String sql = "SELECT  cars_id, cars_name, cars_model, cars_description, cars_category, cars_manufacturer," +
                    " cars_price from cars WHERE cars_id = " + id + ";";
            SqlExecutor sqlExecutor = new SqlExecutor(sql);
            sqlExecutor.executeQuery();
            BaseDbConnector baseDbConnector = new BaseDbConnector();
            Connection connection = baseDbConnector.connection;
            QueryRunner queryRunner = baseDbConnector.queryRunner;
            try {
                ResultSetHandler<List<Cars>> list = new BeanListHandler<>(Cars.class);
                carsListInBase = queryRunner.query(connection, sql, list);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (mode.equals("xml")) {
            XmlDataConnector xmlDataConnector = new XmlDataConnector();
            xmlDataConnector.deserializeXml();
            carsListInBase = xmlDataConnector.deserializeXml().getCarsList().stream()
                    .filter(cars -> cars.getCars_id() == id).collect(Collectors.toList());

        }
    }
}
