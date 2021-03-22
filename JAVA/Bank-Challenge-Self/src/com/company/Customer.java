package com.company;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private String name;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

    public static Customer createCustomer(String name){
        return new Customer(name);
    }
}
