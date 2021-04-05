package com.company;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.branchName = name;
        this.customers = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if (findCustomer(customerName) == null){
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }
    // This takes a string and loops through all the names in our customer'' class and compare if it is there or not
    private Customer findCustomer(String name){
        for(int i = 0; i < this.customers.size(); i++){
            Customer theCustomer = this.customers.get(i);
            if (theCustomer.getName().equals(name)){
                return theCustomer;
            }
        }
        return null;
    }

    public boolean addCustomerTransaction(String customerName, double newAmount){
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null){
            existingCustomer.addTransaction(newAmount);
            return true;
        }
        return false;
    }
}
