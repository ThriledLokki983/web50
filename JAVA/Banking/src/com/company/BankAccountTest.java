package com.company;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {
    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.Before
    public void setup(){
       account = new BankAccount("Gideon", "Nimoh", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test......");
    }

    @org.junit.Test
    public void deposit() {
       double balance = account.deposit(200.00, true);
       assertEquals(1200.00, balance, 0);
    }

    @org.junit.Test
    public void withdrawal_branch() {
        double balance = account.withdrawal(150.00, true);
        assertEquals(850.00, balance, 0);
    }

    @org.junit.Test
    public void withdrawal_notBranch() throws IllegalArgumentException {
         account.withdrawal(600.00, true);
         //fail("Should throw IllegalArgumentException");
        //assertEquals(400.00, balance, 0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdrawal() {
        account.withdrawal(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void is_Checking_true(){
        assertTrue(account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void tearDown(){
        System.out.println("Count = " + count++);
    }

}