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

    public Deposit(Integer id, Client client, Location location, List<Employee> employeesList, List<Item> itemList){
        this.id = id;
        this.client = client;
        this.location = location;
        this.employees = new HashMap<Integer, Employee>();
        this.items = new HashMap<Integer, Item>();
        for(Employee employee : employeesList){
            this.employees.put(employee.getId(), employee);
        }
        for(Item item : itemList){
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

    public String getLocationName() {
        return this.location.getName();
    }

    public boolean hasItem(Integer itemId){
        return this.items.containsKey(itemId);
    }

    public Integer getItemQuantity(Integer itemId){
        return this.items.get(itemId).getQuantity();
    }

}
