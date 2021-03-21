package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int number = MinimumElement.readInteger();
        //System.out.println(number);
        int[] myArrayNumbers = MinimumElement.readElements(number);
        MinimumElement.printArray(myArrayNumbers);
        System.out.println("Min = " + MinimumElement.findMin(myArrayNumbers));
        // System.out.println("The Array: " + Arrays.toString(myNumberArray));
        //System.out.println("The minimum number = " + MinElement.findMin(myNumberArray));

    }
}
