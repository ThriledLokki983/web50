package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Contacts contacts = new Contacts();

    public static void main(String[] args) {
	// write your code here
        // Use similar ideology from past studies

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
                    addContactInfo();
                    break;
                case 2:
                    contacts.printAllContacts();
                    break;
                case 3:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions(){
        System.out.println("=========== Please select an option: =============");
        System.out.print("\n0 - To print choice options.");
        System.out.print("\n1 - To add new contact information.");
        System.out.print("\n2 - To print a all contacts.");
        System.out.println("\n3 - To close application.");
        System.out.println();
        System.out.println("=================================================");
    }

    public static void addContactInfo(){
        System.out.print("Contact Name: ");
        contacts.addName(scanner.nextLine());
        System.out.print("Contact Number: ");
        contacts.addNumber(scanner.nextLine());
    }

}
