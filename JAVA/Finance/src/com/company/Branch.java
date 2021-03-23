package com.company;

import java.util.ArrayList;

public class Branch {
        private String branchName;
        private ArrayList<Customer> myCustomers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.myCustomers = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getMyCustomers() {
        return myCustomers;
    }

    private Customer findCustomer(String customerName){
        for (int i = 0; i < this.myCustomers.size(); i++){
            Customer theCustomer = myCustomers.get(i);
            if (theCustomer.getCustomerName().equals(customerName)){
                return theCustomer;
            }
        }
        return null;
    }

    public boolean addNewCustomer(String customerName, double initialAmount){
        if (findCustomer(customerName) == null){
            this.myCustomers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transactionAmount){
        Customer theCustomer = findCustomer(customerName);
        if (theCustomer != null){
            theCustomer.addNewTransactions(transactionAmount);
            return true;
        }
        return false;
    }

}
