package models;

import java.io.Serializable;
import java.util.*;

import models.client.Client;
import models.location.Location;

public class LocationsList implements Serializable {
    private Map<Integer, Location> locations;
    private Integer lastId;

    public LocationsList(){
        this.locations = new HashMap<Integer, Location>();
        this.lastId = 0;
    }

    public boolean hasLocation(String locationName){
        Location[] locationArray = new Location[this.locations.size()];
        this.locations.values().toArray(locationArray);
        for(Location location: locationArray){
            if(location.getName().equals(locationName)){
                return true;
            }
        }
        return false;
    }

    public boolean hasId(Integer locationId){
        return this.locations.containsKey(locationId);
    }

    public int registerLocation(String locationName){
        this.lastId += 1;
        this.locations.put(this.lastId, new Location(this.lastId, locationName));
        return this.lastId;
    }

    public Location getLocation(Integer locationId) {
        return this.locations.get(locationId);
    }
}
