package models;

import models.client.Client;
import models.employee.Manager;
import models.transport.ItemsList;

import java.util.*;

public class ClientsList {


    private Map<Integer, Client> clients;
    private Integer lastId;


    public ClientsList(){
        clients = new HashMap<Integer, Client>();
        this.lastId = 0;
    }

    public boolean hasClientName(String clientName) {
        Client[] clientArray = new Client[this.clients.size()];
        this.clients.values().toArray(clientArray);
        for(Client person: clientArray){
            if(person.getName().equals(clientName)){
                return true;
            }
        }
        return false;
    }

    public int registerClient(Manager employee, String clientName) {
        this.lastId += 1;

        this.clients.put(this.lastId, new Client(this.lastId, clientName, employee));

        return this.lastId;
    }

    public boolean hasId(int clientId) {
        return this.clients.containsKey(clientId);
    }

    public Client getClient(int clientId) {
        return this.clients.get(clientId);
    }
}
