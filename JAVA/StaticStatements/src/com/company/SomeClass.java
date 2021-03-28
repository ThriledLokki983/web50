package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 4:13 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SomeClass {
    private static int classCounter = 0;
    public final int instanceNumber;
    private final String name;

    public SomeClass(String name) {
        classCounter++;
        instanceNumber = classCounter;
        this.name = name;
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
