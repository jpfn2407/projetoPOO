package models.transport;

import models.client.Client;
import models.employee.Driver;
import models.employee.Employee;
import models.location.Location;

import java.io.Serializable;
import java.util.*;

public class DeliveriesList implements Serializable {

    private Map<Integer, Delivery> deliveries;
    private Integer lastId;

    public DeliveriesList(){
        this.deliveries = new HashMap<Integer, Delivery>();
        this.lastId = 0;
    }

    public List<Delivery> getDeliveries(){
        return new ArrayList<>(this.deliveries.values());
    }

    public Delivery makeDelivery(Client client, Location location, Driver driver, List<Employee> employeeList, List<Item> itemList) {
        this.lastId += 1;
        this.deliveries.put(this.lastId, new Delivery(this.lastId, client, location, driver, employeeList, itemList));
        return this.deliveries.get(this.lastId);
    }

    public void addDelivery(Delivery delivery) {
        this.deliveries.put(delivery.getId(), delivery);
    }

    public boolean hasDelivery(int deliveryId) {
        return this.deliveries.containsKey(deliveryId);
    }

    public Delivery getDelivery(int deliveryId) {
        return this.deliveries.get(deliveryId);
    }
}
