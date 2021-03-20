package com.company;

class Car{
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
    }

    public void startEngine(int speed){
        System.out.println("Starting engine at: " + speed);
    }

    public int accelerate(int speedNumber){
        speedNumber *= 4;
        return speedNumber;
    }

    public void breakEngine(int number){
        number *= 0;
        accelerate(number);
        System.out.println("Car is now stopping: ");
    }


    public String getName() {
        return name;
    }

    public boolean getEngine() {
        return true;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }
}

class Pegeout extends Car{
    public Pegeout(){
        super("Pegeout-208", 2);
    }

    @Override
    public void startEngine(int speed) {
        super.startEngine(45);
    }

    @Override
    public int accelerate(int speedNumber) {
        return super.accelerate(20);
    }

    @Override
    public void breakEngine(int number) {
        super.breakEngine(100);
    }
}

class Toyota extends Car{
    public Toyota(){
        super("Toyota", 3);
    }

    @Override
    public int accelerate(int speedNumber) {
        return super.accelerate(speedNumber);
    }

}

class Ford extends Car{
    public Ford(){
        super("Ford-focus", 2);
    }

    @Override
    public void startEngine(int speed) {
        super.startEngine(59);
    }

    @Override
    public void breakEngine(int number) {
        super.breakEngine(10);
    }

}







public class Main {

    public static void main(String[] args) {
	// write your code here
        int speed = 56;
        for (int i = 1; i < 5; i++){
            Car car = randomCar();
            System.out.println("Car number: " + i + "# " + "\n" + car.getWheels());
            car.startEngine(i);
            System.out.println();
            car.accelerate(speed);
            car.breakEngine(i);
        }

    }

    public static Car randomCar(){
        int randomNumber = (int)(Math.random() * 3) + 1;
        System.out.println("Random number generated is: " + randomNumber + "#");

        switch (randomNumber){
            case 1:
                return new Ford();

            case 3:
                return new Pegeout();

            case 2:
                return new Toyota();
        }
        return null;
    }
}
