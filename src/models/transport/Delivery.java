package models.transport;

import models.client.Client;
import models.employee.Driver;
import models.employee.Employee;
import models.employee.Loader;
import models.location.Location;
import java.util.*;
import java.io.Serializable;

public class Delivery implements Serializable {

    private Integer id;
    private Client client;
    private Location location;
    private Employee driver;
    private Map<Integer, Employee> employees;
    private Map<Integer, Item> items;

    public Delivery(Integer id, Client client, Location location, Driver driver, List<Employee> employees, List<Item> items){
        this.id = id;
        this.client = client;
        this.location = location;
        this.driver = driver;
        this.employees = new HashMap<Integer, Employee>();
        this.items = new HashMap<Integer, Item>();
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

    public String getLocationName() {
        return location.getName();
    }

    public boolean hasItem(Integer itemId){
        return this.items.containsKey(itemId);
    }

    public Integer getItemQuantity(Integer itemId){
        return this.items.get(itemId).getQuantity();
    }

    public String getDriverPermission() {
        return this.driver.getPermissions();
    }

    public String getDriverName(){
        return this.driver.getName();
    }

    public List<Employee> getLoaders() {
        return new ArrayList<>(this.employees.values());
    }

    public List<Item> getItems() {
        return new ArrayList<>(this.items.values());
    }
}
