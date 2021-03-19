package com.company;

public class Toyota extends Car{
    private int size;
    private int weight;
    private String shape; // SUV or salon car

    public Toyota(int tyres, int windscreen, String energyType, String model, String brand, int buildYear, int size, int weight, String shape) {
        super(tyres, windscreen, energyType, model, brand, buildYear);
        this.size = size;
        this.weight = weight;
        this.shape = shape;
    }

    public void toyotaMove(){
        System.out.println("Toyota.toyotaMove() called");
    }

    @Override
    public void move() {
        System.out.println("Toyota.toyotaMove() called!");
        toyotaMove();
        super.move();
    }

    public void changeToyotaGear(int shiftNumber){
        System.out.println("currently driving at gear = " + shiftNumber);
    }

    @Override
    public void changeGear() {
        System.out.println("Toyota.changeToyotaGear() called: ");
        changeToyotaGear(weight);
        super.changeGear();
    }
}
