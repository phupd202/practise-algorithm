package leet_code;
/*
 * Problem: https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 */

public class DivisorString {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public static String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int gcd = findGCD(m, n); // độ dài của xâu cần trả về 

        String divisorString = str2.substring(0, gcd);

        String newStr1 = "";
        for (int i = 0;i < str1.length() / gcd; i++) {
            newStr1 += divisorString;
        }

        String newStr2 = "";
        for (int i = 0; i < str2.length() / gcd; i++) {
            newStr2 += divisorString;
        }

        if(newStr1.equals(str1) && newStr2.equals(str2)) {
            return divisorString;
        }
        return "";
    }

    public static void main(String[] args) {
        String result = gcdOfStrings("ABABAB", "ABC");
        System.out.println(result);
    }
    
}
