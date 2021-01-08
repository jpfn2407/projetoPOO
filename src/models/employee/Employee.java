package models.employee;

import models.client.Client;
import models.transport.Delivery;
import models.transport.Deposit;
import java.util.*;

public class Employee {
    private Integer id;
    private String name;
    private String category;
    private String permission;

    public Employee(Integer id, String name, String category, String permission){
        this.id = id;
        this.name = name;
        this.category = category;
        this. permission = permission;
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

    //TODO adicionar lista de deposits ao construtor
    public List<Deposit> getDeposits() {
        return null;
    }

    //TODO adicionar lista de deliveries ao construtor
    public List<Delivery> getDeliveries() {
        return null;
    }

}
