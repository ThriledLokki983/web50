package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Name: Gideon Nimoh
 * Date: 4/7/21
 * Time: 5:25 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class BankAccount {
    private double balance = 0;
    private String accountNumber;
    private ReentrantLock bankLock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.bankLock = new ReentrantLock();
    }


    public void deposit(double amount){
       boolean status = false;
        try {
            if (bankLock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    balance += amount;
                    status = true;
                }finally {
                    bankLock.unlock();
                }
            }else {
                System.out.println("Could not get the lock. ");
            }

        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Transaction status = " + status);
    }


    public void withdraw(double amount){
        boolean status = false;
       try {
           if (bankLock.tryLock(1000, TimeUnit.MILLISECONDS)){
               try {
                   balance -= amount;
                   status = true;
               }finally {
                   bankLock.unlock();
               }
           }else {
               System.out.println("Could not get the lock");
           }
       }catch (InterruptedException e){
           System.out.println(e.getMessage());
       }
        System.out.println("Transaction status = " + status);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account Number: " + accountNumber);
    }
}
