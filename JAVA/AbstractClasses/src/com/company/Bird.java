package com.company;

public abstract class Bird extends Animal implements CanFly{

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is now eating");
    }

    @Override
    public void breath() {
        System.out.println("Breath in!\n" +
                "Breath out!\n" +
                "Repeat");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flapping its wing");
    }
}
