public class SumOddRange {
    public static boolean isOdd(int number) {
        if (number < 0) {
            return false;
        }
        return number % 2 == 1;
    }

    public static int sumOdd(int start, int end) {
        int count = 0;
        int sum = 0;
        if ((start < 0) || (end < 0)) {
            return -1;
        }
        for (int i = start; i <= end; i++){
            if (isOdd(i)){
                count++;
                sum += i;
            }
        }
        return sum;
    }
}
