package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: Gideon Nimoh
 * Date: 3/29/21
 * Time: 8:34 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>();
        this.addExit("Q", 0);
    }

    public void addExit(String direction, int location){
        exits.put(direction, location);
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
}
