package com.company;

import static org.junit.Assert.assertEquals;

public class Main {

    public static void main(String[] args) {

        Utilities newUtilities = new Utilities();

        char[] array = {'h', 'e', 'l', 'l', 'o'};
        int n = 2;
        char[] newChar = {'e', 'l'};
        String newString = "el";
        System.out.println(newUtilities.everyNthChar(array, n));
        assertEquals(newChar.toString(), newUtilities.everyNthChar(array, n));
    }
}
