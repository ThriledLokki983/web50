package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        // Initialize the arraylist & add our initial amount to it
        this.transactions = new ArrayList<>();
        addTransaction(initialAmount);
    }

    // Here we add the primitive type to accept the amount to be added to our arraylist of Double-class
    public void addTransaction(double amount){
        // validate to make sure the user input the right information
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

}
