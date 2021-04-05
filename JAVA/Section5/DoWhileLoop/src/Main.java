public class Main {
    public static void main(String[] args) {
        int count = 1;
        while(count != 6){
            System.out.println("Count is now " + count);
            count++;
        }

        System.out.println("##########################");
        count = 1;
        while(true){
            if (count == 6){
                break;
            }
            System.out.println("Count is now " + count);
            count++;
        }

        System.out.println("##########################");

        count = 1;
        do {
            System.out.println("Count value was " + count);
            count++;
        }while(count != 6);

        System.out.println("##########################");

        int number = 4;
        int finishNumber = 20;
        int counter = 0;
        int sum = 0;
        while (number <= finishNumber){
            number++;
            if (!isEvenNumber(number)){
                continue; // Bypass the print statement. It will go back and start from the top if the number is valid
            }
            counter++;
            sum += number;
            // System.out.println("Even number " + number);
            if (counter == 5){
                break;
            }
        }
        System.out.println("Sum of the even numbers = " + sum);
    }


    private static boolean isEvenNumber(int x){
        if (x % 2 == 0){
            return true;
        }
        return false;
    }
}
