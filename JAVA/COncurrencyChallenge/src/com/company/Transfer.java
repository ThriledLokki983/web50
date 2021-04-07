package com.company;

import com.company.BankAccount;

import java.util.concurrent.locks.ReentrantLock;


/**
 * Name: Gideon Nimoh
 * Date: 4/7/21
 * Time: 7:03 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Transfer implements Runnable{
    private com.company.BankAccount sourceAccount, destinationAccount;
    private double amount;
    private ReentrantLock transferLock;

    Transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }
}



