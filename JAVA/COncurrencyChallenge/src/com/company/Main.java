package com.company;

public class Main {

    public static void main(String[] args) {
	    BankAccount myBank = new BankAccount(1000, "12345-678");
	    Customer customer1 = new Customer(myBank, "Customer 1");
	    Customer customer2 = new Customer(myBank, "Customer 2");

        new Thread(customer1).start();
        new Thread(customer2).start();



    }
}
