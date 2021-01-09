package models.transport;


import models.client.Client;
import models.employee.Employee;
import models.location.Location;
import java.util.*;
import java.io.Serializable;

public class Deposit implements Serializable {

    private Integer id;
    private Client client;
    private Location location;
    private Map<Integer, Employee> employees;
    private Map<Integer, Item> items;

    public Deposit(Integer id, Client client, Location location, List<Employee> employees, List<Item> items){
        this.id = id;
        this.client = client;
        this.location = location;
        for(Employee employee : employees){
            this.employees.put(employee.getId(), employee);
        }
        for(Item item : items){
            this.items.put(item.getId(), item);
        }
    }

    public Integer getId() {
        return id;
    }

    public Integer getClientId(){
        return this.client.getId();
    }

    public String getClientName(){
        return this.client.getName();
    }

    public Client getClient() {
        return client;
    }

    public Location getLocationName() {
        return location;
    }

    public boolean hasItem(Integer itemId){
        return this.items.containsKey(itemId);
    }

    public Integer getItemQuantity(Integer itemId){
        return this.items.get(itemId).getQuantity();
    }
}
