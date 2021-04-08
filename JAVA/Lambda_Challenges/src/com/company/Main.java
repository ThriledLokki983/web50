package com.company;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        /*Q1*/
        Runnable runnable = (() -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String s : parts) {
                System.out.println(s);
            }
        });
        new Thread(runnable).start();

        /*Q2*/
        Function<String, String> everySecondChar = (s) -> {
            StringBuilder returnable = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnable.append(s.charAt(i));
                }
            }
            return returnable.toString();
        };

        /*Q3*/
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnable = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnable.append(s.charAt(i));
                }
            }
            return returnable.toString();
        };

  /*ANS*/      System.out.println(lambdaFunction.apply("1234567890"));


 /**/   everySecondChar(lambdaFunction.apply("1234567890"));


    }

    /*Q4*/
 /*A*/   private static void everySecondChar(String apply) {
        System.out.println(apply);
    }

 /*B*/   public static String everySecondChar(Function<String, String> func){
        return func.apply("1234567890");
    }


}
