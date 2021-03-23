package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Branches branches = new Branches("Groningen");


    public static void main(String[] args) {
	// write your code here

        boolean quit = false;
        startBanking();
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
                    addNewCustomer();
                    break;
                case 2:
                    printActions();
                    break;
            }
        }


    }

    private static void startBanking(){
        System.out.println("Starting Banking App..................");
    }

    private static void printActions(){
        System.out.println("\nPress");
        System.out.println("0 - Shutdown.\n" +
                "1 - Show all Customer.\n" +
                "2 - Add New Customer.\n");
        System.out.println("=================================================");
        //System.out.println("Select an Option: ");
    }


    public static void addNewCustomer(){
        ArrayList<Double> transactions = new ArrayList<>();
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Initial Transaction: ");
        Double initialTransaction = scanner.nextDouble();
        Customer newCustomer = Customer.createCustomer(customerName, transactions.add(initialTransaction));
    }

}
