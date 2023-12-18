package dynamic_programing;

public class Test {
    public static String longestPalindrome(String s) {
        int n = s.length();

        // Store the position beginning of the longest palindromic string.
        int[][] tableResult = new int[n][n];

        // Init matrix
        for (int i = 0; i < n; i++) {
            tableResult[i][i] = 1;
        }

        // base case
        if (n > 1 && s.charAt(0) == s.charAt(1)) {
            tableResult[0][1] = 2;
        }

        // Iterate over the string from the 2nd position
        for (int i = 2; i < n; i++) {
            int centerPos = i / 2;
            int maxLen = 0;
            int back;
            int goOn;

            if (i % 2 == 0) {
                back = centerPos - 1;
                goOn = centerPos + 1;
            } else {
                back = centerPos;
                goOn = centerPos + 2;
            }

            // Ensure indices are within bounds
            while (back >= 0 && goOn < n && s.charAt(back) == s.charAt(goOn)) {
                // Expand the palindromic substring
                maxLen = tableResult[back + 1][goOn - 1] + 2;

                // Move indices towards the center
                back--;
                goOn++;
            }
            tableResult[back + 1][goOn - 1] = maxLen;
        }

        // Print table result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tableResult[i][j] + " ");
            }
            System.out.println();
        }

        // Find max length
        return findLongestPalindrone(tableResult, s);
    }

    public static String findLongestPalindrone(int[][] tableResult, String s) {
        int max = tableResult[0][0];
        int beginPalindrone = 0;
        int endPalindrone = 0;

        // Find max length
        for (int i = 0; i < tableResult.length; i++) {
            for (int j = i; j < tableResult.length; j++) {
                if (tableResult[i][j] > max) {
                    max = tableResult[i][j];
                    beginPalindrone = i;
                    endPalindrone = j;
                }
            }
        }
        return s.substring(beginPalindrone, endPalindrone + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
