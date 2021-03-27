package com.company;

public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is currently eating");
    }

    @Override
    public void breath() {
        System.out.println("Breath in!\n" +
                "Breath out!\n" +
                "Repeat");
    }
}
