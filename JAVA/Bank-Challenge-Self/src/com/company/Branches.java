package com.company;

import java.util.ArrayList;

public class Branches {
    private String branchName;
    private ArrayList<Customer> myCustomers;


    public Branches(String branchName) {
        this.branchName = branchName;
        this.myCustomers = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getMyCustomers() {
        return myCustomers;
    }

    public boolean addNewCustomer(Customer theCustomer){
        if (findCustomer(theCustomer) >= 0){
            return false;
        }
        myCustomers.add(theCustomer);
        return true;
    }




    // Return the index of the Branch if it exist
    private int findBranchName(String branchName){
        return this.branchName.indexOf(branchName);
    }
    // Returns the index of customer if it exist
    private int findCustomer(Customer customer){
        return this.myCustomers.indexOf(customer);
    }


}
