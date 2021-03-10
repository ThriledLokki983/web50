public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0){
            System.out.println("Invalid Value");
        }else {
            int mega = Math.round(kiloBytes / 1024);
            int kilo = kiloBytes % 1024;
            // Print format "XX KB = YY MB and ZZ KB".
            // XX = Kilobytes
            // YY = Megabytes
            // ZZ = remaining kilobytes
            System.out.println(kiloBytes + "KB = " + mega + " MB " + "and " + kilo + " KB.");
        }
    }


}
