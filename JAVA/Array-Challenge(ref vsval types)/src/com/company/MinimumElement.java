package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class MinimumElement {

    private static Scanner scanner = new Scanner(System.in);

    public static int readInteger(){
        System.out.println("Enter number of elements: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public static int[] readElements(int count){
        // Initialize our array
        int[] array = new int[count];
            System.out.println("Enter a number:" + "\r");
            for (int j = 0; j < count; j++){
                array[j] = scanner.nextInt();
            }
        return array;
    }

    public static int findMin(int[] array){
        // Initialize min to 0
        int min = 0;
        for (int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                if (array[i] <= array[j]){
                    min = array[i];
                    array[i] = array[j];
                    array[j] = min;
                }
            }
        }
        return min;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Element #" + (int)(i+1) + ": " + array[i]);
        }
    }
}
