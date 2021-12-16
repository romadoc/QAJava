package connectors.sqlconnectors;

import models.*;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class CarShopSqlGenerator extends BaseDbConnector {
    CarShop carShop = new CarShop();
    public CarShop getCarShop() {

        try {
            final String sqlCars = "SELECT * FROM cars;";
            ResultSetHandler<List<Cars>> carlist = new BeanListHandler<>(Cars.class);
            List<Cars> carsList = queryRunner.query(connection, sqlCars, carlist);
            carShop.setCarsList(carsList);
            System.out.println(carShop.getCarsList());

            final String sqlCategory = "SELECT * FROM category;";
            ResultSetHandler<List<Category>> categoryList = new BeanListHandler<>(Category.class);
            List<Category> categories = queryRunner.query(connection, sqlCategory, categoryList);
            carShop.setCategoryList(categories);
            System.out.println(carShop.getCategoryList());

            final String sqlManufacturer = "SELECT * FROM manufacturer;";
            ResultSetHandler<List<Manufacturer>> manufacturerList = new BeanListHandler<>(Manufacturer.class);
            List<Manufacturer> manufacturers = queryRunner.query(connection, sqlManufacturer, manufacturerList);
            carShop.setManufacturerList(manufacturers);
            System.out.println(carShop.getManufacturerList());

            final String sqlWarehouse = "SELECT * FROM warehouse;";
            ResultSetHandler<List<Warehouse>> warehouseList = new BeanListHandler<>(Warehouse.class);
            List<Warehouse> warehouses = queryRunner.query(connection, sqlWarehouse, warehouseList);
            carShop.setWarehouseList(warehouses);
            System.out.println(carShop.getWarehouseList());

            final String sqlShop = "SELECT * FROM shop;";
            ResultSetHandler<List<Shop>> shopList = new BeanListHandler<>(Shop.class);
            List<Shop> shops = queryRunner.query(connection, sqlShop, shopList);
            carShop.setShopList(shops);
            System.out.println(carShop.getShopList());

            final String sqlClient = "SELECT * FROM clients;";
            ResultSetHandler<List<Clients>> clientsList = new BeanListHandler<>(Clients.class);
            List<Clients> clients = queryRunner.query(connection, sqlClient, clientsList);
            carShop.setClientsList(clients);
            System.out.println(carShop.getClientsList());

            final String sqlCarts = "SELECT * FROM cart;";
            ResultSetHandler<List<Cart>> cartList = new BeanListHandler<>(Cart.class);
            List<Cart> carts = queryRunner.query(connection, sqlCarts, cartList);
            carShop.setCartList(carts);
            System.out.println(carShop.getCartList());

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return carShop;
    }

}
