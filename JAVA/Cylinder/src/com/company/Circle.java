package com.company;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = (radius < 0) ? 0 : radius;
    }


}
