public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour){
        if(kilometersPerHour < 0){
            return -1;
        }
        long milesPerHour = Math.round(kilometersPerHour / 1.69);
        return milesPerHour;
        // return Math.round(kilometersPerHour / 1.69);
    }

    public static void printConversion(double kilometerPerHour){
        if (kilometerPerHour < 0){
            System.out.println("Invalid value");
        }else{
            long milesPerHour = toMilesPerHour(kilometerPerHour);
            System.out.println(kilometerPerHour + " km/h= " + milesPerHour + " mi/h");
        }

    }

}
