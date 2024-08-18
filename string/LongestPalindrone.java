package string;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestPalindrone {
    public static int longestPalindrome(String s) {
        int len = s.length();

        int result;
        if(len == 1) {
            return result = 1;
        } else {
            HashMap<Character, Integer> frequency = countCharacter(s);
            System.out.println("Hash map result: " + frequency);
            ArrayList<Integer> values = new ArrayList<>(frequency.values());

            int idxMax = findIdxMax(values);
            result = values.get(idxMax);
            for (int i = 0; i < values.size(); i++) {
                int curFrequence = values.get(i);

                if(curFrequence % 2 == 1 && i != idxMax) {
                    result += curFrequence - 1;
                } 
            }

            if (result < len) {
                result++;
            }
        }
        return result;
    }

    public static HashMap<Character, Integer>countCharacter(String s) {
        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(!frequency.containsKey(currentChar)) {
                frequency.put(s.charAt(i), 1);
            } else {
                frequency.put(s.charAt(i), frequency.get(currentChar) + 1);
            }
        }
        return frequency;
    }

    public static int findIdxMax(ArrayList<Integer> list) {
        int idxMax = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > list.get(idxMax)) idxMax = i; 
        }
       
        return idxMax;
    }

    public static void main(String[] args) {
        String s = "a";

        System.out.println("Result: " + longestPalindrome(s));
    }
}
