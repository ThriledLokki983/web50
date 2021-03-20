package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Vehicle vehicle = new Vehicle(5, 34, "automobile", "petrol");
        System.out.println("Type = " + vehicle.getType());
        System.out.println("Tyres = " + vehicle.getTyres());

        Car car = new Car(4, 4, "Electric", "Pegeout-208", "Pegeout", 2019);
        car.changeGear();
        car.moveCar();

        Toyota toyota = new Toyota(4, 5, "Diesel", "Toyota Corola", "Corola", 2020, 45, 39987, "Salon");
        toyota.changeToyotaGear(5);
        toyota.toyotaMove();
        toyota.moveCar();
        toyota.move();
    }

    // METHOD OVERLOADING
    // Providing two or more separate methods in a class with the (same name) but (different parameters)
    // Return type may or may not be different
    // Happens inside a single class

    // METHOD OVERRIDING
    // defining a method in a child class that already exist in the parent class with the same signature (same name & args/parameters)
    // put @Override immediately above the method definition . Static methods can't be overridden, only instances
    // Only inherited methods can be overridden. Thus, overriding can only happen in child classes
    // Constructors and private methods cannot be overridden
    // Methods that are final cannot be overridden
    // A subclass can use super.methodName() to call the super class version of an overridden method

    // STATIC METHOD
    // This is declared using the static modifier
    // Can't access instance methods and instance variable directly
    // They are used for operations that do not require any data from an instance of the class (from 'this')
        // We cannot use 'this' keyword

    // INSTANCE METHODS
    // Instance Methods belong to an instance of a class
    // We will have to instantiate the class first usually by using the 'NEW' keyword in order to use the instance method
            // Instance methods can access instance methods and instance variables directly
            // It can also access static methods and static variables directly


    ///////////////////////////////////////////
    // ???????? Should a Method be STATIC
    // ???????? Does the method use any fields (Instance variables) or Instance Methods

    // YES
    // INSTANCE METHOD

    // NO
    // STATIC METHOD

}
