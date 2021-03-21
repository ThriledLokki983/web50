package com.company;

public class HealthyBurger extends Hamburger {

    public HealthyBurger() {
        super("Perfect Salmon Burger", "Brown Rye Bread Roll", "Salmon", 10);
    }

    @Override
    public void addToppings(int choice) {
        super.addToppings(choice);
        switch (choice){
            case 5:
                double avocadoPrice = 2.75;
                this.setAdditionalPrice(this.getAdditionalPrice() + avocadoPrice);
                System.out.println("Added: Avocado");
                break;

            case 6:
                double mushroomPrice = 1.85;
                this.setAdditionalPrice(this.getAdditionalPrice() + mushroomPrice);
                System.out.println("Added: Mushroom");
                break;
        }
    }

    @Override
    public void checkOutOrder() {
        super.checkOutOrder();
    }

    @Override
    public void printMenu() {
        super.printMenu();
        System.out.println();
        System.out.println("------- Extra for Healthy Burger ---------");
        System.out.println("5. Avocado        || Price: €2.75");
        System.out.println("6. Mushroom       || Price: €1.85");
        System.out.println("------------------------------------------");
        System.out.println();
    }
}
