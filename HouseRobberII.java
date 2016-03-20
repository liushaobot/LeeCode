/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much 
attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob 
tonight without alerting the police.
*/

/**
 * Created by shaobo on 2016/3/20.
 */
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob(nums, 0, len-1), rob(nums, 1, len));
    }


    public int rob(int[] nums, int from, int to) {
        int[] money = new int[to-from];

        money[0] = nums[from];
        money[1] = Math.max(nums[from], nums[from+1]);

        for (int i = from+2; i < to; ++i) {
            money[i-from] = Math.max(money[i-from-2] + nums[i], money[i-from-1]);
        }

        return money[to-from-1];
    }
    public int rob1(int[] nums, int from, int to) {
        int current = 0;
        int previous1 = 0;
        int previous2 = 0;
        for (int i = from; i < to; ++i) {
            current = Math.max(previous2 + nums[i], previous1);
            previous2 = previous1;
            previous1 = current;
        }

        return current;
    }
}
