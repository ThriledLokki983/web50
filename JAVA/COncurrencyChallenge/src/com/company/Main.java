package com.company;

public class Main {

    public static void main(String[] args) {
	    final BankAccount myBank = new BankAccount(1000.00, "12345-678");
	    Customer customer1 = new Customer(myBank, "Customer 1");
	    Customer customer2 = new Customer(myBank, "Customer 2");

      /*  new Thread(customer1).start();
        new Thread(customer2).start();*/

        /* One of the Solutions */
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                myBank.deposit(300.00);
                myBank.withdraw(50);
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                myBank.deposit(300.00);
                myBank.withdraw(50);
            }
        };

        thread1.start();
        thread2.start();

        Thread newThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myBank.deposit(300.00);
                myBank.withdraw(50);
            }
        });

        Thread newThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myBank.deposit(300.00);
                myBank.withdraw(50);
            }
        });

        newThread1.start();
        newThread2.start();

    }
}
