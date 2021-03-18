package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        VipCustomer customer = new VipCustomer();

        System.out.println(customer.getName());
        VipCustomer person = new VipCustomer("person@vipcustomer.nl", 500);
        System.out.println(person.getCreditLimit());
        System.out.println(person.getName());
        System.out.println(person.getEmail());

    }
}
