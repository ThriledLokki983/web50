package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locationMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        locationMap.put(0, new Location(0, "You are sitting in front of a computer learning java"));
        locationMap.put(1, new Location(1, "You are standing at the end of a road before a small bridge"));
        locationMap.put(2, new Location(2, "You are at the top of a hill"));
        locationMap.put(3, new Location(3, "You are inside a building, a well house for a small person"));
        locationMap.put(4, new Location(4, "You are in a vally beside a stream"));
        locationMap.put(5, new Location(5, "You are in the forest"));
        locationMap.put(6, new Location(6, "You are sitting in the garden and relaxing with a fiction book"));

        int loc = 1;
        while (true){
            System.out.println(locationMap.get(loc).getDescription());
            if (loc == 0){
                break;
            }
            loc = scanner.nextInt();
            if (!locationMap.containsKey(loc)){
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
