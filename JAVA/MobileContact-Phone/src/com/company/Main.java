package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("00145897-23");


    public static void main(String[] args) {
	// write your code here



        boolean quit = false;
        startPhone();
        printActions();
        while (!quit){
            System.out.print("[Press -6- for all options] Select an Option:   ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Shutting down ........................");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact(){
        System.out.print("Add Contact Name:  ");
        String name = scanner.nextLine();
        System.out.print("Add Contact Number:  ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (mobilePhone.addNewContact(newContact)){
            System.out.println("New Contact Saved! ");
            System.out.println("=================================================\n");
        }else{
            System.out.println(name + ": Already in Contacts");
            System.out.println("=================================================\n");
        }
    }

    private static void updateContact(){
        System.out.print("Existing Contact Name:  ");
        String name = scanner.nextLine();
        Contact theContact = mobilePhone.queryContact(name);
        if (theContact == null){
            System.out.println("Contact not found:  ");
            System.out.println("=================================================\n");
            return;
        }
        System.out.print("New Contact Name: ");
        String newName = scanner.nextLine();
        System.out.print("New Contact Number: ");
        String newNumber = scanner.nextLine();
        Contact updatedContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(theContact, updatedContact)){
            System.out.println("Saved!");
        }else{
            System.out.println("Error!");
        }
        System.out.println("=================================================\n");
    }

    private static void removeContact() {
        System.out.println("Enter existing Contact Name: ");
        String name = scanner.nextLine();
        Contact theContact = mobilePhone.queryContact(name);
        if (theContact == null) {
            System.out.println("Contact not found: ");
            System.out.println("=================================================\n");
            return;
        }
        if (mobilePhone.removeContact(theContact)){
            System.out.println("Contact Deleted!");
        }else{
            System.out.println("Error deleting");
        }
        System.out.println("=================================================\n");
    }

    private static void queryContact() {
        System.out.println("Enter existing Contact Name: ");
        String name = scanner.nextLine();
        Contact theContact = mobilePhone.queryContact(name);
        if (theContact == null) {
            System.out.println("Contact not found: ");
            System.out.println("=================================================\n");
            return;
        }
        System.out.println("Name: " + theContact.getName() + " Number: " + theContact.getNumber());
        System.out.println("=================================================\n");
    }

    private static void startPhone(){
        System.out.println("Starting phone.......");
    }

    private static void printActions(){
        System.out.println("\nPress");
        System.out.println("0 - Shutdown.\n" +
                "1 - Show all Contacts.\n" +
                "2 - Add New Contact.\n" +
                "3 - Edit Contact.\n" +
                "4 - Delete Contact.\n" +
                "5 - Search for Contact.\n" +
                "6 - Show Available Options.");
        System.out.println("=================================================");
        //System.out.println("Select an Option: ");
    }

}
