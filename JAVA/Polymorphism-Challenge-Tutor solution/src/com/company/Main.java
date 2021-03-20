package com.company;

class Car {
    private boolean engine;
    private int cylinder;
    private String name;
    private int wheels;

    public Car(int cylinder, String name) {
        this.cylinder = cylinder;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public String startEngine(){
        return "Car -> startEngine()";
    }

    public String accelerate(){
        return "Car -> accelerate";
    }

    public String brake(){
        return "Car -> break";
    }

    public int getCylinder() {
        return cylinder;
    }

    public String getName() {
        return name;
    }

}

class Mitsubishi extends Car{
    public Mitsubishi(int cylinder, String name) {
        super(cylinder, name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi -> accelerate()";
    }

    @Override
    public String brake() {
        return "Mitsubishi -> brake()";
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here

        Car car = new Car(8, "Opel-Astra");
        System.out.println(car.accelerate());
        System.out.println(car.startEngine());
        System.out.println(car.brake());

        System.out.println("######");
        Mitsubishi mitsubishi = new Mitsubishi(4, "Mitsubishi-Highlander");
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.brake());

        System.out.println("######");
        Toyota ford = new Toyota(4, "Toyota Corola");
        System.out.println(ford.accelerate());
        System.out.println(ford.startEngine());
        System.out.println(ford.brake());
    }
}
