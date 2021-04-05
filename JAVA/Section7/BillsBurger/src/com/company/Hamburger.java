package com.company;

public class Hamburger {
    private String breadRoll;
    private String meat;
    private String sauce;
    private double totalPrice;
    // 4 Additional things to add to the burger
    private boolean toppings; // This should cater for things like lettuce, tomatoes, carrot, mushroom etc

    public Hamburger(String breadRoll, String meat, double totalPrice) {
        this.breadRoll = breadRoll;
        this.meat = meat;
        this.sauce = "hot sauce";
        this.toppings = false;
        this.totalPrice = totalPrice;
    }

    public double addTopping(String theTopping){
        System.out.println("Topping added: " + theTopping);
        return this.totalPrice += 0.50;
    }


    public String getBreadRoll() {
        return breadRoll;
    }

    public String getMeat() {
        return meat;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
