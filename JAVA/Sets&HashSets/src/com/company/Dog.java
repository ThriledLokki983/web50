package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/30/21
 * Time: 4:45 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj instanceof Dog){
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }

    public String getName() {
        return name;
    }


}
