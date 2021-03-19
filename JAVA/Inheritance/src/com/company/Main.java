package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Animal animal = new Animal("Animal", 3, 4, 5, 56);
        System.out.println("Weight = " + animal.getName());

        Dog dog = new Dog("Yorkie", 4, 5, 89, 45, 23, 45, "Long silky");
        dog.eat();
        //System.out.println("Dog name = " + dog.getName());
    }
}
