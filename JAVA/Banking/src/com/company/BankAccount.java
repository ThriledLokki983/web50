package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 4/10/21
 * Time: 7:29 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;

    public BankAccount(String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    // branch is true if customer is performing a transaction at a branch and false if at the ATM
    public double deposit(double amount, boolean branch){
        balance += amount;
        return balance;
    }

    // branch is true if customer is performing a transaction at a branch and false if at the ATM
    public double withdrawal(double amount){
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }






}
