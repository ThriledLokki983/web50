package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Floor floorAreaCalc = new Floor(10, 12);
//        System.out.println("Area = " + floorAreaCalc.getArea());

        Carpert carpet = new Carpert(3.7);
        Floor floor = new Floor(5.75, 8.0);

        Calculator calculator = new Calculator(floor, carpet);
        System.out.println("Total = " + Math.round(calculator.getTotalCost()));

        Carpert newCarpet = new Carpert(4.5);
        Floor newFloor = new Floor(5.4, 8.5);
        calculator = new Calculator(newFloor, newCarpet);
        System.out.println("Total = " + Math.round(calculator.getTotalCost()));
    }
}
