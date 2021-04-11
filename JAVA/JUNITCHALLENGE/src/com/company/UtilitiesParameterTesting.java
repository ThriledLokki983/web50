package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Name: Gideon Nimoh
 * Date: 4/11/21
 * Time: 9:29 AM
 * To change this template use File | Settings | File and Code Templates.
 */

@RunWith(Parameterized.class)
public class UtilitiesParameterTesting {
    private Utilities newUtilities;
    private String input;
    private String output;

    @org.junit.Before
    public void setup(){
        newUtilities = new Utilities();
    }




    @org.junit.Test
    public void removePairs_first() {
        assertEquals("ABCDEF", newUtilities.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", newUtilities.removePairs("ABCCABDEEF"));
        assertEquals("A", newUtilities.removePairs("A"));
        assertEquals("", newUtilities.removePairs(""));
    }
}
