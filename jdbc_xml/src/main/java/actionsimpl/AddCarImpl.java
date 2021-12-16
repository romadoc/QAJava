package actionsimpl;

import models.CarShop;

public interface AddCarImpl {
    void addCar(CarShop carShop, String cars_name, String cars_model, String cars_description, int cars_category,
                      int cars_manufacturer, double cars_price);

}


