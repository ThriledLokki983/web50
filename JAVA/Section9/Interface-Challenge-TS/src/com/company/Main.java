package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player gideon = new Player("Gideon", 31, 15);
        System.out.println(gideon.toString());
        savedObject(gideon);

        gideon.setHitPoints(75);
        System.out.println(gideon);
        gideon.setWeapon("StormBringer");
        savedObject(gideon);
        //loadObject(gideon);
        System.out.println(gideon);

        Isaveable dog = new Monster("dog", 12, 45);
        //((Monster) dog).getStrength();
        //Monster dog = new Monster("dog", 56, 12);
        //System.out.println("Strength = " + dog.getStrength());
        System.out.println("Strength: " + ((Monster)dog).getStrength());
        System.out.println(dog.toString());
        savedObject(dog);
        //loadObject(dog);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }


    public static void savedObject(Isaveable objectToSave){
        for(int i = 0; i < objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(Isaveable objectToLoad){
        ArrayList<String> medium = readValues();
        objectToLoad.read(medium);
    }
}
