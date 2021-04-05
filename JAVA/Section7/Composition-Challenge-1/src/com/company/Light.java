package com.company;

public class Light {
    private String brand;
    private int watt;
    private boolean smartLight;

    public Light(String brand, int watt, boolean smartLight) {
        this.brand = brand;
        this.watt = watt;
        this.smartLight = smartLight;
    }

    public String getBrand() {
        return brand;
    }

    public int getWatt() {
        return watt;
    }

    public boolean isSmartLight() {
        return smartLight;
    }
}
