/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class Solution {
    public static final int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] cache = new int[rows][cols];
        int result = Integer.MIN_VALUE;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                result = Math.max(result, helper(matrix, cache, row, col, rows, cols));
            }
        }

        return result;
    }

    public int helper(int[][] matrix, int[][] cache, int row, int col, int rows, int cols) {
        if (cache[row][col] != 0) return cache[row][col];
        int result = 1;
        for (int[] dir : dirs) {
            int x = row + dir[0], y = col + dir[1];
            if(x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] <= matrix[row][col]) continue;
            int len = 1 + helper(matrix, cache, x, y, rows, cols);
            result = Math.max(result, len);
        }
        cache[row][col] = result;
        return result;
    }