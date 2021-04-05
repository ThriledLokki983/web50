package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Circle circle = new Circle(3.75);
        System.out.println("Circle.radius= " + circle.getRadius());
        System.out.println("Circle.area= " + circle.getArea());

        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.println("Cylinder.radius= " + cylinder.getRadius());
        System.out.println("Cylinder.height= " + cylinder.getHeight());
        System.out.println("Cylinder.area= " + cylinder.getArea());
        System.out.println("Cylinder.volume= " + cylinder.getVolume());

    }
}
