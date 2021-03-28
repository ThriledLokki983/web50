package com.gideon.series;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 12:45 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Series {

    public static int nSum(int n){
        /**
         * This is a much concise version for the nSum method from the Tutor
         */
        //return (n * (n + 1) / 2);
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

        /**
         * This is a much concise version for the nSum method from the Tutor
         */
        // the below test is from the Tutors solution
        int factorial = 1;
       if (n == 0){
           return 1;
       }
        for (int i = 1; i < n + 1; i++){
            int digit = i;
            factorial *= digit;
        }
        return factorial;
    }

    public static long fibonacci(int n){
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }
        long n1 = 1;
        long n2 = 0;
        long fib = 0;
        for(int i = 1; i < n; i++){
            fib = n2 + n1;
            n2 = n1;
            n1 = fib;
        }
        return fib;
//        int count = -1;
//       while (count < n){
//           System.out.print(n1 + " ");
//
//           fib = n2 + n1;
//           n2 = n1;
//           n2 = fib;
//           count += 1;
//       }
//       return fib;
    }

}
