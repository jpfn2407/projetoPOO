package models.transport;

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

}
