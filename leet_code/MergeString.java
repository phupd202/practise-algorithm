package leet_code;

public class MergeString {
    public static String mergeAlternately(String word1, String word2) {
        String result = "";

        int i = 0;
        int j = 0;
        int lengthResult = word1.length() + word2.length();

        while (result.length() < lengthResult) {
            if (i >= word1.length()) {
                result += "" +  word2.charAt(j);
                j++;
            } else if (j >= word2.length()) {
                result += "" + word1.charAt(i);
                i++;
            } else {
                result += "" + word1.charAt(i) + "" + word2.charAt(j);
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = mergeAlternately("ab", "pqrs");
        System.out.println(result);
    }
}
