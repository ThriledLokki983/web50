package com.company;

public class Hamburger {
    private String name;
    private String breadRollType;
    private String meat;
    private double basePrice;

    private String add1Name;
    private double add1Price;

    private String add2Name;
    private double add2Price;

    private String add3Name;
    private double add3Price;

    private String add4Name;
    private double add4Price;

    public Hamburger(String name, String breadRollType, String meat, double basePrice) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.basePrice = basePrice;
    }

    public void add1Hamburger(String name, double price){
        this.add1Name = name;
        this.add1Price = price;
    }

    public void add2Hamburger(String name, double price){
        this.add2Name = name;
        this.add2Price = price;
    }

    public void add3Hamburger(String name, double price){
        this.add3Name = name;
        this.add3Price = price;
    }

    public void add4Hamburger(String name, double price){
        this.add4Name = name;
        this.add4Price = price;
    }

//    public double itemizeHamburger() {
//        System.out.println("One order of " + name + " on " + breadRollType + " with " + add1Name + " " + add2Name + " " + add2Name + " " + add4Name);
//        return (basePrice + add1Price + add2Price + add3Price  + add4Price);
//    }

    public double itemizeHamburger(){
        double hamburgerPrice = this.basePrice;
        System.out.println(this.name + " hamburger " + "on a " + this.breadRollType + " roll with " + this.meat + ": price = " + this.basePrice);
        if (this.add1Name != null){
            hamburgerPrice += this.add1Price;
            System.out.println("Added: " + this.add1Name + " for an extra " + this.add1Price);
        }  if (this.add2Name != null){
            hamburgerPrice += this.add2Price;
            System.out.println("Added: " + this.add2Name + " for an extra " + this.add2Price);
        } if (this.add3Name != null){
            hamburgerPrice += this.add3Price;
            System.out.println("Added: " + this.add3Name + " for an extra " + this.add3Price);
        } if (this.add4Name != null){
            hamburgerPrice += this.add4Price;
            System.out.println("Added: " + this.add4Name + " for an extra " + this.add4Price);
        }
        return hamburgerPrice;
    }
}
