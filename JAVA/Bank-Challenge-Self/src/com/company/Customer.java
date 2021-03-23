package com.company;

public class Customer {
    private String customerName;
    private boolean transactions;

    public Customer(String customerName, boolean transactions) {
        this.customerName = customerName;
        this.transactions = transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean getTransactions() {
        return transactions;
    }

    public static Customer createCustomer(String name, boolean trans){
        return new Customer(name, trans);
    }
}
