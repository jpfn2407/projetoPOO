package models.employee;

import models.client.Client;

public class Manager extends Employee{
    private Client client;
    public Manager(Integer id, String name, String category, String permission){
        super(id, name, category, permission);
    }

    public void associateClient(Client client){
        this.client = client;
    }
}
