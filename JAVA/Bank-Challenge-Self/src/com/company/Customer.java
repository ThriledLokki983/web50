package com.company;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Transactions> transactions;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.transactions = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }
}
