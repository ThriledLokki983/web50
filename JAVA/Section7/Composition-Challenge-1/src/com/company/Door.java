package com.company;

public class Door {
    private int width;
    private int length;
    private String paintColor;

    public Door(int width, int length, String paintColor) {
        this.width = width;
        this.length = length;
        this.paintColor = paintColor;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public String getPaintColor() {
        return paintColor;
    }
}
