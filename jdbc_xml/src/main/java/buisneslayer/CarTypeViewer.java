package buisneslayer;
import actionsimpl.ViewAllCarsOneTypeImpl;
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
import java.util.stream.Collectors;

public class CarTypeViewer implements ViewAllCarsOneTypeImpl {
    String mode = Dispatcher.mode;
    private List<Cars> carsList = new ArrayList<>();
    public List<Cars> getCarsList() {
        return carsList;
    }

    @Override
    public List<Cars> viewCarOfOneType(CarShop carShop, int typeCode) {
        carsList = carShop.getCarsList().stream()
                .filter(cars -> cars.getCars_category() == typeCode)
                .collect(Collectors.toList());

        if (mode.equals("sql")) {
            String sql = "SELECT  cars_name, cars_model, cars_description, cars_category, cars_price from cars" +
                    " WHERE cars_category = "+typeCode+";";
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
            carsList = xmlDataConnector.deserializeXml().getCarsList().stream()
                    .filter(cars -> cars.getCars_category() == typeCode).collect(Collectors.toList());
            System.out.println("***********************");
            carsList.forEach(System.out::println);
        }

        for (Cars cars : carsList) {
            System.out.println(cars.getCars_name() + " " + cars.getCars_model() + "; " +
                    cars.getCars_description() + "; category code " + cars.getCars_category() + "; price " +
                    cars.getCars_price());
        }

        return carsList;
    }
}
