package com.company;

public class Fish extends Animal {
    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int body, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, body, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    private void rest(){

    }
    private void moveMuscles(){
        System.out.println("Muscles have been moved");

    }
    private void moveBackFin(){
        System.out.println("Back fins have been moved");

    }

    public void swim(){
        System.out.println("Fish is about to swim");
        moveMuscles();
        moveBackFin();
        super.move();
    }


}
