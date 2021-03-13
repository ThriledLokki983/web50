public class Main {
    public static void main(String[] args) {

        var count = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++){
            if (gotIt(i)){
                count++;
                System.out.println(i + " is the number");
                if (count == 5){
                    System.out.println("Exiting the loop");
                    break;
                }
            }
        }
    }

    public static boolean gotIt(int x){
        if((x % 3) == 0 && (x % 5) == 0){
            return true;
        }
        return false;
    }
}
