package com.company;

public class Main {

    public static void main(String[] args) {
	    String string = "I am a String. Yes I am";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        System.out.println("============================");
        String alphaNumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphaNumeric);
        System.out.println(alphaNumeric.replaceAll(".", "Y"));

        System.out.println("============================");
        System.out.println(alphaNumeric.replaceAll("^abcDeee", "Y"));
        System.out.println("============================");
        System.out.println(alphaNumeric.matches("abcDeeeF12Ghhiiiijkl99z"));
        System.out.println("============================");

        System.out.println(alphaNumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println("============================");
        System.out.println(alphaNumeric.replaceAll("[aei]", "X"));
        System.out.println("============================");
        System.out.println(alphaNumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println("============================");
        System.out.println(alphaNumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("============================");
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
        System.out.println("============================");

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println("============================");
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println("============================");
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println("============================");
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println("============================");
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println("============================");
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println("============================");
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println("============================");
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));
        System.out.println("============================");

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println("============================");
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        System.out.println("============================");
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        System.out.println("============================");
        System.out.println(hasWhitespace.replaceAll("\\S", ""));
        System.out.println("============================");
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println("============================");
        System.out.println(hasWhitespace.replaceAll("\\w", "X")); /* replaces everything with X but keeps the spaces and tabs*/
        System.out.println("============================");
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));
        System.out.println("============================");

        /* QUANTIFIERS */
        String thirdAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumeric.replaceAll("^abcDeee", "YYY"));
        System.out.println("============================");
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println("============================");
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY" )); /* Followed by e then continue with replacement */
        System.out.println("============================");
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe*", "YYY" )); /* Followed by e or not then continue to replace*/
        System.out.println("============================");

    }
}
