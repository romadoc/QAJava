package buisneslayer;

import actionsimpl.DeleteCarImpl;
import connectors.sqlconnectors.SqlExecutor;
import connectors.xmlconnectors.XmlDataConnector;
import models.CarShop;
import models.Cart;
import java.util.ArrayList;
import java.util.List;

public class CartDeleter implements DeleteCarImpl {
    private boolean isDelOk;
    public boolean isDelOk() {
        return isDelOk;
    }

    @Override
    public void deleteCar(CarShop carShop, int invoice) {
        String mode = Dispatcher.mode;
        List<Cart> cartList = new ArrayList<>();
        cartList = carShop.getCartList();
        if (!cartList.isEmpty()) {
            cartList.removeIf(cart -> cart.getCart_invoice() == invoice);
            carShop.setCartList(cartList);
            isDelOk = true;
        }

        if (mode.equals("sql")) {
            String sql = "DELETE FROM cart WHERE cart_invoice = " + invoice + ";";
            SqlExecutor sqlExecutor = new SqlExecutor(sql);
            sqlExecutor.executeQuery();
            isDelOk = true;

        }
        if (mode.equals("xml")) {
            XmlDataConnector xmlDataConnector = new XmlDataConnector();
            xmlDataConnector.serializeXml(carShop);
        }


    }
}
