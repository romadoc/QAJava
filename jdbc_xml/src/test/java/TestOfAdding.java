import buisneslayer.CarAdder;
import buisneslayer.Dispatcher;
import models.CarShop;
import models.Cars;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestOfAdding extends BaseTest {

    @Test
    public void addCarToApplication() {

        boolean isCarAddedToModel;
        boolean isCarAddedToDataBase;
        CarAdder carAdder = new CarAdder();

        carAdder.addCar(carShop, "Maserati", "Quadroporte", "excellent car",
                1, 3, 250000);
        isCarAddedToModel = carShop.getCarsList().stream().anyMatch(cars -> cars.getCars_name().equals("Maserati"));
        List<Cars> list = carAdder.getCarsListInBase();
        isCarAddedToDataBase = list.stream().anyMatch(cars -> cars.getCars_name().equals("Maserati"));
        assertEquals(isCarAddedToModel, isCarAddedToDataBase);
    }

    @Test
    public void addCarToApplicationFromXML() {
        Dispatcher dispatcher = new Dispatcher("xml");
        CarShop carShop = dispatcher.getCarShop();
        CarAdder carAdder = new CarAdder();
        carAdder.addCar(carShop, "Ferrari", "enzo", "fine car",
                2, 5, 10000);
    }
}
