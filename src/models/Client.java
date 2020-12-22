package models;
import java.util.*;

public class Client {
    private int id;
    private String name;

    public Client(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setName(int id){
        this.name = name;
    }

    public String getName(int id){
        return this.name;
    }

    public int getId(String name){
        return this.id;
    }

    public Client getManager() {
    }

    public List<Deposit> getDeposits() {
    }
}
