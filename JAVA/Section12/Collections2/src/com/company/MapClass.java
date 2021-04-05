package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: Gideon Nimoh
 * Date: 3/29/21
 * Time: 7:59 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class MapClass {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "Compiled high level, object-oriented, platform independent language");
        languages.put("Python", "Compiled high level, object-oriented, programming language");
        languages.put("BASIC", "Beginners All Purpose Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");
        languages.put("BASIC", "Lets see if you will be overwritten");

        if (languages.containsKey("BASIC")){
            System.out.println("It already exist");
        }else{
            System.out.println(languages.get("BASIC"));
        }

        System.out.println("==========================================================================");
        System.out.println(languages.replace("Lisp", "A functional language with imperative style"));
        System.out.println(languages.replace("Scala", "This will be replace"));

        for (String key : languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }


        // languages.remove("Lisp");
    }

}
