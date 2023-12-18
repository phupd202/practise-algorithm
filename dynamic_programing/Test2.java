package dynamic_programing;

public class Test2 {
    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] tableResult = new int[n][n];

        // Base case
        for (int i = 0; i < n; i++) {
            tableResult[i][i] = 1;
        }

        

        for (int i = 1; i < n; i++) {
            // In case consecutive items are equal.
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

            tableResult[centerPos][centerPos + maxLen - 1] = maxLen;
        }

        // Find max length
        return findLongestPalinedrone(tableResult, s);
    }

    public static String findLongestPalinedrone(int[][] tableResult, String s) {
        int max = tableResult[0][0];
        int beginPalindone = 0;
        int endPalindrone = 0;

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

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }
}
