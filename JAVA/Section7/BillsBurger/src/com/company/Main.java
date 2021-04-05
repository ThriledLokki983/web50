package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Hamburger hamburger = new Hamburger("Lobster Roll", "Bacon", 4.68);
        System.out.println("Hamburger:");
        System.out.println("Bread Roll Type: " +hamburger.getBreadRoll());
        System.out.println("Meat: " +hamburger.getMeat());
        System.out.println("Total Price: " + hamburger.getTotalPrice());
        hamburger.addTopping("Tomatoes");
        System.out.println("Total price of Hamburger = " +hamburger.getTotalPrice());
        System.out.println();
        HealthyBurger healthyBurger = new HealthyBurger("Salmon", 6.90, "Perfect Salmon Burger");
        System.out.println("Healthy Burger");
        System.out.println("Bread Roll Type: " +healthyBurger.getBreadRoll());
        System.out.println("Meat: " +healthyBurger.getMeat());
        System.out.println("Price: " +healthyBurger.getTotalPrice());
        healthyBurger.addTopping("onions");
        System.out.println("Total price is now: " + healthyBurger.getTotalPrice());
    }
}
