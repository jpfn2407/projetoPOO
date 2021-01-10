package models.transport;

import java.io.Serializable;
import java.util.*;
import models.client.Client;

public class Item implements Serializable {

    private Integer clientId;
    private Integer id;
    private String itemName;
    private Integer quantity;
    private String[] permissions;

    public Item(Integer clientId, Integer id,  String itemName, String[] permissions){
        this.clientId = clientId;
        this.id = id;
        this.itemName = itemName;
        this.quantity = 0;
        this.permissions = permissions;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return itemName;
    }

    public String getPermissions() {
        return this.permissions[0];
    }

    public String[] getPermissionsArray() {
        return permissions;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }
}
