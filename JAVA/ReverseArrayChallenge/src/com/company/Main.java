package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myArray = ReversedArray.readIntegerArray(5);
        System.out.println("Original Array: " + Arrays.toString(myArray));

        int[] myReverseArray = ReversedArray.reversedArray(myArray);
        System.out.println("Reversed Array: " + Arrays.toString(myReverseArray));



    }
}
