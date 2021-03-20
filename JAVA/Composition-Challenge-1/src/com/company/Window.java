package com.company;

public class Window {
    private int width;
    private int length;
    private String materialType; // glass or wood

    public Window(int width, int length, String materialType) {
        this.width = width;
        this.length = length;
        this.materialType = materialType;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public String getMaterialType() {
        return materialType;
    }
}
