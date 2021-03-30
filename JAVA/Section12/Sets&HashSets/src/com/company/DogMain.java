package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/30/21
 * Time: 4:49 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
    }
}
