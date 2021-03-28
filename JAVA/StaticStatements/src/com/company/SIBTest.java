package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 4:38 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SIBTest {
    public static final String owner;

    static {
        owner = "tim";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}

