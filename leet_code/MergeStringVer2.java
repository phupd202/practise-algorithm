package leet_code;

public class MergeStringVer2 {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int length1 = word1.length();
        int length2 = word2.length();

        for (int i = 0; i < Math.max(length1, length2); i++) {
            if(i < length1) {
                result.append(word1.charAt(i));
            }

            if(i < length2) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = mergeAlternately("abc", "pqr");
        System.out.println(result);
    }
}
