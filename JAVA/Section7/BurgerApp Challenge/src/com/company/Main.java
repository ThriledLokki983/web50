package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Hamburger hamburger = new Hamburger("Base Burger","Italian Bread","Beef Patty",5);
//        hamburger.printMenu();
//        hamburger.addToppings(2);
//        hamburger.addToppings(1);
//        hamburger.addToppings(4);
//        hamburger.addToppings(3);
//        hamburger.checkOutOrder();
//
        HealthyBurger healthyBurger = new HealthyBurger();
        healthyBurger.printMenu();
        healthyBurger.addToppings(5);
        healthyBurger.addToppings(6);
        healthyBurger.addToppings(1);
        healthyBurger.addToppings(2);
        healthyBurger.checkOutOrder();

//        DeluxeBurger deluxeBurger = new DeluxeBurger();
//        deluxeBurger.printMenu();
//        deluxeBurger.addToppings(1);
////        deluxeBurger.addToppings(1);
////        deluxeBurger.addToppings(2);
//        deluxeBurger.checkOutOrder();
    }
}
