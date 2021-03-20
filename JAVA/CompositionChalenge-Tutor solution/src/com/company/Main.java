package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("North");
        Wall wall4 = new Wall("South");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 8, 45, 2, 1);

        Lamp lamp = new Lamp("Classic", false, 89);

        BedRoom bedRoom = new BedRoom("Gideon", wall1, wall2, wall3, wall4, ceiling, bed, lamp);

        bedRoom.makeBed();
        bedRoom.getLamp().turnOn();


    }
}
