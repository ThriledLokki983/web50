package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Wall wall = new Wall(-1.25, -1.25);
        System.out.println("Area = " + wall.getArea());

        wall.setHeight(-1.5);
        System.out.println("Width = " + wall.getWidth());
        System.out.println("Height = " + wall.getHeight());
        System.out.println("Area = " + wall.getArea());
    }
}
