package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here

        int[] myIntNumbers = getIntegers(5);
        printArray(myIntNumbers);
        sortedArray(myIntNumbers);
    }

    // Method 1 ==> Read input from user and store it in an array
    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " Integer value\r");
        int[] value = new int[number];

        for(int i = 0; i < value.length; i++){
            value[i] = scanner.nextInt();
        }
        return value;
    }

    // Method 2 ==> Take an array and print out everything in that array
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("Number #" + (int)(1+i) + ": = " + array[i]);
        }
    }

    // method 3 ==> Take an array and Sort it in descending order
    public static void sortedArray(int[] array){
        // Create a for loop to iterate over the array
        for (int i = 0; i < array.length; i++){
            // Create another loop using the index from the first loop
          for (int j = i; j < array.length; j++){
              // Create a temporary storage for each number iterated on
              int temp = 0;
              // Checking if the two number above encountered are equal or not/ which is less that the other
              if (array[i] < array[j]){
                  // Put the number in the temporary storage
                  temp = array[i];
                  // we assign the same number to our second loop // to avoid losing that number
                  array[i] = array[j];
                  // change temporary to the second loop number
                  array[j] = temp;
              }
          }
            System.out.println(array[i]);
        }
    }


}
