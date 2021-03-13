public class Main {
    public static void main(String[] args) {
        // Switch
        // This is good for testing the same variable with the same value

        int switchValue = 3;

        switch (switchValue){
            case 1:
                System.out.println("Value is 1");
                break;
            case 2:
                System.out.println("Value is 2");
                break;
            default:
                System.out.println("Value is neither 1 or 2");
                break;
        }
    }
}
