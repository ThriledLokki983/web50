package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{2,5}", "YYY" ));
        System.out.println("============================");
        System.out.println(thirdAlphanumeric.replaceAll("h+i*j", "X")); /* H followed by zero or more i then followed by j*/
        System.out.println("============================");

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-Heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else. </p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String hPattern = ".*<h2>.*";
        String h2Pattern = "<h2>"; /* Group method */
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches()); /* reset matcher before we use it again */

        System.out.println("============================");

        matcher.reset();
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("Occurrence " + count + ": " + matcher.start() + " to " + matcher.end());
        }

        System.out.println("============================");

        String h2GroupPatter = "(<h2>)";
        String h2GroupPattern1 = "(<h2>.*</h2>)"; /* Greedy quantifier */
        String h2GroupPattern = "(<h2>.+?</h2>)"; /* Lazy quantifier */
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()){
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }
        System.out.println("============================");
        String h2TextGroup = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroup);
        Matcher textMatcher = h2TextPattern.matcher(htmlText);
        System.out.println(textMatcher.matches());
        textMatcher.reset();

        while (textMatcher.find()){
            System.out.println("Occurrence: " + textMatcher.group(2));
        }
        System.out.println("============================");

    }
}
