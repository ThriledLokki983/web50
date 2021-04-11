package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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

    public UtilitiesParameterTesting(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @org.junit.Before
    public void setup(){
        newUtilities = new Utilities();
        System.out.println("Running a test...........");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][] {
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"},
                {"", ""}
        });
    }

    @org.junit.Test
    public void removePairs_first() {
        assertEquals(output, newUtilities.removePairs(input));
    }
}
