package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Car car = new Car(8, "Base car");
        System.out.println(car.accelerate());
        System.out.println(car.startEngine());
        System.out.println(car.brake());

        System.out.println("######");
        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.brake());

        System.out.println("######");
        Ford ford = new Ford(4, "Ford Falcon");
        System.out.println(ford.accelerate());
        System.out.println(ford.startEngine());
        System.out.println(ford.brake());

        System.out.println("######");
        Holden holden = new Holden(4, "Holden Commodore");
        System.out.println(holden.accelerate());
        System.out.println(holden.startEngine());
        System.out.println(holden.brake());
    }
}
