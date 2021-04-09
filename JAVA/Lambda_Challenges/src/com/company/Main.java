package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
        System.out.println("=====================================================");

        /*Q5*/
        Supplier<String> iLoveJav = () -> "I Love Java!";
        System.out.println(iLoveJav.get());

        System.out.println("=====================================================");

        /*9*/
        List<String> topNames2021 = Arrays.asList(
                "Amelia", "emily", "Isla",
                "Olivia", "Ava", "oliver",
                "Jack", "Charlie", "harry",
                "Jacob");
        List<String> firstUpperCase = new ArrayList<>();
        topNames2021.forEach(name -> {
           char s1 = name.toUpperCase().charAt(0);
           firstUpperCase.add(s1+name.substring(1));
           firstUpperCase.sort((s3, s2) -> s3.compareTo(s2));
            System.out.println(s1 + name.substring(1));
            System.out.println("===========================");
            firstUpperCase.forEach(s -> System.out.println(s));
        });

        System.out.println("===========================");

        /*Q10*/
        topNames2021
                .stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("===========================");

        topNames2021.sort(String::compareTo);
        topNames2021.forEach(System.out::println);


    }

    /*Q4*/
 /*A*/   private static void everySecondChar(String apply) {
        System.out.println(apply);
    }

 /*B*/   public static String everySecondChar(Function<String, String> func){
        return func.apply("1234567890");
    }


}
