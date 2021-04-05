package com.company;

public class Vehicle {
    private int tyres;
    private int windscreen;
    private String type;
    private String energyType;

    public Vehicle(int tyres, int windscreen, String type, String energyType) {
        this.tyres = tyres;
        this.windscreen = windscreen;
        this.type = type;
        this.energyType = energyType;
    }

    public void move(){
        System.out.println("Vehicle.move() called: ");
    }

    public void changingGears(){
        System.out.println("Vehicle.changingGears() called: ");
    }

    public int getTyres() {
        return tyres;
    }

    public int getWindscreen() {
        return windscreen;
    }

    public String getType() {
        return type;
    }

    public String getEnergyType() {
        return energyType;
    }

    // SUPER() => use to access/call the parent class members (variables & methods) -- commonly used in method overriding when
    // we call a method with the same name from a parent class (if not we run into recursive call)
    // THIS() => use to call the current class members (variables & members) -- commonly used constructors & Setters and
    // optionally used in getters
    // This is required when we have a parameter with the same name as an instance variable(field)

    // NOTE!!!
    // both can be used anywhere in a CLASS except STATIC areas (the static block or a static method).
    // Any attempt to do so will lead to compile-time errors

    // THIS()
    // to call a constructor from another overloaded constructor in the same class
    // It can only be used in a constructor and must be the first statement in a constructor.
    // It is used with constructor chaining / when one constructor calls another constructor, and helps to reduce duplicated code


    // SUPER()
    // The only way to call a parent constructor is by calling super(). This calls the parent constructor
    // Super() is called by the compiler by default if we don'' add it, and it is always the non-args super
    // which is inserted by the compiler
    // the super() must be the first statement in each constructor
    // An Abstract class is a super class, so its constructor can run when someone makes an instance of a concrete subclass
    //

    // NOTE!!!
    // A constructor can have a call to super() or this() but never both
}
