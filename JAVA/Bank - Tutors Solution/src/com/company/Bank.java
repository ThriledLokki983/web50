package com.company;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> bankBranches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankBranches = new ArrayList<>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.bankBranches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    // This takes a string and loops through all the names in our Branch class and compare if it is there or not
    private Branch findBranch(String branchName){
        for(int i = 0; i < this.bankBranches.size(); i++){
            Branch theBranch = this.bankBranches.get(i);
            if (theBranch.getBranchName().equals(branchName)){
                return theBranch;
            }
        }
        return null;
    }

    // listing all customers for a specific branch an optionally showing transactions if true
    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("Customers for: " + branch.getBranchName());
            ArrayList<Customer> branchCustomer = branch.getCustomers();
            for (int i = 0; i < branchCustomer.size(); i++){
                Customer customer = branchCustomer.get(i);
                System.out.println("Customer: " + customer.getName() + "[" + (i+1) + "]" );
                if (showTransactions){
                    System.out.println("Transactions:");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++){
                        System.out.println("[" + (j+1) + "] Amount:" + transactions.get(j));
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }



}
