public class InterestRateCalculator {
    public static double calculateInterest(double amount, double interestRate){
        return(amount * (interestRate/100));
    }

    public static boolean isPrime(int n){
        if (n == 1){
            return false;
        }
        for (int i = 2; i <= n/2; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
