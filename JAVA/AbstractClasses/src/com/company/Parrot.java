package com.company;

public class Parrot extends Bird{

    public Parrot(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("flitting from branch to branch");
    }
}
