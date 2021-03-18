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

    public void getDeposit(int amount){
            this.accountBalance += amount;
        System.out.println("Deposit of " + amount + " made." + " New balance = " + this.accountBalance + ".");
    }

    public void getWithdrawal(int amount){
        if (this.accountBalance - amount < 0){
            System.out.println("Insufficient balance");
        }else{
            this.accountBalance -= amount;
            System.out.println("Withdrawal of " + amount + " processed." + " Current balance = " + this.accountBalance + ".");
        }
    }
}
