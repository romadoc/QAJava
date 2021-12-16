package models;

public class Cart {
    private int cart_id;
    private int cart_invoice;
    private int client_id;

    public Cart() {

    }

    public Cart(int cart_id, int cart_invoice, int client_id) {
        this.cart_id = cart_id;
        this.cart_invoice = cart_invoice;
        this.client_id = client_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getCart_invoice() {
        return cart_invoice;
    }

    public void setCart_invoice(int cart_invoice) {
        this.cart_invoice = cart_invoice;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", cart_invoice=" + cart_invoice +
                ", client_id=" + client_id +
                '}';
    }
}
