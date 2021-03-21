package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        for (int i = 0; i < myIntegers.length; i++){
            System.out.println("Element " + i + " typed value was " + myIntegers[i]);
        }
        System.out.println("Average is = " + getAverage(myIntegers));
	// ARRAYS ==> Possibility to store a list of items of the same type

        //int[] myVariable = {23, 67, 78, 12, 45, 398};

        // This will assign ten individual elements in the array
        // int[] myIntArray = new int[10];
//        int[] myVariable = new int[5]; //{23, 67, 78, 12, 45, 398};
//
//        printArray(myVariable);

//        for (int i = 0; i < myVariable.length; i++){
//            myVariable[i] = i * 10;
//            System.out.println("Element " + i + ", value = " + myVariable[i]);
//        }
//        for (int j = 0; j < 10; j++){
//            System.out.println("Element " + j + ", value = " + myVariable[j]);
//        }
//        System.out.println(myVariable[5]);
//        System.out.println(myVariable[3]);
//        System.out.println(myVariable[1]);


    }
    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static double getAverage(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return (double)sum/(double)array.length;
    }

//    public static void printArray(int[] array){
//        for (int i = 0; i < array.length; i++){
//            array[i] = i * 10;
//            System.out.println("Element " + i + ", value = " + array[i]);
//        }
    }

