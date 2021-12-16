import buisneslayer.CartVeiwer;
import buisneslayer.Dispatcher;
import models.CarShop;
import models.Cart;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestViewCart extends BaseTest {

    @Test
    public void viewCartContent() {

        CartVeiwer cartVeiwer = new CartVeiwer();
        cartVeiwer.viewCartContents(carShop);
        List<Cart> carCartList = cartVeiwer.getCarsListInCart();
        System.out.println(carCartList);
        assertNotNull(carCartList);

    }

    @Test
    public void viewCartContentXML() {

        Dispatcher dispatcher = new Dispatcher("xml");
        CarShop carShop = dispatcher.getCarShop();
        CartVeiwer cartVeiwer = new CartVeiwer();
        cartVeiwer.viewCartContents(carShop);
        assertNotNull(cartVeiwer.getCarsListInCart());

    }
}


