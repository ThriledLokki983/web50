public class getDurationString {
    public static double durationString(double numberOne, double numberTwo){
        if ((numberOne >= 0) && (numberTwo >= 0 || numberTwo <= 59)){
            double totalMinutes = numberOne + (numberTwo * 0.0166667);
            double hours = (int) totalMinutes / 60;
            double minutes = (int) (totalMinutes % 60);
            double seconds = minutes % 60;
            // print format XXh YYm ZZs
            System.out.println((int)numberOne + "mins, " + (int)numberTwo + "secs = " + (int)hours + "hrs " + (int)minutes
                    + "mins " + seconds + "secs" );

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
