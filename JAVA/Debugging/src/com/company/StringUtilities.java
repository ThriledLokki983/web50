package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 4/10/21
 * Time: 6:26 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAddded = 0;

    public void addChar(StringBuilder sBuilder, char c){
        this.sBuilder.append(c);
        charsAddded++;
    }

}
