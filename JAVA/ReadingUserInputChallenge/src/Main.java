import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        int sum = 0;
        while(count < 11){
            System.out.println("Enter number #" + count);
            boolean hasInt = scanner.hasNextInt();
            if (hasInt){
                int number = scanner.nextInt();
                count++;
                sum += number;
                scanner.nextLine();
            }
        }
        System.out.println();
        System.out.println("The sum of all your numbers = " + sum);
    }
}
