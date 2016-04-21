/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (row == 0 || col == 0 || obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        boolean flag = true;
        for (int i = 1; i < row; ++i) {
            if (obstacleGrid[i][0] == 1)
                flag = false;
            if (flag)
                dp[i][0] = 1;
        }
        flag = true;
        for (int j = 1; j < col; ++j) {
            if (obstacleGrid[0][j] == 1)
                flag = false;
            if (flag)
                dp[0][j] = 1;
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else
                    dp[i][j] = 0;
            }
        }

        return dp[row-1][col-1];
    }
}
