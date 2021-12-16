import buisneslayer.CarTypeViewer;
import buisneslayer.Dispatcher;
import models.CarShop;
import models.Cars;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestViewCarByType extends BaseTest {

    @Test
     public void testViewCarsByCategory() {

         CarTypeViewer carTypeViewer = new CarTypeViewer();
         carTypeViewer.viewCarOfOneType(carShop, 1);
        List<Cars> cars = new ArrayList<>(carTypeViewer.getCarsList());
        assertNotNull(cars);
    }

    @Test
    public void testViewCarByCategoryXML() {
        Dispatcher dispatcher = new Dispatcher("xml");
        CarShop carShop = dispatcher.getCarShop();
        CarTypeViewer carTypeViewer = new CarTypeViewer();
        carTypeViewer.viewCarOfOneType(carShop, 1);

    }
}
