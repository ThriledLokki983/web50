package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 4/7/21
 * Time: 5:25 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class BankAccount {
    private double balance = 0;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
