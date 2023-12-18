package dynamic_programing;

/*
 * Given a string s, return the longest palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
*/
public class LongestPalinedrone {
    public static String longestPalindrome(String s) {
        int n = s.length();

        // Store the position begining of longest palindrone string.
        int[][] tableResult = new int[n][n];

        // Init matrix
        for (int i = 0; i < n; i++) {
            tableResult[i][i] = 1;
        }

        // base case
        if (s.charAt(0) == s.charAt(1)) {
            tableResult[0][1] = 2;
        }

        // In case, the consecutive items equals
        int specialMaxLength = 0;
        int endMaxLength = 0;
        
        for (int i = 0; i < n - 1; i++) {  // Ensure i + 1 is within bounds
            if (s.charAt(i) == s.charAt(i + 1)) {
                specialMaxLength++;
            } else {
                endMaxLength = i;
            }
        }
        tableResult[0][endMaxLength] = 1;        

        // Iterable string from 2nd position
        for (int i = 1; i < n; i++) {
            // In case, the consecutive items equals
            if (s.charAt(i - 1) == s.charAt(i)) {
                tableResult[i - 1][i] = 2;
            }

            int centerPos = i / 2;
            int maxLen = 0;
            int back;
            int goOn;

            if (i % 2 == 0) {
                back = centerPos - 1;
                goOn = centerPos + 1;
            } else {
                back = centerPos;
                goOn = centerPos + 1;
            }

            while (back >= 0 && goOn < n && s.charAt(back) == s.charAt(goOn)) {
                back--;
                goOn++;
                maxLen += 2;
            }
            tableResult[back + 1][goOn - 1] = maxLen;
        }

        // print table result
        for (int j = 0; j < tableResult.length; j++) {
            for (int j2 = 0; j2 < tableResult.length; j2++) {
                System.out.print(tableResult[j][j2]);
            }
            System.out.println();
        }

        // Find max lenght
        return findLongestPalinedrone(tableResult, s);
    }

    public static String findLongestPalinedrone(int[][] tableResult, String s) {
        int max = tableResult[0][0];
        int beginPalindone = 0;
        int endPalindrone = 0;

        // find max length;
        for (int i = 0; i < tableResult.length; i++) {
            for (int j = i; j < tableResult.length; j++) {
                if (tableResult[i][j] > max) {
                    max = tableResult[i][j];
                    beginPalindone = i;
                    endPalindrone = j;
                }
            }
        }
        return s.substring(beginPalindone, endPalindrone + 1);
    }

    // print table result
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));

    }
}
