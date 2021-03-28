package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static Branches branches = new Branches("Groningen");
    private static Customer customer = new Customer("gideon");



    public static void main(String[] args) {
	// write your code here

        boolean quit = false;
        startBanking();
        printActions();
        while (!quit){
            System.out.print("[Press -2- for all options] Select an Option:   ");
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
                    customerInfo();
                    break;
                case 3:
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
        System.out.println("0 - Close App.\n" +
                "1 - Add New Customer.\n" +
                "2 - Show Customer info.\n" +
                "3 - Show Instructions.\n");
        System.out.println("=================================================");
        //System.out.println("Select an Option: ");
    }

    private static void customerInfo(){

    }



    public static void addNewTransaction(){
        System.out.println("Your Name: ");
        String customerName = scanner.nextLine();
        int position = branches.getMyCustomers().indexOf(customerName);
        if (position < 0){
            System.out.println("Unknown Customer!!!");
        }else{

        }
    }


    public static void addNewCustomer(){
        ArrayList<Double> transactions = new ArrayList<>();
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Initial Transaction: ");
        Double initialTransaction = scanner.nextDouble();

//        transactions.add(initialTransaction);
//        Customer newCustomer = branches.createCustomer(customerName, transactions);
//        System.out.println(newCustomer.getCustomerName());
//
//        for (int i = 0; i < newCustomer.getTransactions().size(); i++){
//            System.out.print(newCustomer.getTransactions().get(i));
//            System.out.println();
//        }
    }

}
