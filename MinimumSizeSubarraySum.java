/*
Given an array of n positive integers and a positive integer s, find the minimal length of 
a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time 
complexity is O(n log n).
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int fast = 0, slow = 0;
        int current = 0;
        int len = Integer.MAX_VALUE;

         while (fast < nums.length) {
            current += nums[fast];

            while (current >= s) {
                if (len > (fast-slow+1)) {
                    len = fast-slow+1;
                }
                current -= nums[slow];
                ++slow;
            }
            ++fast;
        }
        
        return (len != Integer.MAX_VALUE) ? len : 0;
    }
}