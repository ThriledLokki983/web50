package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here



        int[] myIntNumbers = SortedArray.getIntegers(3);
        SortedArray.printArray(myIntNumbers);
        SortedArray.sort(myIntNumbers);
//        //printArray(myIntNumbers);
//        System.out.println("Sorted Numbers in Descending order:");
//        sortedArray(myIntNumbers);
//        System.out.println(Sorted.sortArray(myIntNumbers));
//        Sorted.sortArray(myIntNumbers);
//        printArray(Sorted.sortArray(myIntNumbers));
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
    // Create a for loop to iterate over the array
    // Create another loop using the index from the first loop
    // Create a temporary storage for each number iterated on
    // Checking if the two number above encountered are equal or not/ which is less that the other
    // Put the number in the temporary storage
    // we assign the same number to our second loop // to avoid losing that number
    // change temporary to the second loop number
    public static void sortedArray(int[] array){
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
