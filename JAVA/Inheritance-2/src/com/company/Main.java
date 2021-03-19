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
}
