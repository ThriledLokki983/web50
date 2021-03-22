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
            System.out.print("Enter/Select an Option: ");
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
                    deleteContactInfo();
                    break;
                case 5:
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
        System.out.print("\n3 - Edit Contact Info.");
        System.out.print("\n4 - Delete Contact Info.");
        System.out.println("\n5 - Quit!.");
        System.out.println("=================================================");
    }

    public static void selectOption(){
        System.out.print("=========== Please select an option: ============");
        System.out.print("\n1 - Edit Name.");
        System.out.println("\n2 - Edit Number.");
        System.out.println("=================================================");
    }

    public static void deleteContactInfo(){
        System.out.print("Please Enter Contact Name/Number: ");
        String contactName = scanner.nextLine();
        contacts.removeContactName(contactName);
        System.out.println(contactName + " has been deleted");
        System.out.println("=================================================");
    }

    public static void modifyContactNumber(){
        System.out.print("Please Enter The Contact number: ");
        String currentContactNumber = scanner.nextLine();
        System.out.print("Please Enter The New Contact number: ");
        String newContactNumber = scanner.nextLine();
        contacts.modifyContactNumber(currentContactNumber, newContactNumber);
        System.out.println("=================================================");
    }
    public static void addContactInfo(){
        System.out.print("Contact Name: ");
        contacts.addName(scanner.nextLine());
        System.out.print("Contact Number: ");
        contacts.addNumber(scanner.nextLine());
        System.out.println("=================================================");
    }
    public static void modifyContactName(){
        System.out.print("Please Enter The Contact name: ");
        String currentContactName = scanner.nextLine();
        System.out.print("Please Enter The New Contact name: ");
        String newContactName = scanner.nextLine();
        contacts.modifyContactName(currentContactName, newContactName);
    }

    public static void modifyContactInfo(){
        boolean quit = false;
        int choice = 0;
        selectOption();
        while(!quit) {
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
