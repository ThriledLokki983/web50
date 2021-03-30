package com.company;

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
    }
}
