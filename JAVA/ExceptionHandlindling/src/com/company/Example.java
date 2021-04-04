package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Name: Gideon Nimoh
 * Date: 4/4/21
 * Time: 11:58 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Example {
    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }

    private static int divide(){
        int x;
        try {
            x = getInt();
        }catch (NoSuchElementException e){
            x = getInt();
        }
        int y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an Integer: ");
        while(true){
            try{
                return s.nextInt();
            }catch (InputMismatchException e){
                s.nextLine();
                System.out.println("Please enter a valid integer");
            }
        }
    }

}
