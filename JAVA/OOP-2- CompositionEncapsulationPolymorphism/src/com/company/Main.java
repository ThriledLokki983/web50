package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Dimensions dimensions = new Dimensions(25, 32, 6);
        Case theCase = new Case("ZenBook-M1", "ASUS", "240-V", dimensions);

        Monitor theMonitor = new Monitor("All Clear-HD", "ASUS", 27, new Resolution(2540, 1440));
        Motherboard motherboard = new Motherboard("ACER", "ASUS", 4, 66, "Version 3.4.2");

        // Composition
        PC thePC = new PC(theCase, theMonitor, motherboard);
        thePC.getMonitor().drawPixelAt(2300, 6788, "blue");
        thePC.getMotherboard().loadProgram("Mac-OS 2.8.9");
        thePC.getTheCase().pressPowerButton();

    }
}
