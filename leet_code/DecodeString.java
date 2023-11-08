package leet_code;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '[') {
                int numberInt = Character.getNumericValue(stack.pop());

                int countDigit = i + 1;
                for (int j = 0; j < numberInt; j++) {
                    if(s.charAt(countDigit) == ']' || Character.isDigit(s.charAt(countDigit))) {
                        continue;
                    }
                    stack.push(s.charAt(countDigit));
                    countDigit++;
                }
            } else if(Character.isDigit(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {

            }
            
        }

        StringBuffer result = new StringBuffer();

        for (Character character : stack) {
            result.append(character);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        System.out.println(decodeString(input));
    }
}
