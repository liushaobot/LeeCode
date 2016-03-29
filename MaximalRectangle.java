/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

Suppose there is a 2D matrix like

1 1 0 1 0 1

0 1 0 0 1 1

1 1 1 1 0 1

1 1 1 1 0 1

First initiate the height array as 1 1 0 1 0 1, which is just a copy of the first row. Then we can easily calculate the max area is 2.

Then update the array. We scan the second row, when the matrix[1][i] is 0, set the height[i] to 0; else height[i] += 1, which means the height has increased by 1. So the height array again becomes 0 2 0 0 1 2. The max area now is also 2.

Apply the same method until we scan the whole matrix. the last height arrays is 2 4 2 2 0 2, so the max area has been found as 2 * 4 = 8.

Then reason we scan the whole matrix is that the maximum value may appear in any row of the height.

https://leetcode.com/discuss/52670/solution-based-maximum-rectangle-histogram-with-explanation
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[] height = new int[matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; ++i) {
            setHeight(matrix, height, i);
            result = Math.max(largestRectangleArea(height), result);
        }
        return result;
    }

    public void setHeight(char[][] matrix, int[] height, int row) {
        for (int i = 0; i < height.length; ++i) {
            if (matrix[row][i] == '1')
                height[i] += 1;
            else
                height[i] = 0;
        }
    }
    public int largestRectangleArea(int[] height) {
        int length = height.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] stack = new int[length];

        int ans = 0, t = 0;
        //计算L
        for (int i = 0; i < length; ++i){
            while (t > 0 && height[stack[t-1]] >= height[i]) t--;
            L[i] = (t == 0) ? 0 : (stack[t-1] + 1);
            stack[t++] = i;
        }

        //计算R
        t = 0;
        for (int i = length - 1; i >= 0; --i){
            while (t > 0 && height[stack[t-1]] >= height[i]) t--;
            R[i] = (t == 0) ? length : stack[t-1];
            stack[t++] = i;
        }

        for (int i = 0; i < length; ++i){
            ans = Math.max(ans, height[i] * (R[i] - L[i]));
        }
        return ans;
    }
}
