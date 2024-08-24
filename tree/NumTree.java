package tree;

/*
 * Concept: tree
 * Problem: 96
 * Level: Medium
 * Idea: Dynamic Programing
 */
public class NumTree {
    public static int numTrees(int n) {
        int dp[] = new int[n + 1];

        // base case
        dp[0] = 1;
        dp[1] = 1;

        // build table result
        int nodeLefts, nodeRights;
        for (int i = 2; i < n + 1; i++) {
            for(int j = 1; j < i + 1; j++) {
                nodeLefts = j - 1;
                nodeRights = i - j;
                dp[i] += dp[nodeLefts] * dp[nodeRights];
                System.out.println(dp[j]);
            }
            System.out.println(dp[i]);
            
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Num BST for" + n + ": " + numTrees(3));
    }
}
