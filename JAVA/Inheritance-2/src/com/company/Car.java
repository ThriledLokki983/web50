package com.company;

public class Car extends Vehicle {
    private String model;
    private String brand;
    private int buildYear;

    public Car(int tyres, int windscreen, String energyType, String model, String brand, int buildYear) {
        super(tyres, windscreen, "automobile", energyType);
        this.model = model;
        this.brand = brand;
        this.buildYear = buildYear;
    }

    public void changeGear(){
        System.out.println("Car.changingGear() called: ");
    }

    public void moveCar(){
        System.out.println("Car.move() called!!!");
        changeGear();
    }

    @Override
    public void move() {
        System.out.println("Car.move() called: ");
        changeGear();
        moveCar();
        super.move();
    }
}
