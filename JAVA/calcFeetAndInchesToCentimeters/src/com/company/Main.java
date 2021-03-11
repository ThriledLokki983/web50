package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var cent = calcFeetAndInchesToCentimeters(40);
        var centimeter = calcFeetAndInchesToCentimeters(20,3);
//        System.out.println(cent);
//        System.out.println(centimeter);

    }

    public static int calcFeetAndInchesToCentimeters(int feet, int inches){
        if (feet >= 0 && (inches >=0 || inches <= 12)){
            // 1 foot == 12-inches && and 1-foot ==2.54cm
            double newFeet = feet / 2.54;
            double totalCentimeter = newFeet + (double)inches;
            System.out.println(feet+ "ft" + " & " + inches + "inches" + " = " + totalCentimeter);

        }
        return -1;
    }

    public static int calcFeetAndInchesToCentimeters(int inches){
        if (inches >= 0){
            // 1-inch == 2.54
            double newInchesToCentimeter = inches * 2.54;
            System.out.println(inches + "inches = " + newInchesToCentimeter);
        }
        return -1;
    }
}
