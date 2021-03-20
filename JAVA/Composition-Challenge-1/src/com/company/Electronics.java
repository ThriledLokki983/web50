package com.company;

public class Electronics {
    private TV tv;
    private Light light;
    private Referigerator fridge;
    private Wifi wifi;

    public Electronics(TV tv, Light light, Referigerator fridge, Wifi wifi) {
        this.tv = tv;
        this.light = light;
        this.fridge = fridge;
        this.wifi = wifi;
    }

    public TV getTv() {
        return tv;
    }

    public Light getLight() {
        return light;
    }

    public Referigerator getFridge() {
        return fridge;
    }

    public Wifi getWifi() {
        return wifi;
    }
}
