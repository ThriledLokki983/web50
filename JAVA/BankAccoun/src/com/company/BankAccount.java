package com.company;

public class BankAccount {
    private int accountNumber;
    private int accountBalance;
    private int customerPhoneNumber;
    private String customerName;
    private String customerEmail;

    public int getAccountNumber(){
        return this.accountNumber;
    }
    public int getAccountBalance(){
        return this.accountBalance;
    }
    public int getCustomerPhoneNumber(){
        return this.customerPhoneNumber;
    }
    public String getCustomerName(){
        return this.customerName;
    }
    public String getCustomerEmail(){
        return this.customerEmail;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(int accountBalance){
        this.accountBalance = accountBalance;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerPhoneNumber(int customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getDeposit(int amount){
        if (amount < accountBalance){
            System.out.println("Invalid amount");
        }
        return accountBalance + amount;
    }

    public int getWithdrawal(int amount){
        int balance = 0;
        if (accountBalance < amount){
            System.out.println("Insufficient balance");
        }else{
            balance =  accountBalance - amount;
        }
        return balance;
    }
}
