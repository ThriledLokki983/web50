package com.company;

public class Pegeout extends Car {
    private int roadService;

    public Pegeout(int roadService) {
        super("Pegeout", "4WD", 4, 5, 6, false);
        this.roadService = roadService;
    }
}
