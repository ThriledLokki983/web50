package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var myMinIntValue = Integer.MIN_VALUE;
        var myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("Minimum Int Value: " + myMinIntValue);
        System.out.println("Minimum Int Value: " + myMaxIntValue);
        System.out.println("Busted min value = " + (1 + myMaxIntValue));
        System.out.println("Busted mas value = " + (myMinIntValue - 1));

        // BYTE
        var myMinByte = Byte.MIN_VALUE;
        var myMaxByte = Byte.MAX_VALUE;
        System.out.println("Byte Min Value " + myMaxByte);
        System.out.println("Byte Min Value " + myMinByte);


        // Long
        var myMinLong = Long.MIN_VALUE;
        var myMaxLong = Long.MAX_VALUE;
        System.out.println("Long Min Value " + myMaxLong);
        System.out.println("Long Min Value " + myMinLong);

        // SHORT
        var myMinShort = Short.MIN_VALUE;
        var myMaxShort = Short.MAX_VALUE;
        System.out.println("Short Min Value " + myMaxShort);
        System.out.println("Short Min Value " + myMinShort);

        byte newByte = 120;
        short newShort = 237;
        int newInt = 2145;
        long newLong = 50000 + 10 * (newInt + newByte + newShort);
        System.out.println("My challenge result: " + newLong);


    }
}
