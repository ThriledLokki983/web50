import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Get user input with the new Scanner to create an instance of scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter year of Birth");
        boolean hasInt = scanner.hasNextInt();
        if (hasInt){
            int yearOfBirth = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        int age = 2021 - yearOfBirth;

        if (age >= 0 && age <= 100){
            System.out.println("Hello " + name + ", you are " + age + " years old.");
        }
        else{
            System.out.println("Invalid age!");
        }

        scanner.close();
        }else{
            System.out.println("Invalid birth year!");
        }
    }
}

