/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row-1][col-1]) return false;
        int[] nums = new int[row];
        for (int i = 0; i < row; ++i) {
            nums[i] = matrix[i][0];
        }
        int resRow = Arrays.binarySearch(nums, target);
        if (resRow < 0) {
            int resCol = Arrays.binarySearch(matrix[-resRow-2], target);
            return resCol >= 0;
        } else {
            return true;
        }
    }
}
