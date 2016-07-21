/*
Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:
Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2
The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

Note:
The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?
*/

/**
 * Created by shaobo on 2016/7/21.
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {//By myself
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] sums = new int[rows+1][cols+1];

        for (int row = 1; row <= rows; ++row) {
            for (int col = 1; col <= cols; ++col) {
                sums[row][col] = sums[row-1][col] + sums[row][col-1] - sums[row-1][col-1] + matrix[row-1][col-1];
            }
        }

        int size, res = Integer.MIN_VALUE;
        for (int row1 = 1; row1 <= rows; ++row1) {
            for (int col1 = 1; col1 <= cols; ++col1) {
                for (int row2 = 0; row2 < row1; ++row2) {
                    for (int col2 = 0; col2 < col1; ++col2) {
                        size = sums[row1][col1] - (sums[row1][col2] + sums[row2][col1]) + sums[row2][col2];
                        if (size > res && size <= k) {
                            res = size;
                        }
                    }
                }
            }
        }

        return res;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {//By  https://discuss.leetcode.com/topic/48854/java-binary-search-solution-time-complexity-min-m-n-2-max-m-n-log-max-m-n/2
        int row = matrix.length;
        if(row==0)return 0;
        int col = matrix[0].length;
        int m = Math.min(row,col);
        int n = Math.max(row,col);
        //indicating sum up in every row or every column
        boolean colIsBig = col>row;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<m;i++){
            int[] array = new int[n];
            // sum from row j to row i
            for(int j = i;j>=0;j--){
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                //traverse every column/row and sum up
                for(int l = 0;l<n;l++){
                    array[l]=array[l]+(colIsBig?matrix[j][l]:matrix[l][j]);
                    val = val + array[l];
                    //use  TreeMap to binary search previous sum to get possible result
                    Integer subres = set.ceiling(val-k);//ceiling(E e) 方法用来返回在此设定为大于或等于给定的元素的最小元素，或null，如果不存在这样的元素。
                    if(null!=subres){
                        res=Math.max(res,val-subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}
