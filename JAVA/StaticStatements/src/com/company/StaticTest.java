package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 3:56 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class StaticTest {
    private  static int numInstances = 0;
    private  String name;


    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }
}
