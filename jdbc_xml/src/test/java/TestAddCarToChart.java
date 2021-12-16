import buisneslayer.CartAdder;
import buisneslayer.Dispatcher;
import models.CarShop;
import models.Cart;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestAddCarToChart extends BaseTest {

    @Test
    public void addCarToCart() {

        boolean isCarAddedToCartModel;
        boolean isCarAddedToCartDataBase;
        CartAdder cartAdder = new CartAdder();
        cartAdder.addCarToCart(carShop, 1, 11);
        isCarAddedToCartModel = carShop.getCartList().stream().anyMatch(cart -> cart.getCart_invoice()==11);
        List<Cart>cartList = cartAdder.getCartInDBaseList();
        isCarAddedToCartDataBase = cartList.stream().anyMatch(cart -> cart.getCart_invoice()==11);
        assertEquals(isCarAddedToCartDataBase, isCarAddedToCartModel);
    }

    @Test
    public void addCarToCartXml() {
        boolean isCarAddedToCartModel;
        Dispatcher dispatcher = new Dispatcher("xml");
        CarShop carShop = dispatcher.getCarShop();
        CartAdder cartAdder = new CartAdder();
        cartAdder.addCarToCart(carShop, 1, 11);
        isCarAddedToCartModel = carShop.getCartList().stream().anyMatch(cart -> cart.getCart_invoice()==11);
        List<Cart>cartList = cartAdder.getCartInDBaseList();
        assertNotNull(cartList);
        assertTrue(isCarAddedToCartModel);
    }

}
