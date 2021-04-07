package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 4/7/21
 * Time: 4:11 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SharedResource {
    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
