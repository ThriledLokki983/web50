package com.company;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe Burger", "Truffle Bread", "Nantwi Nam", 25);
    }

    @Override
    public void addToppings(int choice) {
        //super.addToppings(choice);
        switch (choice){
            case 1:
                double chipsPrice = 3.50;
                this.setAdditionalPrice(this.getAdditionalPrice() + chipsPrice);
                System.out.println("Added: Chips");
                break;

            case 2:
                double colaPrice = 2.90;
                this.setAdditionalPrice(this.getAdditionalPrice() + colaPrice);
                System.out.println("Added: Cola");
                break;
        }
    }

    @Override
    public void printMenu() {
        super.printMenu();
        System.out.println("------- Extra for Deluxe ---------");
        System.out.println("1. Chips          || Price: €3.50");
        System.out.println("2. Cola           || Price: €2.90");
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    public void checkOutOrder() {
        super.checkOutOrder();
    }
}
