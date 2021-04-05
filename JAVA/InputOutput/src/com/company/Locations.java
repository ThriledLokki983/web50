package com.company;

import java.io.*;
import java.util.*;

/**
 * Name: Gideon Nimoh
 * Date: 4/4/21
 * Time: 10:04 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try(DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing Location: " + location.getLocationID() + ": " + location.getDescription() + "\n");
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits");
                locFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
/*        try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
            BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))){
            for (Location location : locations.values()){
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()){
                    if (!direction.equalsIgnoreCase("Q")){
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
}*//*FileWriter locFile = null;
        try{
            locFile = new FileWriter("locations.txt");
            for (Location location : locations.values()){
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
*//*
                throw new IOException("Test exception thrown while writing");
*//*
            }
        }finally {
            System.out.println("In Finally Block");
            if (locFile != null){
                System.out.println("Attempting to close file");
                locFile.close();
            }
        }
*/
    }

    static {
        try(DataInputStream locFIle = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
            while(true){
                Map<String, Integer> exits = new LinkedHashMap<>();
                int locID = locFIle.readInt();
                String description = locFIle.readUTF();
                int numExit = locFIle.readInt();
                System.out.println("Read Location: " + locID + ": " + description);
                System.out.println("Found " + numExit + ": exits.");
                for (int i = 0; i < numExit; i++){
                    String direction = locFIle.readUTF();
                    int destination = locFIle.readInt();
                    exits.put(direction, destination);
                    System.out.println("\t\t" + direction + ": " + destination);
                }
                locations.put(locID, new Location(locID, description, exits));
            }
        }catch (IOException e){
            System.out.println("IO Exception");
        }
/*        try(BufferedReader locFile = new BufferedReader(new FileReader("locations_big.txt"))){
            String input;
            System.out.println("Started Importing ");
            while ((input = locFile.readLine()) != null){
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String description = data[1];
                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        }catch(IOException e){
            e.printStackTrace();
}*/ /*
        try{ Scanner scanner = new Scanner(new FileReader("locations_big.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported Loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        }catch (IOException e){
            e.printStackTrace();
        }*/ /*        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))){
            String input;
            while ((input = dirFile.readLine()) != null){
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        }catch (IOException e){
            e.printStackTrace();
        }*/ /*
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));
*/
    }
    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

