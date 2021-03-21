package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter you choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }

        }
    }

    public static void printInstructions(){
        System.out.println("\nPress");
        System.out.print("\n0 - To print choice options.");
        System.out.print("\n1 - To print a list of grocery items.");
        System.out.print("\n2 - To add an item to the list.");
        System.out.print("\n3 - To modify an item in the list.");
        System.out.print("\n4 - To to delete an item from the list.");
        System.out.print("\n5 - To search for an item in the list.");
        System.out.print("\n6 - To close application.");
    }

    public static void addItem(){
        System.out.print("Please enter a grocery item.");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.print("Please enter item name: ");
        String itemNumber = scanner.nextLine();
        // scanner.nextLine();
        System.out.println("Enter new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNumber, newItem);
    }

    public static void removeItem(){
        System.out.print("Please enter item name: ");
        String itemNumber = scanner.nextLine();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNumber);
    }

    public static void searchItem(){
        System.out.print("Enter item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)){
            System.out.println("Found: " + searchItem + " in the grocery list");
        }else {
            System.out.println(searchItem + " is not in the grocery list");
        }
    }


public static void processArrayList(){
    ArrayList<String> newArray = new ArrayList<>();
    newArray.addAll(groceryList.getGroceryList());

    ArrayList<String> anotherArray = new ArrayList<>(groceryList.getGroceryList());

    String[] myArray = new String[groceryList.getGroceryList().size()];
    myArray = groceryList.getGroceryList().toArray(myArray);
}





}
