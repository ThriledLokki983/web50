package com.gideon.series;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 12:45 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Series {

    public static int nSum(int n){
        int sum = 0;
        if (n < 0){
            return -1;
        }
        for (int i = 0; i < n+1; i++){
            int digit = i;
            sum += digit;
        }
        return sum;
    }

    public static int factorial(int n){
        int factorial = 1;
       if (n < 0){
           return -1;
       }
        for (int i = 1; i < n + 1; i++){
            int digit = i;
            factorial *= digit;
        }
        return factorial;
    }

    public static void fibonacci(int n){
        int n1 = 0; int n2 = 1;
        int count = -1;
        if (n < 0){
            return;
        }
       while (count < n){
           System.out.print(n1 + " ");

           int n3 = n2 + n1;
           n1 = n2;
           n2 = n3;
           count += 1;
       }
    }

}
