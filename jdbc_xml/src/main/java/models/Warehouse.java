package models;

public class Warehouse {
    private int warehouse_id;
    private int warehouse_car;
    private int warehouse_invoice;

    public Warehouse() {

    }

    public Warehouse(int warehouse_id, int warehouse_car, int warehouse_invoice) {
        this.warehouse_id = warehouse_id;
        this.warehouse_car = warehouse_car;
        this.warehouse_invoice = warehouse_invoice;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getWarehouse_car() {
        return warehouse_car;
    }

    public void setWarehouse_car(int warehouse_car) {
        this.warehouse_car = warehouse_car;
    }

    public int getWarehouse_invoice() {
        return warehouse_invoice;
    }

    public void setWarehouse_invoice(int warehouse_invoice) {
        this.warehouse_invoice = warehouse_invoice;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouse_id=" + warehouse_id +
                ", warehouse_car=" + warehouse_car +
                ", warehouse_invoice=" + warehouse_invoice +
                '}';
    }
}
