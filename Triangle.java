/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size()-1;

        if (height == 0) return triangle.get(0).get(0);

        int[] res = new int[height+1];
        for (int i = 0; i <= height; ++i) {
            res[i] = triangle.get(height).get(i);
        }
        for (int depth = height-1; depth >= 0; --depth) {
            for (int i = 0; i <= depth; ++i) {
                int tmp = triangle.get(depth).get(i);
                res[i] = Math.min(tmp+res[i], tmp+res[i+1]);
            }
        }
        return res[0];
    }
}
