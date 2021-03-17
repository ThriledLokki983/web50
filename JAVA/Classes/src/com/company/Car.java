package com.company;

import java.util.Locale;

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
        String validModel = model.toLowerCase();
        if (validModel.equals("kantanka") || validModel.equals("toyota")){
            this.model = model;
        }else {
            this.model = "Unknown";
        }

    }

    // Getter
    public String getModel(){
        return this.model;
    }
}
