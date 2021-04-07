package com.company;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Name: Gideon Nimoh
 * Date: 4/7/21
 * Time: 5:30 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Customer implements Runnable{
    private BankAccount bankAccount;
    private String name;
    private String color;
    private ReentrantLock bankLock;

    public Customer(BankAccount bankAccount, String name) {
        this.bankAccount = bankAccount;
        this.name = name;
        this.color = color;
    }

    @Override
    public void run() {
        while (true){
                try {
                    if (bankAccount.getBalance() != 0){
                        bankAccount.deposit(300);
                        System.out.println(ThreadColor.ANSI_GREEN + "Deposited $300.00 and the Balance is: " + bankAccount.getBalance());
                    }
                    bankAccount.withdraw(50);
                    System.out.println(ThreadColor.ANSI_YELLOW + "Withdrawn: $50.00 and the Balance is: " + bankAccount.getBalance());
                }catch (Exception e){

                }
        }
    }
}
