public class Main {
    public static void main(String[] args) {
        var result = sumDigit(21);
        System.out.println(result);
    }

    private static int sumDigit(int number){
        if (number >= 10){
            int sum = 0;
            // Extract the least significant digit from the variable "number"
            while (number > 0){
                int digit = number % 10;
                sum += digit;

                // Drop the least significant digit
                number /= 10;
            }
            return sum;


        }
        return -1;
    }
}
