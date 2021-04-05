public class NumberOfDaysInMonth {

    public static boolean isLeapYear(int year){
        if (year < 1 || year > 9999){
            return false;
        }else if(year % 4 == 0 && year % 100 != 0){
            return true;
        }
        final boolean finish = year % 100 == 0 && year % 400 == 0;
        return finish;
    }

    public static int getDaysInMonths(int month, int year){
        if ((month < 1 || month > 12) || (year < 1 || year > 9999)){
            return -1;
        }else if (isLeapYear(year)){
            if ((month == 4 || month == 6 || month == 9 || month ==11)){
                return 30;
            }else if ((month == 2 )){
                return 29;
            }else {
                return 31;
            }
        }
        else if ((month == 4 || month == 6 || month == 9 || month ==11)){
            return 30;
        }else if(month == 2){
            return 28;
        }
        return 31;
    }
}
