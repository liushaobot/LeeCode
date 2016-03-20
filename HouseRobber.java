/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint
stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the 
police if two adjacent houses were broken into on the same night.

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

        int[] money = new int[len];

        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; ++i) {
            money[i] = Math.max(nums[i] + money[i-2], money[i-1]);
        }

        return money[len-1];
    }
}
