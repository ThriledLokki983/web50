package com.company;

public class Main {

    public static void main(String[] args) {

        // In terms of precision, double is preferred to float. However, when precision is paramount,
        // BigDecimal is rather the preferred primitive type

        // FLOAT
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;

        System.out.println(myMinFloatValue);
        System.out.println(myMaxFloatValue);

        // DOUBLE
        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;

        System.out.println(myMinDoubleValue);
        System.out.println(myMaxDoubleValue);


        int myIntValue = 5 / 3;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5d / 3d;
        System.out.println(myIntValue);
        System.out.println(myFloatValue);
        System.out.println(myDoubleValue);

        // Double Challenge ==> convert pounds into kilograms (1 pound = 0.45359237)
        double pound = 0.45359237d;
        double kilos = 200d;
        double kiloConversion = (double) (kilos * pound );
        System.out.println("Kilos: " + kiloConversion);


    }
}
