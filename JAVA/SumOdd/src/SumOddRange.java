public class SumOddRange {
    public static boolean isOdd(int number) {
        if (number < 0) {
            return false;
        }
        return number % 2 == 1;
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if ((start < 0) || (end < 5)) {
            return -1;
        }
        for (int i = start; i <= end; i++){
            if (isOdd(i)){
                sum += i;
            }
        }
        return sum;
    }
}
