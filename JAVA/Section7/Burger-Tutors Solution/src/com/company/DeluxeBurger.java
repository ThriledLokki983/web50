package com.company;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe", "Brown", "Sausage & Bacon", 13.53);
        super.add1Hamburger("Chips", 2.75);
        super.add2Hamburger("Cola", 1.80);
    }

    @Override
    public void add1Hamburger(String name, double price) {
        System.out.println("No extras allowed");
    }

    @Override
    public void add2Hamburger(String name, double price) {
        System.out.println("No extras allowed");
    }

    @Override
    public void add3Hamburger(String name, double price) {
        System.out.println("No extras allowed");
    }

    @Override
    public void add4Hamburger(String name, double price) {
        System.out.println("No extras allowed");
    }
}
