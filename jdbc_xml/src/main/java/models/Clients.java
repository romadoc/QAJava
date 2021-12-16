package models;

public class Clients {
    private int client_id;
    private String client_name;

    public Clients() {

    }

    public Clients(int client_id, String client_name) {
        this.client_id = client_id;
        this.client_name = client_name;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "client_id=" + client_id +
                ", client_name='" + client_name + '\'' +
                '}';
    }
}
