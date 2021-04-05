package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("Ghana Commercial Bank");

    public static void main(String[] args) {
	// write your code here

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.print("Select an Option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    branchInstructions();
                    break;
                case 2:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.print("=========== Please select an option: ============");
        System.out.print("\n0 - Instructions.");
        System.out.print("\n1 - Create Bank Account.");
        System.out.println("\n2 - Quit!.");
        System.out.println("=================================================");

    }

    public static void selectOption(){
        System.out.print("=========== Please select an option: ============");
        System.out.print("\n0 - Instructions." +
                "\n1 - Create Bank Account." +
                "\n2 - Deposit Money." +
                "\n3 - Show All Transactions" +
                "\n4 - Quit!.\n");
        System.out.println("=================================================");

    }

    public static void addCustomer(){
        System.out.print("Branch Name: ");
        String branch = scanner.nextLine();
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Initial Deposit Amount: ");
        double amount = scanner.nextDouble();
        bank.addCustomer(branch, customerName, amount);
        System.out.println("Account Created!");
        System.out.println("=================================================");
    }

    public static void addTransaction(){
        System.out.print("Branch Name: ");
        String branch = scanner.nextLine();
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Deposit Amount: ");
        double amount = scanner.nextDouble();
        bank.addCustomerTransaction(branch, customerName, amount);
        System.out.println("Successful!");
        System.out.println("=================================================");
    }

    public static void showAllTransactions(){
        System.out.print("Branch Name: ");
        String branch = scanner.nextLine();
        System.out.print("Show Transactions?: ");
        boolean bool = scanner.nextBoolean();
        bank.printCustomersTransactions(branch, bool);
        //System.out.println(bank.printCustomersTransactions(branch, bool));
        System.out.println("=================================================");
    }

    public static void branchInstructions() {
        boolean quit = false;
        int choice = 0;
        selectOption();
        while (!quit) {
            System.out.print("Select an Option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    selectOption();
                    break;
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addTransaction();
                    break;
                case 3:
                    showAllTransactions();
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }



}
