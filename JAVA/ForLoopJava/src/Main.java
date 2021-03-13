public class Main {
    public static void main(String[] args) {
        // System.out.println("10,000 at 2% interest = " + InterestRateCalculator.calculateInterest(10000.0,
         //       2.0));

        // For Loop / Statement ==> repeatedly loops until a condition is satisfied
        // for(init; termination; increment){
        //      the code to execute
        // }

//        for (int i = 2; i < 9; i++){
//            System.out.println("10,000 at " +  i + "% interest = " +
//                    String.format("%.2f", InterestRateCalculator.calculateInterest(10000.0, i)));
//        }
//
//        System.out.println("##############################");
//
//        for (int i = 8; i >= 2; i--){
//            System.out.println("10,000 at " +  i + "% interest = " +
//                    String.format("%.2f", InterestRateCalculator.calculateInterest(10000.0, i)));
//        }
//
//        System.out.println("##############################");

        var result = InterestRateCalculator.isPrime(6);
        if (!result){
            System.out.println("This is not a Prime Number");
        } else {
            System.out.println("This is a Prime Number");
        }
        var primeFoundCount = 0;
        for (int i = 10; i < 100; i++){
            var res = InterestRateCalculator.isPrime(i);
            if (res){
                primeFoundCount++;
                System.out.println(i + " is a prime number");
                if (primeFoundCount == 5){
                    System.out.println("Exiting loop");
                    break;
                }
            }
        }
        System.out.println("##############################");
        System.out.println(primeFoundCount + " Prime Numbers were found");

    }
}
