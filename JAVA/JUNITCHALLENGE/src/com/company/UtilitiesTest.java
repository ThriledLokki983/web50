package com.company;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities newUtilities;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("Starting test......");
    }

    @org.junit.Before
    public void setup(){
        newUtilities = new Utilities();
    }


    @org.junit.Test
    public void everyNthChar() {
        char[] array = {'h', 'e', 'l', 'l', 'o'};
        char[] array1 = {};
        assertArrayEquals(new char[]{'e','l'}, newUtilities.everyNthChar(array, 2));
        assertArrayEquals(new char[]{}, newUtilities.everyNthChar(array1, 2));
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, newUtilities.everyNthChar(array, 8));
    }

    @org.junit.Test
    public void removePairs_first() {
        assertEquals("ABCDEF", newUtilities.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", newUtilities.removePairs("ABCCABDEEF"));
        assertEquals("A", newUtilities.removePairs("A"));
        assertEquals("", newUtilities.removePairs(""));
        //assertNull("Null Input", newUtilities.removePairs(null));
    }


    @org.junit.Test
    public void converter() {
        assertEquals(300, newUtilities.converter(10, 5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_byZero() throws ArithmeticException {
        newUtilities.converter(10, 0);
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertEquals("Gideon", newUtilities.nullIfOddLength("Gideon"));
        assertNull("Null Result", newUtilities.nullIfOddLength("tip"));
        assertNotNull("This is  not Null", newUtilities.nullIfOddLength("Gideon"));
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("Testing Completed");
    }
}