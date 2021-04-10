package com.company;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
       account = new BankAccount("Gideon", "Nimoh", 300.00, BankAccount.CHECKING);
        System.out.println("Running a test......");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
       double balance = account.deposit(200.00, true);
       assertEquals(500.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdrawal() {
        double balance = account.withdrawal(150, true);
        assertEquals(150.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(500.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdrawal() {
        account.withdrawal(200.00, true);
        assertEquals(100.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void is_Checking_true(){
        assertTrue(account.isChecking());
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterClass(){
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown(){
        System.out.println("Count = " + count++);
    }

}