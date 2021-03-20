package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Door door = new Door(13, 35, "brown");
        Window window = new Window(6, 13, "glass");
        Electronics electronics = new Electronics(new TV("Phillips", 27, "black"), new Light("ASUS", 70, false), new Referigerator("BNB", 13, 45), new Wifi("Ziggo-GO", 25, 250, 60));
        Funiture funiture = new Funiture(false, true, new Carpet(45, 45, new Floor(67)), new Curtain(45,13, new Floor(45), "red", "Winter"));

        Room room = new Room(door, window, electronics, funiture);
        System.out.println("Door Width = " + room.getTheDoor().getWidth());
        System.out.println("Door Length = " + room.getTheDoor().getLength());
        System.out.println("Door color = " + room.getTheDoor().getPaintColor());
    }
}
