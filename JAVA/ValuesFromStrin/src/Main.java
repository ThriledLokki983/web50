public class Main {
    public static void main(String[] args) {
        String numberString = "2018";
        System.out.println("Number as String = " + numberString);

        int number = Integer.parseInt(numberString);
        System.out.println("Number = " + number);

        numberString += 1;
        number += 1;
        System.out.println("Number is now = " + numberString);
        System.out.println("Number is now = " + number);
    }
}
