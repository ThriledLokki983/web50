package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "G53", "G51", "I29", "N40",
                "N36", "B6", "071", "G49", "I17", "g64",
                "G50", "B12");

        List<String> gNumbers = new ArrayList<>();
        /* Stream source must not be changed  */
        bingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted().forEach(System.out::println);
 /*       bingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
                //System.out.println(number.toUpperCase());
            }
        });
        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
        gNumbers.forEach((s) -> System.out.println(s));*/
    }
}
