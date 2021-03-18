package com.company;

public class VipCustomer {
    private String name;
    private String email;
    private int creditLimit;

    public VipCustomer() {
        this("Gideon Nimoh", "customer@vipcustomer.nl", 6);
        System.out.println("Enpty Constructor");
    }

    public VipCustomer(String name, String email, int creditLimit) {
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
    }
}
