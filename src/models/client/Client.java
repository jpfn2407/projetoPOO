package models.client;

import models.employee.Manager;
import models.transport.DeliveriesList;
import models.transport.DepositsList;
import models.transport.Item;
import models.transport.ItemsList;

import java.util.List;

public class Client {
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
        return itemsList.getItems();
    }
}
