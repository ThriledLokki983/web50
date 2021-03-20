package com.company;

public class Hamburger {
    private String name;
    private String breadRollType;
    private String meat;
    private double basePrice;
    private double additionalPrice;

    public Hamburger(String name, String breadRollType, String meat, double basePrice) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.basePrice = basePrice;
    }

//    public double addTopping(String theTopping){
//        return this.basePrice += this.additionalPrice;
//    }

    public void printMenu(){
        System.out.println("************ BILLS BURGER MENU ************");
        System.out.println("1. Lettuce        || Base price: $2.0");
        System.out.println("2. Tomatoes       || Base price: $1.0");
        System.out.println("3. Cheese         || Base price: $1.50");
        System.out.println("4. Onions         || Base price: $2.50");
    }

    public void addToppings(int choice){
        if(choice > 0 && choice < 5){
            switch (choice){
                case 1:
                    double lettucePrice = 2.0;
                    this.setAdditionalPrice(this.additionalPrice + lettucePrice);
                    System.out.println("\n Added: Lettuce");
                    break;

                case 2:
                    double tomatoPrice = 1;
                    this.setAdditionalPrice(this.additionalPrice + tomatoPrice);
                    System.out.println("\n Added: Tomatoes");
                    break;

                case 3:
                    double cheesePrice = 1.50;
                    this.setAdditionalPrice(this.additionalPrice + cheesePrice);
                    System.out.println("\n Added: Cheese");
                    break;

                case 4:
                    double onionPrice = 2.50;
                    this.setAdditionalPrice(this.additionalPrice + onionPrice);
                    System.out.println("\n Added: Onions");
                    break;
            }
        }
    }

    public void checkOutOrder(){
        System.out.println("\n ********************** CHECK OUT ORDER *********************** ");
        System.out.println("Burger type: " + getName() + "            Price: " + getBasePrice());
        System.out.println("Additions: " + "                         Price: " + getAdditionalPrice());
        System.out.println("----------------------------------- TOTAL: " + (getBasePrice() + getAdditionalPrice()));
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

}
