package buisneslayer;

import actionsimpl.ViewCartContentsImpl;
import connectors.sqlconnectors.BaseDbConnector;
import connectors.sqlconnectors.SqlExecutor;
import connectors.xmlconnectors.XmlDataConnector;
import models.CarShop;
import models.Cart;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartVeiwer implements ViewCartContentsImpl {
    String mode = Dispatcher.mode;
    private List<Cart> carsListInCart = new ArrayList<>();

    public List<Cart> getCarsListInCart() {
        return carsListInCart;
    }

    @Override
    public void viewCartContents(CarShop carShop) {

        if (mode.equals("sql")) {
            String sql = "SELECT  * from cart;";
            SqlExecutor sqlExecutor = new SqlExecutor(sql);
            sqlExecutor.executeQuery();
            BaseDbConnector baseDbConnector = new BaseDbConnector();
            Connection connection = baseDbConnector.connection;
            QueryRunner queryRunner = baseDbConnector.queryRunner;
            try {
                ResultSetHandler<List<Cart>> carlist = new BeanListHandler<>(Cart.class);
                carsListInCart = queryRunner.query(connection, sql, carlist);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (mode.equals("xml")) {
            XmlDataConnector xmlDataConnector = new XmlDataConnector();
            carsListInCart = xmlDataConnector.deserializeXml().getCartList();
            carsListInCart.forEach(System.out::println);
        }
    }
}
