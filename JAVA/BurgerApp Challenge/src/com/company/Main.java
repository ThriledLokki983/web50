package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Hamburger hamburger = new Hamburger("Base Burger","Italian Bread","Beef Patty",5);
        hamburger.printMenu();
        hamburger.addToppings(2);
//        hamburger.addToppings(1);
//        hamburger.addToppings(4);
//        hamburger.addToppings(3);

        hamburger.checkOutOrder();
    }
}
