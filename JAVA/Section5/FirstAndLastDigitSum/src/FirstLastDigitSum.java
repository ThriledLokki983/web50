public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number){
        if (number < 0){
            return -1;
        }
        int lastDigit = number % 10;
        while(number > 9){
            number /= 10;
        }
        return lastDigit + number;
    }
}

// public class FirstLastDigitSum {
//    public static int sumFirstAndLastDigit(int number){
//        if (number < 0){
//            return -1;
//        }
//        int firstCount = 0;
//        int sum = 0;
//        while(number > 0){
//            firstCount = number % 10;
//
//            number /= 10;
//            sum += firstCount;
//            return number / 10 + sum;
//        }
//
//        return number + sum;
//    }
//}
