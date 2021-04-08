package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "G53", "G51", "I29", "N40",
                "N36", "B6", "071", "G49", "I17",
                "G50", "B12");

        bingoNumbers.forEach(number -> {
            if (number.startsWith("G")){
                System.out.println(number);
            }
        });
    }
}
