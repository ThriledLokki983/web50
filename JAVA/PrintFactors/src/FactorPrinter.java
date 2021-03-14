public class FactorPrinter {
    public static void printFactors(int number){
        if (number < 1){
            System.out.println("Invalid Value");
        }
        int factor = 0;
        for (int i = 1; i <= number; i++){
            if (number % i == 0){
                factor = i;
                System.out.println(factor);
            }
        }
    }
}
