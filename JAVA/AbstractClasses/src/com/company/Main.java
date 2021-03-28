package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Dog dog = new Dog("Alsatian");
        dog.eat();
        dog.breath();

        Parrot bird = new Parrot("Parrot");
        bird.eat();
        bird.breath();
        bird.fly();
        Penguin penguin = new Penguin("Emperor-Penguin");
        penguin.fly();

    }
}
