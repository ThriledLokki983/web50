package com.company;

import static org.junit.Assert.assertEquals;

public class Main {

    public static void main(String[] args) {
        String just = "AABCDDEFF";
        Utilities newUtilities = new Utilities();
       newUtilities.removePairs(just);
    }
}
