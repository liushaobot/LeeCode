/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; ++i)
            dp[i][0] = 1;
        for (int i = 1; i < n; ++i)
            dp[0][i] = 1;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
    
    public int uniquePaths2(int m, int n) {
        // Compute C((m-1)+(n-1), (m-1))
        m--; n--;
        int mn = m + n;
        double ans = 1;
        for(int i=0;i<m;i++)
            ans = ans * ((double)(mn - i) / (m-i));
        return (int)Math.round(ans);
    }
}