package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Contacts contacts = new Contacts();

    public static void main(String[] args) {
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
                    modifyContactInfo();
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.print("=========== Please select an option: ============");
        System.out.print("\n0 - Instructions.");
        System.out.print("\n1 - Add New Contact.");
        System.out.print("\n2 - Show All Contacts.");
        System.out.print("\n3 - Modify ContactInfo.");
        System.out.println("\n4 - Quit Application.");
        System.out.println("=================================================");
    }

    public static void selectOption(){
        System.out.print("=========== Please select an option: ============");
        System.out.print("\n1 - Contact Name.");
        System.out.println("\n2 - Contact Number.");
        System.out.println("=================================================");
    }

    public static void addContactInfo(){
        System.out.print("Contact Name: ");
        contacts.addName(scanner.nextLine());
        System.out.print("Contact Number: ");
        contacts.addNumber(scanner.nextLine());
    }
    public static void modifyContactName(){
        System.out.print("Please Enter The Contact name: ");
        String currentContactName = scanner.nextLine();
        System.out.print("Please Enter The New Contact name: ");
        String newContactName = scanner.nextLine();
        contacts.modifyContactName(currentContactName, newContactName);
    }

    public static void modifyContactNumber(){
        System.out.print("Please Enter The Contact number: ");
        String currentContactNumber = scanner.nextLine();
        System.out.print("Please Enter The New Contact number: ");
        String newContactNumber = scanner.nextLine();
        contacts.modifyContactNumber(currentContactNumber, newContactNumber);
    }

    public static void modifyContactInfo(){
        boolean quit = false;
        int choice = 0;
        selectOption();
        while(!quit) {
            System.out.println("Enter/Select an Option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    modifyContactName();
                    quit = true;
                    break;
                case 2: modifyContactNumber();
                    quit = true;
                    break;
            }
        }
    }

}
