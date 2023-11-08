package leet_code;

import java.util.Stack;

public class RemoveStart {
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuffer result = new StringBuffer();
        for (Character character : stack) {
            result.append(character);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        String result = removeStars(s);

        System.out.println(result.equals("lecoe"));
        System.out.println(result);


    }
}
