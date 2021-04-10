package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.ParameterizedType;

/**
 * Name: Gideon Nimoh
 * Date: 4/10/21
 * Time: 8:37 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {
    private BankAccount account;

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Gideon", "Nimoh", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...........");
    }
}
