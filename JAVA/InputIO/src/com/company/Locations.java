package com.company;

import java.io.*;
import java.util.*;

/**
 * Name: Gideon Nimoh
 * Date: 4/4/21
 * Time: 12:50 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locationMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")){
            for (Location location : locationMap.values()){
                locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()){
                    dirFile.write(location.getLocationID() + ", " + direction + ", " + location.getExits().get(direction) + "\n");
                }
            }
        }
/*        FileWriter locFile = null;
        try{
            locFile = new FileWriter("locations.txt");
            for (Location location : locationMap.values()){
                locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
                //throw new IOException("Test exception while writing");
            }
        }finally {
            System.out.println("In finally block");
            if (locFile != null){
                System.out.println("Attempting to close Loc file");
                locFile.close();
            }
        }*/
    }
    static {
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported Loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locationMap.put(loc, new Location(loc, description, tempExit));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (scanner != null){
                scanner.close();
            }
        }
        /* Trying to read the Exits */
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String direction = scanner.next();
                scanner.skip(scanner.delimiter());
                String dest = scanner.nextLine();
                int destination = Integer.parseInt(dest);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locationMap.get(loc);
                location.addExit(direction, destination);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (scanner != null){
                scanner.close();
            }
        }
        /*Map<String, Integer> tempExit = new HashMap<>();
        locationMap.put(0, new Location(0, "You are sitting in front of a computer learning java",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locationMap.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locationMap.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locationMap.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locationMap.put(4, new Location(4, "You are in a vally beside a stream",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locationMap.put(5, new Location(5, "You are in the forest",tempExit));*/
    }

    @Override
    public int size() {
        return locationMap.size();
    }

    @Override
    public boolean isEmpty() {
        return locationMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locationMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locationMap.containsKey(value);
    }

    @Override
    public Location get(Object key) {
        return locationMap.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locationMap.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locationMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locationMap.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locationMap.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locationMap.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locationMap.entrySet();
    }

}
