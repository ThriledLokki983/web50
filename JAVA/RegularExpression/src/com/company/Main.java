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

        /* "abc" == "a" and "b" and "c" */
        System.out.println("harry".replaceAll("[H|h]arry", "Larry")); /* Harry with a capital H OR a small h */
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        /*
        * [^abc] ==> Every occurrence in the text except abc (NOT OPERATOR)
        * */

        String tcText = "tstvtkt";
        String tNotV = "t[^v]"; /* consumes characters */
        String tNotV1 = "t(?!v)"; /* Look ahead syntax and does not consume characters they match */ /* Negative Look ahead syntax */
        /* t(?=v) */ /* Positive Look ahead syntax */
        /* ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$ */
        Pattern tNotVPattern = Pattern.compile(tNotV1);
        Matcher tNotVMatcher = tNotVPattern.matcher(tcText);

        count = 0;
        while (tNotVMatcher.find()){
            count++;
            System.out.println("Occurrence: " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        System.out.println("============================");
        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)456-7890";
        System.out.println("Phone 1: " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$")); /* Validating a USA number */
        System.out.println("Phone 2: " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("Phone 3: " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("Phone 4: " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        System.out.println("============================");
        /* Validating a VISA card with Regex */
        /* ^4[0-9]{12}([0-9]{3})?$ */

        String visa1 = "4444444444444";
        String visa2 = "54444444444444444";
        String visa3 = "4444444444444444";
        String visa4 = "4444";

        System.out.println("Visa 1: " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("Visa 2: " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("Visa 3: " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("Visa 4: " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));


        System.out.println("============================");

        /* CHALLENGES */

        /*Q1*/
        String challenge = "I want a bike.";
        System.out.println(challenge.matches("I want a bike."));

        System.out.println("============================");

        /*Q2*/
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        System.out.println(challenge1.concat(challenge2).matches("I want a bike.I want a ball."));
        String regExp = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));

        System.out.println("============================");
       /* Q3 */
        String regExp3 = "I want a \\w+.";
        Pattern thePattern = Pattern.compile(regExp3);
        Matcher theMatcher = thePattern.matcher(challenge1);
        System.out.println(theMatcher.matches());
        Matcher theMatcher1 = thePattern.matcher(challenge2);
        System.out.println(theMatcher1.matches());

        System.out.println("============================");
        /*Q4*/

        String challenge4 = "Replace all banks with underscores";
        System.out.println("Solution 1: " + challenge4.replaceAll(" ", "_"));
        System.out.println("Solution 5: " + challenge4.replaceAll("\\s", "_"));


        System.out.println("============================");
        /* Q5 */

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println("Solution: " + challenge5.matches("\\w+"));
        System.out.println("Solution: " + challenge5.matches("[abcdefg]+"));
        System.out.println("Solution: " + challenge5.matches("[a-g]*"));
        System.out.println("Solution: " + challenge5.matches("[a-g]+"));


        System.out.println("============================");
        /* Q6 */
        System.out.println("Solution: "+ challenge5.matches("aaabccccccccdddefffg"));
        System.out.println("Solution: "+ challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println("Solution: "+ challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        System.out.println("============================");
        /*Q7*/
        // ^[a-z]{4}[\\.]{1}[0-9]{3}
        // ^[A-z][a-z]+\\.\\d+$
        String challenge7 = "abcd.135";
        String test = "f5.12a";
        System.out.println(challenge7.matches("^[a-z]{4}[\\.]{1}[0-9]{3}"));
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));
        System.out.println(test.matches("^[A-z][a-z]+\\.\\d+$"));
        System.out.println(test.matches("^[a-z]{4}[\\.]{1}[0-9]{3}"));


        System.out.println("============================");
        /*Q8*/
        String challenge8 = "abcd.125uvqz.7tzik.999";
        String digitPattern = "[A-Za-z]+\\.(\\d+)";
        Pattern pattern8 = Pattern.compile(digitPattern);
        Matcher matcher8 = pattern8.matcher(challenge8);
        while (matcher8.find()){
            System.out.println("Occurrence: " + matcher8.group(1));
        }


        System.out.println("============================");
        /*Q9*/
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        String challenge9Pattern = "[A-Za-z]+\\.(\\d+)\\s";
        Pattern pattern9 = Pattern.compile(challenge9Pattern);
        Matcher matcher9 = pattern9.matcher(challenge9);
        while(matcher9.find()){
            System.out.println("Occurrence: " + matcher9.group(1));
        }



        System.out.println("============================");



    }
}
