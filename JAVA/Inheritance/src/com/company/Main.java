package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Animal animal = new Animal("Animal", 3, 4, 5, 56);
        System.out.println("Weight = " + animal.getName());

        Dog dog = new Dog("Yorkie", 4, 5, 89, 45, 23, 45, "Long silky");
        dog.eat();
        //System.out.println("Dog name = " + dog.getName());
        dog.walk(6);
        //dog.move();

        Fish fish = new Fish("Salmond", 45, 4, 2, 45, 89);
        fish.swim();
    }

    // A house Analogy

    // Class is the blueprint for a house (plan)
    // Each house built/instantiated is an OBJECT also known as INSTANCE
    // Each house built has an address which is known as a REFERENCE
    // Reference can be copied as many times as you like
    // We can pass REFERENCES as PARAMETERS to CONSTRUCTORS and METHODS

}
