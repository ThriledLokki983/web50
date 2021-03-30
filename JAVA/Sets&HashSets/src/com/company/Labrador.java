package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/30/21
 * Time: 4:47 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Labrador extends Dog{

    public Labrador(String name) {
        super(name);
    }


/**
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Labrador){
            String objName = ((Labrador) obj).getName();
            return this.getName().equals(objName);
        }
        return false;
    }
    **/
}
