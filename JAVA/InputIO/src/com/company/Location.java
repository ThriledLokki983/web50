package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: Gideon Nimoh
 * Date: 4/4/21
 * Time: 12:48 PM
 * To change this template use File | Settings | File and Code Templates.
 */



public final class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null){
            this.exits = new HashMap<>(exits);
        }else{
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }

}
