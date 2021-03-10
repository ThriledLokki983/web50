public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double numberOne, double numberTwo){
        if (numberOne - numberTwo == 0){
            return true;
        }else if (numberOne < 0 || numberTwo < 0){
            return (Math.round(numberOne + Math.abs(numberTwo)) == 0.0);
        }
        return  false;
    }
}
