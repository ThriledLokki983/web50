package com.company;

public class Vehicle {
    private int tyres;
    private int windscreen;
    private String type;
    private String energyType;

    public Vehicle(int tyres, int windscreen, String type, String energyType) {
        this.tyres = tyres;
        this.windscreen = windscreen;
        this.type = type;
        this.energyType = energyType;
    }

    public void move(){
        System.out.println("Vehicle.move() called: ");
    }

    public void changingGears(){
        System.out.println("Vehicle.changingGears() called: ");
    }

    public int getTyres() {
        return tyres;
    }

    public int getWindscreen() {
        return windscreen;
    }

    public String getType() {
        return type;
    }

    public String getEnergyType() {
        return energyType;
    }


}
