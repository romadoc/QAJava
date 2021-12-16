package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cars {
    private int cars_id;
    private String cars_name;
    private String cars_model;
    private String cars_description;
    private int cars_category;
    private int cars_manufacturer;
    private double cars_price;

    public Cars() {

    }

    public Cars(int cars_id, String cars_name, String cars_model, String cars_description, int cars_category,
                int cars_manufacturer, double cars_price) {
        this.cars_id = cars_id;
        this.cars_name = cars_name;
        this.cars_model = cars_model;
        this.cars_description = cars_description;
        this.cars_category = cars_category;
        this.cars_manufacturer = cars_manufacturer;
        this.cars_price = cars_price;
    }

    public int getCars_id() {
        return cars_id;
    }

    public void setCars_id(int cars_id) {
        this.cars_id = cars_id;
    }

    public String getCars_name() {
        return cars_name;
    }

    public void setCars_name(String cars_name) {
        this.cars_name = cars_name;
    }

    public String getCars_model() {
        return cars_model;
    }

    public void setCars_model(String cars_model) {
        this.cars_model = cars_model;
    }

    public String getCars_description() {
        return cars_description;
    }

    public void setCars_description(String cars_description) {
        this.cars_description = cars_description;
    }

    public int getCars_category() {
        return cars_category;
    }

    public void setCars_category(int cars_category) {
        this.cars_category = cars_category;
    }

    public int getCars_manufacturer() {
        return cars_manufacturer;
    }

    public void setCars_manufacturer(int cars_manufacturer) {
        this.cars_manufacturer = cars_manufacturer;
    }

    public double getCars_price() {
        return cars_price;
    }

    public void setCars_price(double cars_price) {
        this.cars_price = cars_price;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars_id=" + cars_id +
                ", cars_name='" + cars_name + '\'' +
                ", cars_model='" + cars_model + '\'' +
                ", cars_description='" + cars_description + '\'' +
                ", cars_category=" + cars_category +
                ", cars_manufacturer=" + cars_manufacturer +
                ", cars_price=" + cars_price +
                '}';
    }
}
