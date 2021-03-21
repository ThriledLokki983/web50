package com.company;

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
                    searchItem():
                    break;
                case 6:
                    quit = true;
                    break;
            }

        }
    }

    public static void printInstructions(){
        System.out.println("\nPress");
        System.out.println("\n0 - To print choice options.");
        System.out.println("\n1 - To print a list of grocery items.");
        System.out.println("\n2 - To add an item to the list.");
        System.out.println("\n3 - To modify an item in the list.");
        System.out.println("\n4 - To to delete an item from the list.");
        System.out.println("\n5 - To search for an item in the list.");
        System.out.println("\n6 - To close application.");
    }

    public static void addItem(){
        System.out.print("Please enter a grocery item.");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.print("Please enter item number");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNumber-1, newItem);
    }

    public static void removeItem(){
        System.out.print("Please enter item number");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNumber);
    }

    public static void searchItem(){
        System.out.print("Enter item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.findItem(searchItem) != null){
            System.out.println("Found: " + searchItem + " in the grocery list");
        }else {
            System.out.println(searchItem + " is not in the grocery list");
        }
    }








}
