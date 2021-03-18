package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.setAccountNumber(12345678);
//        bankAccount.setAccountBalance(305);
//        bankAccount.setCustomerEmail("customer@bankaccount.nl");
//        bankAccount.setCustomerName("Gideon Nimoh");
//        bankAccount.setCustomerPhoneNumber(626603494);

        BankAccount bankAccount = new BankAccount(123456789, 56, 626603494, "customer@bankaccount.nl", "Gideon Nimoh");

        System.out.println("Customer Name: " + bankAccount.getCustomerName());
        System.out.println("Customer Account: " + bankAccount.getAccountNumber());
        System.out.println("Customer Account balance = " + bankAccount.getAccountBalance());
        System.out.println("Customer email: " + bankAccount.getCustomerEmail());
        System.out.println("Customer Phone#: " + bankAccount.getCustomerPhoneNumber());

        // Deposit
        bankAccount.getDeposit(300);

        //Withdrawal
        bankAccount.getWithdrawal(604);
        System.out.println("###############################");
        System.out.println();
        BankAccount newAccount = new BankAccount(500, 45986709, "New Account", "newaccount@nbankaccount.com");
        System.out.println("Customer Name: " + newAccount.getCustomerName());
        System.out.println("Customer Account: " + newAccount.getAccountNumber());
        System.out.println("Customer Account balance = " + newAccount.getAccountBalance());
        System.out.println("Customer email: " + newAccount.getCustomerEmail());
        System.out.println("Customer Phone#: " + newAccount.getCustomerPhoneNumber());

    }
}
