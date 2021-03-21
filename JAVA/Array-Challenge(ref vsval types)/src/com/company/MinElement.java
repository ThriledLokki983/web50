package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MinElement {

    private static  Scanner scanner = new Scanner(System.in);

    public static int[] readIntegers(int capacity){
        System.out.println("Enter " + capacity + " numbers\r");

        // Initialize our array
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int finMin(int[] array){
        int min = 0;
        for (int i = 0; i < array.length+1; i++){
            for (int j = i; j < array.length; j++){
                if (array[i] <= array[j]){
                    min = array[i];
                    array[i] = array[j];
                    array[j] = min;
                }
            }
            //System.out.println("Min = " + min);
        }
        return min;
    }
}
