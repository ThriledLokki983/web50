package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Hamburger hamburger = new Hamburger("Basic", "Rye", "Sausage", 3.56);
        // hamburger.itemizeHamburger();
        hamburger.add1Hamburger("Tomato", 0.27);
        hamburger.add2Hamburger("lettuce", 1.12);
        hamburger.add3Hamburger("onion", 1.30);
        System.out.println("Total price = " + hamburger.itemizeHamburger());
        
    }
}
