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

    public boolean addNewTransaction(Customer customer){
        if (findCustomer(customer) < 0){
            System.out.println("No customer information found!!");
            return false;
        }else {
            System.out.println("Your Name: ");
            String customerName = Main.scanner.nextLine();
            Double trans = Main.scanner.nextDouble();
            int position = findCustomerName(customerName);
            if (position >= 0){
                myCustomers.get(position).getTransactions().add(position+1, trans);
            }
            return true;
        }
    }


    // Return the index of the Branch if it exist
    private int findBranchName(String branchName){
        return this.branchName.indexOf(branchName);
    }

    private int findCustomerName(String customerName){
        return this.myCustomers.indexOf(customerName);
    }

    // Returns the index of customer if it exist
    public int findCustomer(Customer customer){
        return this.myCustomers.indexOf(customer.getCustomerName());
    }


}
