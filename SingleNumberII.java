/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
/**
 * Created by shaobo on 2016/3/29.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0, times = 3;
        for (int i = 0; i < 32; ++i) {
            int mask = 1 << i;
            int cnt = 0;
            for (int num : nums) {
                if ((num&mask) != 0) ++cnt;
            }
            if (cnt%times != 0)
                result |= mask;
        }
        return result;
    }
}
