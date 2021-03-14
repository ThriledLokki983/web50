public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2){
        if ((num1 < 10 || num1 > 99) || (num2 < 10 || num2 > 99)){
            return false;
        }

        int helpNum = num1 % 10;
        while(num1 > 0 && num2 > 0){
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            if ((helpNum == digit2) || (digit1 == digit2)){
                return true;
            }
            num1 /= 10;
            num2 /= 10;
        }
        return false;
    }
}
