package com.company;

public class HealthyBurger extends Hamburger{
    private String name;

    public HealthyBurger(String meat, double totalPrice, String name) {
        super("Rye Bread Roll", meat, totalPrice);
        this.name = name;
    }

    @Override
    public double addTopping(String theTopping) {
        if (theTopping == "onions" || theTopping == "avocado"){
            return super.addTopping(theTopping);
        }
        return  this.getTotalPrice();
    }
}
