package com.company;

public class VipCustomer {
    private String name;
    private String email;
    private int creditLimit;

    public VipCustomer() {
        this("Default name", "Default email", 999);
        System.out.println("Empty Constructor");
    }

    public VipCustomer(String email, int creditLimit) {
        this("Gideon Nimoh", email, creditLimit);
    }

    public VipCustomer(String name, String email, int creditLimit) {
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCreditLimit() {
        return creditLimit;
    }
}
