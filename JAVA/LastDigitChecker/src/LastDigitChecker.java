public class LastDigitChecker {
    public static boolean hasSameLastDigit(int x, int y, int z){
        if (!(isValid(x) && isValid(y) && isValid(z))){
            return false;
        }
        return ((x % 10) == (y % 10)) || ((x % 10) == (z % 10)) || ((y % 10) == (z % 10));
    }

    public static boolean isValid(int number){
        if (number < 10 || number > 1000){
            return false;
        }
        return true;
    }
}
