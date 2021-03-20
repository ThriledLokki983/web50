package com.company;

public class Referigerator {
    private String brand;
    private int length;
    private int width;

    public Referigerator(String brand, int length, int width) {
        this.brand = brand;
        this.length = length;
        this.width = width;
    }

    public String getBrand() {
        return brand;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
