package com.company;

public class Calculator {
    private Floor floor;
    private Carpert carpet;

    public Calculator(Floor floor, Carpert carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost(){
        return floor.getArea() * carpet.getCost();
    }
}
