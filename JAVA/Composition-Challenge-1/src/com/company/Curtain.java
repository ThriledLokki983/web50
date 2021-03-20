package com.company;

public class Curtain extends Carpet{
    private String color;
    private String type; // for winter or summer

    public Curtain(int length, int width, String color, String type) {
        super(length, width);
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
