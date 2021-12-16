package models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CarShop {
    @XmlElementWrapper(name = "carsList")
    @XmlElement(name = "car")
    private List<Cars> carsList;
    @XmlElementWrapper(name = "warehouseList")
    @XmlElement(name = "items")
    private List<Warehouse> warehouseList;
    @XmlElementWrapper(name = "shopList")
    @XmlElement(name = "items")
    private List<Shop> shopList;
    @XmlElementWrapper(name = "cartList")
    @XmlElement(name = "items")
    private List <Cart> cartList;
    @XmlElementWrapper(name = "categoryList")
    @XmlElement(name = "category")
    private List<Category> categoryList;
    @XmlElementWrapper(name = "manufacturerList")
    @XmlElement(name = "manufacturer")
    private List<Manufacturer> manufacturerList;
    @XmlElementWrapper(name = "clientList")
    @XmlElement(name = "client")
    private List<Clients> clientsList;


    public CarShop() {

    }
    public CarShop(List<Cars> carsList, List<Warehouse> warehouseList,
                   List<Shop> shopList, List<Cart> cartList,
                   List<Category> categoryList, List<Manufacturer> manufacturerList, List<Clients> clientsList) {
        this.carsList = carsList;
        this.warehouseList = warehouseList;
        this.shopList = shopList;
        this.cartList = cartList;
        this.categoryList =categoryList;
        this.manufacturerList = manufacturerList;
        this.clientsList = clientsList;
    }

    @Override
    public String toString() {
        return "CarShop{" +
                "carsList=" + carsList +
                ", warehouseList=" + warehouseList +
                ", shopList=" + shopList +
                ", cartList=" + cartList +
                ", categoryList=" + categoryList +
                ", manufacturerList=" + manufacturerList +
                ", clientsList=" + clientsList +
                '}';
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }

    public void setManufacturerList(List<Manufacturer> manufacturerList) {
        this.manufacturerList = manufacturerList;
    }

    public List<Clients> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Clients> clientsList) {
        this.clientsList = clientsList;
    }

    public List<Cars> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Cars> carsList) {
        this.carsList = carsList;
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
