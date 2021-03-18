package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Floor floorAreaCalc = new Floor(10, 12);
//        System.out.println("Area = " + floorAreaCalc.getArea());

        Carpert carpet = new Carpert(3.5);
        Floor floor = new Floor(2.75, 4.0);

        Calculator calculator = new Calculator(floor, carpet);
        System.out.println("Total = " + calculator.getTotalCost());

        Carpert newCarpet = new Carpert(1.5);
        Floor newFloor = new Floor(5.4, 4.5);
        calculator = new Calculator(newFloor, newCarpet);
        System.out.println("Total = " + calculator.getTotalCost());

    }
}
