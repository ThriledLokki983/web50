package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Hamburger hamburger = new Hamburger("Basic", "Rye", "Sausage", 3.56);
//        // hamburger.itemizeHamburger();
//        hamburger.add1Hamburger("Tomato", 0.27);
//        hamburger.add2Hamburger("lettuce", 1.12);
//        hamburger.add3Hamburger("onion", 1.30);
//        System.out.println("Total price = " + hamburger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 3.50);
        healthyBurger.add1Hamburger("egg", 4.00);
        healthyBurger.addHeath1("Bacon", 4.45);
        System.out.println("Total Healthy Burger price: "+ healthyBurger.itemizeHamburger());


        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.itemizeHamburger();
        deluxeBurger.add1Hamburger("Mushroom", 3.70);
        System.out.println("Total Deluxe Burger price: "+ deluxeBurger.itemizeHamburger());

    }
}
