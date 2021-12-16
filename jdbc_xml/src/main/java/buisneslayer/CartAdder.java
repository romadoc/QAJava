package buisneslayer;

import actionsimpl.AddCarToCartImpl;
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

public class CartAdder implements AddCarToCartImpl {
    private List<Cart> cartInDBaseList = new ArrayList<>();
    public List<Cart> getCartInDBaseList() {
        return cartInDBaseList;
    }

    @Override
    public void addCarToCart(CarShop carShop, int clientId, int invoice) {
        String mode = Dispatcher.mode;
        Cart cart = new Cart();
        cart.setClient_id(clientId);
        cart.setCart_invoice(invoice);
        List<Cart> cartList = carShop.getCartList();
        cartList.add(cart);
        carShop.setCartList(cartList);

        if (mode.equals("sql")) {
            String sql = "INSERT INTO cart(cart_client_id, cart_invoice) VALUES ("+ clientId +"," + invoice + ");";
            SqlExecutor sqlExecutor = new SqlExecutor(sql);
            sqlExecutor.executeQuery();
            BaseDbConnector baseDbConnector = new BaseDbConnector();
            Connection connection = baseDbConnector.connection;
            QueryRunner queryRunner = baseDbConnector.queryRunner;
            try {
                ResultSetHandler<List<Cart>> cartlist = new BeanListHandler<>(Cart.class);
                cartInDBaseList = queryRunner.query(connection, "SELECT * from cart", cartlist);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (mode.equals("xml")) {
            XmlDataConnector xmlDataConnector = new XmlDataConnector();
            carShop.setCartList(cartList);
            xmlDataConnector.serializeXml(carShop);

        }
    }
}
