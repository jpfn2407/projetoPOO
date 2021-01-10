package models.transport;

import java.io.Serializable;
import java.util.*;

public class ItemsList implements Serializable {

    private Map<Integer, Item> items;
    private Integer lastId;

    public ItemsList(){
        this.items = new HashMap<Integer, Item>();
        this.lastId = 0;
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public Item getItem(int itemId) {
        return this.items.get(itemId);
    }

    public List<Item> getItems(){
        return new ArrayList<>(this.items.values());
    }

    public int registerItem(int clientId, String itemName, String[] permissions){
        this.lastId +=1;
        this.items.put(this.lastId, new Item(clientId, this.lastId, itemName, permissions));
        return this.lastId;
    }

    public boolean hasItem(int itemId) {
        return this.items.containsKey(itemId);
    }

    public void addItemQuantityById(int itemId, int quantity){
        this.items.get(itemId).addQuantity(quantity);
    }

    public void removeItemQuantityById(int itemId, int quantity){
        this.items.get(itemId).removeQuantity(quantity);
    }
}
