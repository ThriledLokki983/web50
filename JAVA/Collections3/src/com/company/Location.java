package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: Gideon Nimoh
 * Date: 3/30/21
 * Time: 2:43 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = exits;
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location){
//        exits.put(direction, location);
//    }

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
