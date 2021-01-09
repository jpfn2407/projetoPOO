package models.employee;

import models.client.Client;
import models.transport.*;

import java.io.Serializable;
import java.util.*;

public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String category;
    private String permission;
    private DepositsList depositsList;
    private DeliveriesList deliveriesList;

    public Employee(Integer id, String name, String category, String permission){
        this.id = id;
        this.name = name;
        this.category = category;
        this.permission = permission;
        this.depositsList = new DepositsList();
        this.deliveriesList = new DeliveriesList();
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getPermissions() {
        return this.permission;
    }

    public List<Deposit> getDeposits() {
        return this.depositsList.getDeposits();
    }

    public List<Delivery> getDeliveries() {
        return this.deliveriesList.getDeliveries();
    }

}
