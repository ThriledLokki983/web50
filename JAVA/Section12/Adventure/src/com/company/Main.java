package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locationMap = new HashMap<>();
    private static Map<String, String> vocabulary = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        locationMap.put(0, new Location(0, "You are sitting in front of a computer learning java"));
        locationMap.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locationMap.put(2, new Location(2, "You are at the top of a hill"));
        locationMap.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locationMap.put(4, new Location(4, "You are in a vally beside a stream"));
        locationMap.put(5, new Location(5, "You are in the forest"));

        locationMap.get(1).addExit("W", 2);
        locationMap.get(1).addExit("E", 3);
        locationMap.get(1).addExit("S", 4);
        locationMap.get(1).addExit("N", 5);

        locationMap.get(2).addExit("N", 5);

        locationMap.get(3).addExit("W", 1);

        locationMap.get(4).addExit("N", 1);
        locationMap.get(4).addExit("W", 2);

        locationMap.get(5).addExit("S", 1);
        locationMap.get(5).addExit("W", 2);

        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");



        int loc = 1;
        while(true) {
            System.out.println(locationMap.get(loc).getDescription());
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locationMap.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1){
                String[] words = direction.split(" ");
                for (String word : words){
                    if (vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("You cannot go in that direction");
            }

        }




        /**
         System.out.println("Enter something");
         String[] directions = scanner.nextLine().split(" ");
         for (String i : directions){
         if (i.equals("west")){
         System.out.println("Got you!!!");
         }else{
         System.out.println("Doesn't work like that");
         }

         }
         **/
/**
      int loc = 0;
      while(true){
          System.out.println(locationMap.get(loc).getDescription());
          if (loc == 0){
              break;
          }
          Map<String, Integer> exits = locationMap.get(loc).getExits();
          System.out.print("Available exits are ");
          for(String exit: exits.keySet()) {
              System.out.print(exit + ", ");
          }

          System.out.print("Enter Direction: ");
          String[] direction = scanner.nextLine().split(" ");

          for (String word : direction){
              if (word.equalsIgnoreCase("west")){
                  System.out.println(locationMap.get(2).getDescription());
                  loc = exits.get(2);
                  System.out.println("==========================================");
              }else if (word.equalsIgnoreCase("north")){
                  System.out.println(locationMap.get(5).getDescription());
                  loc = exits.get(5);
              }else if (word.equalsIgnoreCase("east")){
                  System.out.println(locationMap.get(3).getDescription());
                  loc = exits.get(3);
              }else if (word.equalsIgnoreCase("south")){
                  System.out.println(locationMap.get(4).getDescription());
                  loc = exits.get(4);
              }else {
                  System.out.println("You cannot go in that direction");
              }
          }
      }

    }
 **/

    /**
     //            while (word.equals("0")){
     ////                System.out.println(locationMap.get(loc).getDescription());
     ////                if (loc == 0) {
     ////                    break;
     ////          brea
//                     Map<String, Integer> exits = locationMap.get(word).getExits();
//                     System.out.println("Available exits are: ");
//                     for (String exit : exits.keySet()){
//                         System.out.print(exit + ", ");
//                     }
//                     System.out.println();
     ////
     ////                String direction = scanner.nextLine().toUpperCase();
     ////                String[] words = direction.split(" ");
     //                if (exits.containsKey(word.equals("west"))){
     //                    locationMap.get(2);
     //                }else{
     //                    System.out.println("You cannot go in that direction");
     //                }
     //
     //            }
     **/
}
}
