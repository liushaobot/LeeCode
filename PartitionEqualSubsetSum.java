/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*/

public class Solution {
//zero-one pack
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum&1) != 0) return false;
        boolean[] sums = new boolean[(sum>>1)+1];
        sums[0] = true;
        for (int num : nums) {
            for (int i=sums.length-1; i>=num; --i) {
                if (sums[i-num]) {
                    sums[i] = true;
                }
            }
        }

        return sums[sums.length-1];
    }
}