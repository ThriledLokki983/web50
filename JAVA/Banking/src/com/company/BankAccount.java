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

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    // branch is true if customer is performing a transaction at a branch and false if at the ATM
    public double deposit(double amount, boolean branch){
        balance += amount;
        return balance;
    }

    // branch is true if customer is performing a transaction at a branch and false if at the ATM
    public double withdrawal(double amount, boolean branch){
        if ((amount > 500.00) && (!branch)){
            throw new IllegalArgumentException();
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }


    public boolean isChecking() {
        return accountType == CHECKING;
    }


}
