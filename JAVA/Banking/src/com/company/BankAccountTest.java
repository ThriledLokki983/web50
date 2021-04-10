package com.company;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
       BankAccount account = new BankAccount("Gideon", "Nimoh", 300.00);
       double balance = account.deposit(200.00, true);
       assertEquals(500.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdrawal() {
        fail("This test is yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        fail("This test is yet to be implemented");
    }

}