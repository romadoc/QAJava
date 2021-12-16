package actionsimpl;

import models.CarShop;

public interface AddCarToCartImpl {
    void addCarToCart(CarShop carShop, int clientId, int invoice);
}
