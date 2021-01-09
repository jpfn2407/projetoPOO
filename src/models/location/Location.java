package models.location;

import models.transport.ItemsList;

import java.io.Serializable;

public class Location implements Serializable {
    private Integer id;
    private String name;
    private ItemsList itemsList;

    public Location(int id, String name){
        this.id = id;
        this.name = name;
        this.itemsList = new ItemsList();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
