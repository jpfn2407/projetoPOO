package models.client;

import models.employee.Employee;
import models.employee.Manager;
import models.location.Location;
import models.transport.*;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {
    private Integer id;
    private String name;
    private Manager manager;
    private ItemsList itemsList;
    private DepositsList depositsList;
    private DeliveriesList deliveriesList;

    public Client(int id, String name, Manager manager){
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.itemsList = new ItemsList();
        this.depositsList = new DepositsList();
        this.deliveriesList = new DeliveriesList();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Item> getItems() {
        return this.itemsList.getItems();
    }

    public int registerItem(int clientId, String itemName, String[] permissions){
        return this.itemsList.registerItem(clientId, itemName, permissions);
    }

    public List<Deposit> getDeposits(){
        return this.depositsList.getDeposits();
    }

    public List<Delivery> getDeliveries() {
        return this.deliveriesList.getDeliveries();
    }

    public boolean hasItem(int itemId) {
        return this.itemsList.hasItem(itemId);
    }

    public Item getItem(int itemId) {
        return this.itemsList.getItem(itemId);
    }

    public void addItemQuantityById(int itemId, int quantity) {
        this.itemsList.addItemQuantityById(itemId, quantity);
    }

    public Deposit registerDeposit(Client client, Location location, List<Employee> employeeList, List<Item> itemList) {
        return  this.depositsList.makeDeposit(client, location, employeeList, itemList);
    }
}
