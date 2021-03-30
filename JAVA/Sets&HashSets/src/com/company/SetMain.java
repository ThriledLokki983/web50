package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Name: Gideon Nimoh
 * Date: 3/30/21
 * Time: 4:56 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are " + squares.size() + " squares\n" + "There are " + cubes.size() + " cubes\n");
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersect contains " + intersection.size() + " elements");
        for (int i : intersection){
            System.out.println(i + " is a square of " + Math.sqrt(i) + " and cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "The quick brown fox jumps over the lazy wall";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for (String s : words){
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWord = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        String[] divineWord = {"to", "err", "is", "is", "human", "to", "forgive", "is", "is", "divine"};

        nature.addAll(Arrays.asList(natureWord));
        divine.addAll(Arrays.asList(divineWord));

        System.out.println("Nature - Divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("Divine - Nature ");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> union1 = new HashSet<>(nature);
        union1.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        System.out.println("All words together: ");
        printSet(union1);
        System.out.println("Symmetric Difference: ");
        printSet(intersectionTest);


    // BULK
        if (nature.containsAll(divine)){
            System.out.println("Divine is a subset of Nature: ");
        }else{
            System.out.println("Not happening");
        }
        if (nature.containsAll(intersectionTest)){
            System.out.println("Intersection is a subset of Nature: ");
        }
        if (divine.containsAll(intersectionTest)){
            System.out.println("Intersection is a subset of Divine: ");
        }


    }

    public static void printSet(Set<String> something){
        for (String i : something){
            System.out.print("\t" + i);
        }
        System.out.println();
    }

}
