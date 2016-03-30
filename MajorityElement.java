/*
Given an array of size n, find the majority element. The majority element is the element that 
appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int cnt = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            if (major == nums[i]) {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    major = nums[i];
                    ++cnt;
                }
            }
        }
        
        return major;
    }
}