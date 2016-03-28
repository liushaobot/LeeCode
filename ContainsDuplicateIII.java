/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] 
and nums[j] is at most t and the difference between i and j is at most k.
*/

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //|i-j| <= k, //|nums[i]-nums[j]| <= t
        if (nums == null || nums.length == 0) return false;
        TreeSet<Long> set = new TreeSet<Long>();
        set.add((long) nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i > k) set.remove((long) nums[i - k - 1]);//去除(i-k)前面的点
            long left = (long) nums[i] - t;
            long right = (long) nums[i] + t;
            if (left <= right && !set.subSet(left, right + 1).isEmpty()) return true;
            set.add((long) nums[i]);
        }
        return false;
    }
}
