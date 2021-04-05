

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double numberOne, double numberTwo){
        int firstNumber = (int)(numberOne * 1000);
        int secondNumber = (int)(numberTwo * 1000);
        if(firstNumber - secondNumber == 0){
            return true;
        }
        return false;
    }
//        // bdLon = bdLon.setScale(4, BigDecimal.ROUND_HALF_UP);
//        BigDecimal bdNumberOne = new BigDecimal(numberOne);
//        BigDecimal bdNumberTwo = new BigDecimal(numberTwo);
//        bdNumberOne = bdNumberOne.setScale(3, BigDecimal.ROUND_HALF_UP);
//        bdNumberTwo = bdNumberTwo.setScale(3,BigDecimal.ROUND_HALF_UP);
//        if (bdNumberOne == bdNumberTwo){
//            return true;
//        }else if (numberOne < 0 || numberTwo < 0){
//            return ((numberOne + numberTwo) == 0.0);
//        }
//        return  false;
//    }
}
