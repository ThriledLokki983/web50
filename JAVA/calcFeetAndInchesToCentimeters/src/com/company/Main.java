package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
         calcFeetAndInchesToCentimeters(100);
        //calcFeetAndInchesToCentimeters(8,4);
//        System.out.println(cent);
//        System.out.println(centimeter);

    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if (feet >= 0 && (inches >=0 || inches <= 12)){
            // 1 foot == 12-inches && and 1-foot == 2.54cm
//            double newFeet = (feet * 12) * 2.54;
//            double newInches = inches * 2.54;
//            double totalCentimeter = newFeet + newInches;
            double centimeter = (feet * 12) * 2.54;
            centimeter += (inches * 2.54);

            System.out.println(feet+ "ft" + " & " + inches + "inches" + " = " + (int) centimeter + "cm");
            return centimeter;
        }
        System.out.println("Invalid Feet or Inches");
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        if (inches >= 0){
            // 1-inch == 2.54
            double feet = (int) inches / 12;
            double inchesRemainder = (int) inches % 12;
//            double newInchesToCentimeter = inches * 2.54;
//            System.out.println(inches + "inches = " + newInchesToCentimeter);
            System.out.println(inches + "inches = " + feet + "ft and " + inchesRemainder + "inches");
            var result = calcFeetAndInchesToCentimeters(feet, inchesRemainder);

        }
        return -1;
    }
}
