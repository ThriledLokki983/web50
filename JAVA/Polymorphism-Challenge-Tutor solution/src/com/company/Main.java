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

 class Opel extends Car{
    public Opel(int cylinder, String name) {
        super(cylinder, name);
    }

    @Override
    public String startEngine() {
        return "Opel -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Opel -> accelerate()";
    }

    @Override
    public String brake() {
        return "Opel -> brake()";
    }
}

class Toyota extends Car{
    public Toyota(int cylinder, String name) {
        super(cylinder, name);
    }

    @Override
    public String startEngine() {
        return "Toyota -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Toyota -> accelerate()";
    }

    @Override
    public String brake() {
        return "Toyota -> brake()";
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
        com.company.Toyota ford = new com.company.Toyota(4, "Toyota Corola");
        System.out.println(ford.accelerate());
        System.out.println(ford.startEngine());
        System.out.println(ford.brake());

        System.out.println("######");
        Opel opel = new Opel(4, "Opel Astra");
        System.out.println(opel.accelerate());
        System.out.println(opel.startEngine());
        System.out.println(opel.brake());
    }

}