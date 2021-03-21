package com.company;

import java.util.Scanner;

public class SortedArray {
    public static Scanner scanner = new Scanner(System.in);

    public static int[] getIntegers(int capacity){
        System.out.println("Enter " + capacity + " integer values\r");
        int[] array = new int[capacity];

        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length; j++){
                int temp = 0;
                if (array[i] < array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(array[i]);
        }

    }
}
