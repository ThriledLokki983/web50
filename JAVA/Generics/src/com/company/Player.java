package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/27/21
 * Time: 9:10 PM
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
