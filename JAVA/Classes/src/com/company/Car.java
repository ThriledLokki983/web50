package com.company;

public class Car {
    // PUBLIC ==> Unrestricted access for all other classes. It is a blueprint for an object to be created

    // This is the state component of our class
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    // Setter
    public void setModel(String model){
        this.model = model;
    }

    // Getter
    public String getModel(){
        return this.model;
    }
}
