package models.employee;

import models.client.Client;

import java.io.Serializable;

public class Manager extends Employee implements Serializable {
    private Client client;
    public Manager(Integer id, String name, String category, String permission){
        super(id, name, category, permission);
    }

    public void associateClient(Client client){
        this.client = client;
    }
}
