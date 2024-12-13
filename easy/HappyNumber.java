package easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappyV0(int n) {
        // base case
        if(n == 1 || n == 7) {
            System.out.println("Into base case!!");
            return true;
        }

        System.out.println("Not into base case!!");
        while(n >= 10) {
            n = squareDigit(n);
        }

        return n == 1 || n == 7;
    }

    public static boolean isHappyV1(int n) {
        // base case
        if(n == 1 || n == 7) {
            return true;
        }

        Set<Integer> seen = new HashSet<Integer>();
        while(n != 1 || n != 7) {
            if(seen.contains(n)) {
                return false; // lặp lại chu kì
            }
            seen.add(n);
            n = squareDigit(n);
        }
        return true;
    }

    private static int squareDigit(int number) {
        System.out.println("Into squareDigit");
        int sumSquare = 0;
        int resident;
        while(number >= 1) {
            resident = number % 10;
            sumSquare += resident * resident;
            number = number / 10;
        }
        return sumSquare;
    }

    public static void main(String[] args) {
        int number = 19;
        System.out.println("Sum of digit: " + squareDigit(number)); // expect 2
        System.out.println("Check happy number " + isHappyV1(number));
    }
}
