public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second){
        int greaterDivider = 0;
        if (first < 10 || second < 10){
            return -1;
        }
        for (int i = 1; i <= Math.min(first,second); i++){
            if (first % i == 0 && second % i == 0){
                greaterDivider = i;
            }
        }
        return greaterDivider;
    }
}
