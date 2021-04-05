package com.company;

public class Carpet {
    private int length;
    private int width;
    private Floor floorSize;

    public Carpet(int length, int width, Floor floorSize) {
        this.length = length;
        this.width = width;
        this.floorSize = floorSize;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Floor getFloorSize() {
        return floorSize;
    }
}
