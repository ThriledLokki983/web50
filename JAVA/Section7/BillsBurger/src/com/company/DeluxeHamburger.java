package com.company;

public class DeluxeHamburger extends Hamburger{
    private boolean toppings;

    public DeluxeHamburger(String breadRoll, String meat, double totalPrice) {
        super(breadRoll, meat, totalPrice);
        this.toppings = true;
    }

    @Override
    public double addTopping(String theTopping) {
        return super.addTopping(theTopping);
    }

    public double toppingAddAuto(){
        if (toppings){
            return this.getTotalPrice();
        }
        return this.getTotalPrice();
    }
}
