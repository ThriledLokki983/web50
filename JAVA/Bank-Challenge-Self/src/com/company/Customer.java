package com.company;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transactions;


    public Customer(String name, ArrayList<Double> transactions) {
        this.customerName = name;
        this.transactions = transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

    public static Customer createCustomer(String name, ArrayList<Double> transactions){
        return new Customer(name, transactions);
    }
}
