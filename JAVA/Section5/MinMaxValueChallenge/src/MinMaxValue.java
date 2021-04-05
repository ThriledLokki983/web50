import java.util.Scanner;

public class MinMaxValue {
    public static void printMinMaxValue(){
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        int num1 = 0;
        int num2 = 0;
        while(count < 3){
            System.out.println("Enter number: ");
            boolean hasInt = scanner.hasNextInt();

            if (hasInt && count == 1){
                int number = scanner.nextInt();
                count++;
                num1 += number;
                scanner.nextLine();
            }else if (hasInt && count == 2){
                int number = scanner.nextInt();
                count++;
                num2 += number;
                scanner.nextLine();
                break;
            }
        }
        if(num1 < num2 ){
            System.out.println("Min = " + num1 + ", Max = " + num2);
        }else{
            System.out.println("Max = " + num1 + ", Min = " + num2);
        }
        scanner.close();
    }

    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 1;
        double average = 0;

        while(true){
            System.out.println("Enter number: ");
            boolean hasInt = scanner.hasNextInt();

            if (hasInt){
                int number = scanner.nextInt();
                sum += number;
                count++;
                average = Math.round((double) sum/(count -1));
            }else{
                break;
            }
            scanner.nextLine();
        }
        System.out.println("SUM = " + sum + " AVG = " + (int)average);
        scanner.close();
    }
}
