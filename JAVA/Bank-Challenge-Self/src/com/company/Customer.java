package com.company;

public class Customer {
    private String customerName;
    private Transactions transactions;

    public Customer(String customerName, Transactions transactions) {
        this.customerName = customerName;
        this.transactions = transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public static Customer createCustomer(String name, Transactions trans){
        return new Customer(name, trans);



    }
}
