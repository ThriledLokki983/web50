package com.company;

public class Main {

    public static void main(String[] args) {
	    Account myAccount = new Account("Gideon ");
	    myAccount.deposit(19899);
	    myAccount.withdrawal(122);
	    myAccount.withdrawal(344);
	    myAccount.withdrawal(-455);
	    myAccount.deposit(-10);
	    myAccount.calculateBalance();
        System.out.println("Balance is now " + myAccount.getBalance());
    }
}
