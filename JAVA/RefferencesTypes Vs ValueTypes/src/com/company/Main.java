package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int myIntValue = 10;
        int myOtherValue = myIntValue;

        // Value Types
        System.out.println("My IntValue = " + myIntValue);
        System.out.println("My MyOtherValue = " + myOtherValue);

        myOtherValue++;

        System.out.println("My IntValue = " + myIntValue);
        System.out.println("My MyOtherValue = " + myOtherValue);

        // Reference Type
        int[] myIntArray = new int[5]; // this holds an address of the object and NOT the object itself
        int[] myOtherArray = myIntArray;

        System.out.println("My IntArray " + Arrays.toString(myIntArray));
        System.out.println("My OtherArray " + Arrays.toString(myOtherArray));

        myIntArray[3] = 56;
        System.out.println("My IntArray after change " + Arrays.toString(myIntArray));
        System.out.println("My OtherArray after change " + Arrays.toString(myOtherArray));
    }
}
