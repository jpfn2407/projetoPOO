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

    public String getPermissionExtended(){
        if(this.permission.equals("S")){
            return "Seguro";
        }
        else if(this.permission.equals("P")){
            return "Perigoso";
        }
        else{
            return "Normal";
        }
    }

    public List<Deposit> getDeposits() {
        return this.depositsList.getDeposits();
    }

    public List<Delivery> getDeliveries() {
        return this.deliveriesList.getDeliveries();
    }

    public void addDeposit(Deposit deposit) {
        this.depositsList.addDeposit(deposit);
    }

    public void addDelivery(Delivery delivery) {
        this.deliveriesList.addDelivery(delivery);
    }
}
