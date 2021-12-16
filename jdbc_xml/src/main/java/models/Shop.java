package models;

public class Shop {
    private int shop_id;
    private int shop_car;
    private int shop_invoice;

    public Shop() {

    }

    public Shop(int shop_id, int shop_car, int shop_invoice) {
        this.shop_id = shop_id;
        this.shop_car = shop_car;
        this.shop_invoice = shop_invoice;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getShop_car() {
        return shop_car;
    }

    public void setShop_car(int shop_car) {
        this.shop_car = shop_car;
    }

    public int getShop_invoice() {
        return shop_invoice;
    }

    public void setShop_invoice(int shop_invoice) {
        this.shop_invoice = shop_invoice;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", shop_car=" + shop_car +
                ", shop_invoice=" + shop_invoice +
                '}';
    }
}
