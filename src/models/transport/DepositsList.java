package models.transport;

import models.client.Client;
import models.employee.Employee;
import models.location.Location;

import java.io.Serializable;
import java.util.*;

public class DepositsList implements Serializable {

    private Map<Integer, Deposit> deposits;
    private Integer lastId;

    public DepositsList(){
        this.deposits = new HashMap<Integer, Deposit>();
        this.lastId = 0;
    }

    public List<Deposit> getDeposits(){
        return new ArrayList<>(this.deposits.values());
    }

}
