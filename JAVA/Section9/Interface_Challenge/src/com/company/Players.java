package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Players implements ISaveable{
    private String playerName;

    public Players(String playerName) {
        this.playerName = playerName;
    }

    private boolean findMedium(String name){
        for (int  i = 0; i < myMedium.size(); i++){
            if(myMedium.get(i).equals(name)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveMedium(String medium) {
        if (findMedium(medium)){
            myMedium.add(medium);
            return true;
        }
        return false;
    }

    public ArrayList<String> readValues() {

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
                    saveMedium(stringInput);
                    break;
            }
        }
        return myMedium;
    }

    @Override
    public String toString() {
        return this.playerName + ": " + " Medium: "+ myMedium;
    }
}
