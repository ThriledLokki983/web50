package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myNumberArray = MinElement.readIntegers(5);
        // System.out.println("The Array: " + Arrays.toString(myNumberArray));
        System.out.println("The minimum number = " + MinElement.finMin(myNumberArray));
    }
}
