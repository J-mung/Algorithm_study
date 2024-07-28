package Parsing;

import java.util.List;

public class Clients {
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clients=" + clients +
                '}';
    }
}
