package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 11:06 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
