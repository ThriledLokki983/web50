public class AreaCalculator {

    public static double area(double radius){
        if (radius < 0) {
            return -1;
        } else{
            double area = (radius * radius) * 3.14159;
            System.out.println("An area of " + radius + " = " + area);
            return area;
        }

    }

    public static double area(double xPar, double yPar){
        if ((xPar < 0) || (yPar < 0)){
            return -1;
        }else{
            double area = xPar * yPar;
            System.out.println("The are of the rectangle with " + xPar + "wd & " + yPar + "ht = " + area);
            return area;
        }
    }
}
