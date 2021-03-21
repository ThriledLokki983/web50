package com.company;

import java.util.Scanner;

public class ReversedArray {
    private static Scanner scanner = new Scanner(System.in);

    public static int[] readIntegerArray(int number){
        System.out.println("Enter " + number + ": numbers \r" );
        int[] array = new int[number];
        for (int i = 0; i < number; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] reversedArray(int[] array){
        for (int i = 0; i < array.length/2; i++){
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length -i -1] = temp;
            }
        return array;
        }

    // Tutors solution

    public static void reverse(int[] array){
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++){
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

}
