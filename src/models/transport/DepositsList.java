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

    public Deposit makeDeposit(Client client, Location location, List<Employee> employeeList, List<Item> itemList) {
        this.lastId += 1;
        this.deposits.put(this.lastId, new Deposit(this.lastId, client, location, employeeList, itemList));
        return this.deposits.get(this.lastId);
    }

    public void addDeposit(Deposit deposit) {
        this.deposits.put(deposit.getId(), deposit);
    }
}
