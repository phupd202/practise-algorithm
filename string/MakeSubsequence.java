public class MakeSubsequence {
    public static void main(String[] args) {
    }

    public static int appendCharacters(String s, String t) {


        return 0;
    }

    /*
     * coaching, coding: --> codi
     * 
     */
    /*
     * s: first string
     * t: second string
     */

    public static String findMaxSubSequence(String s, String t) {
        int maxLengtOfSubSequence = 0;
        String maxSubsequence = "";
        for (int i = 0; i < t.length(); i++) {
            int beginSubsequence = findExisted(s, t.charAt(i));

            maxLengtOfSubSequence = maxLengtOfSubSequence > maxSubsequence.length() ? maxLengtOfSubSequence : maxSubsequence.length();
            if(beginSubsequence > 0) {
                maxSubsequence += t.charAt(i);
                maxLengtOfSubSequence = 1;

                int pointer = i + 1;
                for (int j = beginSubsequence + 1; j < s.length(); j++) {
                    int nextChar = findExisted(s, t.charAt(pointer));
                    if(nextChar > beginSubsequence) {
                        maxSubsequence += s.charAt(nextChar);
                        maxLengtOfSubSequence++;
                        beginSubsequence = nextChar;
                    }
                    pointer++;
                }
            }
        }
        return maxSubsequence;
    }

    public static int findExisted(String s, char checkedChar) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == checkedChar) {
                return i;
            }
        }
        return -1;
    }

}
