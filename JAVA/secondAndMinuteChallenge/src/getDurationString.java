public class getDurationString {
    public static double durationString(double numberOne, double numberTwo){
        if ((numberOne >= 0) && (numberTwo >= 0 || numberTwo <= 59)){
            double totalMinutes = numberOne + (numberTwo * 0.0166667);
            double hours = (int) totalMinutes / 60;
            double minutes = (int) (totalMinutes % 60);
            double seconds = minutes % 60;
            // print format XXh YYm ZZs

            String hoursString = (int)hours + "h";
            if (hours < 10){
                hoursString = "0" + hoursString;
            }

            String minutesString = (int)minutes + "m";
            if (minutes < 10){
                minutesString = "0" + minutesString;
            }

            String secondsString = (int)seconds + "s";
            if (seconds < 10){
                secondsString = "0" + secondsString;
            }

            System.out.println( hoursString + " " + minutesString + " " + secondsString);

        }
        //System.out.println("Invalid Value");
        return -1;
    }

    public static double durationString(double numberTwo){
        if (numberTwo >= 0){
            double minutes = (int)numberTwo / 60;
            double seconds = (int)numberTwo % 60;
            durationString(minutes, seconds);
        }
        //System.out.println("Invalid Value");
        return -1;

    }
}
