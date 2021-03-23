package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

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
        System.out.print("\n0 - Instructions.");
        System.out.print("\n1 - Create Bank Account.");
        System.out.println("\n2 - Quit!.");
        System.out.println("=================================================");

    }

    public static void branchInstructions() {
        boolean quit = false;
        int choice = 0;
        selectOption();
        while (!quit) {
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    modifyContactName();
                    quit = true;
                case 2:
                    quit = true;
                    break;
            }
        }
    }



}
