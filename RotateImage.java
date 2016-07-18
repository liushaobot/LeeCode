/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

/**
 * Created by shaobo on 2016/7/18.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length>>1; ++i) {
            for (int j = i; j<length-i-1; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length-j-1][i];
                matrix[length-j-1][i] = matrix[length-i-1][length-j-1];
                matrix[length-i-1][length-j-1] = matrix[j][length-i-1];
                matrix[j][length-i-1] = tmp;
            }
        }
    }
}
