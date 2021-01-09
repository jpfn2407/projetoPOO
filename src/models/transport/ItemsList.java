package models.transport;

import java.util.*;

public class ItemsList {

    private Map<Integer, Item> items;
    private Integer lastId;

    public ItemsList(){
        this.items = new HashMap<Integer, Item>();
        this.lastId = 0;
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public List<Item> getItems(){
        return new ArrayList<>(this.items.values());
    }

    public int registerItem(int clientId, String itemName, String[] permissions){
        this.lastId +=1;
        this.items.put(this.lastId, new Item(clientId, this.lastId, itemName, permissions));
        return this.lastId;
    }


}
