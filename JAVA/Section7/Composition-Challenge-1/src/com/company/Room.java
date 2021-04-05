package com.company;

public class Room {
    private Door theDoor;
    private Window theWindow;
    private Electronics theElectronics;
    private Funiture theFurniture;

    public Room(Door theDoor, Window theWindow, Electronics theElectronics, Funiture theFurniture) {
        this.theDoor = theDoor;
        this.theWindow = theWindow;
        this.theElectronics = theElectronics;
        this.theFurniture = theFurniture;
    }

    public Door getTheDoor() {
        return theDoor;
    }

    public Window getTheWindow() {
        return theWindow;
    }

    public Electronics getTheElectronics() {
        return theElectronics;
    }

    public Funiture getTheFurniture() {
        return theFurniture;
    }
}
