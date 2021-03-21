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
                System.out.println("\n Added: Avocado");
                break;

            case 6:
                double mushroomPrice = 1.85;
                this.setAdditionalPrice(this.getAdditionalPrice() + mushroomPrice);
                System.out.println("\n Added: Mushroom");
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
        System.out.println("5. Avocado        || Base price: $2.75");
        System.out.println("6. Mushroom       || Base price: $1.85");
    }
}
