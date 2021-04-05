package com.company;

public class Dog extends Animal {
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    // Here we extends on the base Animal class and still add the features unique to the Dog class
    public Dog(String name, int body, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, body, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew(){
        System.out.println("Dog.chew() called");
    }

    public void walk(int speed){
        System.out.println("Animal is moving at " + speed + "mph");
        move();
    }

    private void run(){


    }

    @Override
    public void eat() {
        //System.out.println("dog.eat() called ");
        chew();
        super.eat();
    }

    private void moveLegs(){
        System.out.println("Dog.moveLeg() called");
    }

    @Override
    public void move() {
        //System.out.println("Dog.move() called ");
        moveLegs();
        super.move();
    }
}
