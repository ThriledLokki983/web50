package com.company;

import java.util.ArrayList;

public class Bank {
    private final String bankName;
    private final ArrayList<Branch> myBranches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.myBranches = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }
    public ArrayList<Branch> getMyBranches() {
        return myBranches;
    }

    private Branch findBranch(String branchName){
        for (Branch theBranch : myBranches) {
            if (theBranch.getBranchName().equals(branchName)) {
                return theBranch;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName) != null){
            return false;
        }
        return this.myBranches.add(new Branch(branchName));
    }

    public boolean addCustomer(String branchName, String customerName, double transactionAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            branch.addNewCustomer(customerName, transactionAmount);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            branch.addCustomerTransaction(customerName, amount);
            return true;
        }
        return false;
    }

    public boolean printCustomersTransactions(String branchName, boolean showTransaction){
        Branch theBranch = findBranch(branchName);
        if (theBranch != null){
            System.out.println("Branch Name: " + theBranch.getBranchName());
            ArrayList<Customer> branchCustomers = theBranch.getMyCustomers();
            for (int i = 0; i < branchCustomers.size(); i++){
                Customer customer = branchCustomers.get(i);
                System.out.println((i + 1)+ "Customer Name: " + customer.getCustomerName());
                if (showTransaction){
                    System.out.println("Transactions: ");
                    ArrayList<Double> transaction = customer.getTransactions();
                    for (int j = 0; j < transaction.size(); j++){
                        System.out.println((j+1) + ". Amount: " + transaction.get(j));
                    }
                }
            }
            return true;
        }else{
            System.out.println("Could not find Branch: " + branchName);
            return false;
        }
    }

}
