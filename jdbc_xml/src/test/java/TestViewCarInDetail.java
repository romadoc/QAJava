import buisneslayer.DetailViewer;
import buisneslayer.Dispatcher;
import models.CarShop;
import models.Cars;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestViewCarInDetail extends BaseTest {

    @Test
    public void viewCarsDetail() {

        DetailViewer detailViewer = new DetailViewer();
        detailViewer.viewAllCarsAllInfo(carShop, 3);
        List<Cars> cars = detailViewer.getCarsListInBase();

        assertTrue(cars.stream().anyMatch(car -> car.getCars_id() == 3));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_name().equals("Subaru")));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_model().equals("Forester")));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_description().equals("For real adventures")));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_category() == 5));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_manufacturer() == 3));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_price() == 35000));

    }

    @Test
    public void viewCarsByDetailXML() {

        Dispatcher dispatcher = new Dispatcher("xml");
        CarShop carShop = dispatcher.getCarShop();
        DetailViewer detailViewer = new DetailViewer();
        detailViewer.viewAllCarsAllInfo(carShop, 3);
        List<Cars> cars = detailViewer.getCarsListInBase();
        System.out.println(cars);
        assertTrue(cars.stream().anyMatch(car -> car.getCars_id() == 3));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_name().equals("Subaru")));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_model().equals("Forester")));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_description().equals("For real adventures")));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_category() == 5));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_manufacturer() == 3));
        assertTrue(cars.stream().anyMatch(car -> car.getCars_price() == 35000));

    }
}
