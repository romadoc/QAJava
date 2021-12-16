import buisneslayer.CartAdder;
import buisneslayer.CartDeleter;
import buisneslayer.Dispatcher;
import models.CarShop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRemoveFromCart extends BaseTest {
    Dispatcher dispatcher = new Dispatcher("sql");
    @Test
    public void testRemoveCarFromChart() {

        CartAdder cartAdder = new CartAdder();
        cartAdder.addCarToCart(carShop, 1, 12);
        CartDeleter cartDeleter = new CartDeleter();
        cartDeleter.deleteCar(carShop, 12);
        assertTrue(cartDeleter.isDelOk());

    }
    @Test
    public void testRemoveCarFromChartXML() {
        Dispatcher dispatcher = new Dispatcher("xml");
        CarShop carShop = dispatcher.getCarShop();
        CartAdder cartAdder = new CartAdder();
        cartAdder.addCarToCart(carShop, 1, 12);
        CartDeleter cartDeleter = new CartDeleter();
        cartDeleter.deleteCar(carShop, 12);
        assertTrue(cartDeleter.isDelOk());
    }
}
