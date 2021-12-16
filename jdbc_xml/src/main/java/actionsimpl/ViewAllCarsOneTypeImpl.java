package actionsimpl;

import models.CarShop;
import models.Cars;
import java.util.List;

public interface ViewAllCarsOneTypeImpl {
    List<Cars> viewCarOfOneType(CarShop carShop, int categoryCode);

}
