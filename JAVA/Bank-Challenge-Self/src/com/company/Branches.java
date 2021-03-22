package com.company;

import java.util.ArrayList;

public class Branches {
    private String branchName;
    private ArrayList<Customer> myBranches;


    public Branches(String branchName) {
        this.branchName = branchName;
        this.myBranches = new ArrayList<>();
    }

    // Loop through my customer List if the Customer exist
    private int findCustomer(String customerName){
        return this.branchName.indexOf(customerName);
    }
    // Loop through my customer List if the Branch exist
    private int findBranch(Customer branchName){
        return this.myBranches.indexOf(branchName);
    }


}
