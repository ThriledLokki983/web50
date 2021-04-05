package com.company;

public class Carpert {
    private double cost;

    public Carpert(double cost) {
        this.cost = (cost < 0) ? 0 : cost;
    }
    public double getCost(){
        return cost;
    }
}
