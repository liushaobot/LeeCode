/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

/**
 * Created by shaobo on 2016/3/24.
 */
public class Solution {
    //https://leetcode.com/discuss/87242/java-solution-time-o-n-space-o-1-no-xor-no-gauss-math-method
    public int missingNumber(int[] nums) {//PERFECT
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i] - i;
        return nums.length - sum;
    }
    
    public int missingNumber(int[] nums) {//BY MYSELF
        int len = nums.length;

        if (len == 1){//特例
            return 1-nums[0];
        }

        int ans = -1;

        for (int i = 0; i < len; ++i){
            while (nums[i] != i && nums[i] != len) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < len; ++i) {
            if (nums[i] != i) {
                ans = i;
                break;
            }
        }
       return (ans == -1) ? len : ans;//ans == -1表示输入数组为0到n-1的有序数组
    }
}
