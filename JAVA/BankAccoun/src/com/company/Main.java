package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(12345678);
        bankAccount.setAccountBalance(25);
        bankAccount.setCustomerEmail("customer@bankaccount.nl");
        bankAccount.setCustomerName("Gideon Nimoh");
        bankAccount.setCustomerPhoneNumber(626603494);

        System.out.println("Customer Name: " + bankAccount.getCustomerName());
        System.out.println("Customer Account: " + bankAccount.getAccountNumber());
        System.out.println("Customer Account balance = " + bankAccount.getAccountBalance());
        System.out.println("Customer email: " + bankAccount.getCustomerEmail());
        System.out.println("Customer Phone#: " + bankAccount.getCustomerPhoneNumber());

        int deposit = bankAccount.getDeposit(344);

        System.out.println("Customer New Balance = " + deposit);

        int balance = deposit - bankAccount.getWithdrawal(300);

        System.out.println("Customer New Balance Again = " + balance);


    }
}
