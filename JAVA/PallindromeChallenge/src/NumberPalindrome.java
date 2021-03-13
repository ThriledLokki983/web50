public class NumberPalindrome {
    public static boolean isPalindrome(int number){
        // A Palindrome is a number which when reversed is the same as the original number
        // Final logic = compare number to reverse
        int originalNumber = number;
        int reverse = 0;
        while(number != 0){
            int digit = number % 10;
            reverse += digit;
            reverse *= 10;
            number /= 10;
        }
        if ((reverse / 10) == originalNumber){
            return true;
        }
//        System.out.println(reverse / 10);
//        System.out.println(originalNumber);
        return false;
    }
}
