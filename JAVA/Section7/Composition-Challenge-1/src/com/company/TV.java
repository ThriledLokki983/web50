package com.company;

public class TV {
    private String brand;
    private int size;
    private String color; // black or White

    public TV(String brand, int size, String color) {
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
