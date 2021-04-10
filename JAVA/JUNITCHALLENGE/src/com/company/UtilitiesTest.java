package com.company;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @org.junit.Test
    public void everyNthChar() {
        fail("failed");
    }

    @org.junit.Test
    public void removePairs_first() {
        String just = "AABCDDEFF";
        Utilities newUtilities = new Utilities();
        assertEquals("ABCDEF", newUtilities.removePairs(just));
    }

    @org.junit.Test
    public void removePairs_second() {
        String just = "ABCCABDEEF";
        Utilities newUtilities = new Utilities();
        assertEquals("ABCABDEF", newUtilities.removePairs(just));
    }

    @org.junit.Test
    public void converter() {
        fail("failed");
    }

    @org.junit.Test
    public void nullIfOddLength() {
        fail("failed");
    }
}