package com.company;

import java.util.ArrayList;

public class Customer {
        private String customerName;
        private ArrayList<Double> transactions;

    public Customer(String customerName, double initialTransaction) {
        this.customerName = customerName;
        this.transactions = new ArrayList<>();
        addNewTransactions(initialTransaction);
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addNewTransactions(double amount){
            this.transactions.add(amount);
        }
}
