/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note 
that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] LIS = new int[nums.length+1];
        int maxIndex = 0, current;
        LIS[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            current = binarySearch(LIS, maxIndex, nums[i]);
            if (current == -1){
                continue;
            } else if (current <= maxIndex) {
                LIS[current] = nums[i];
            } else {
                LIS[++maxIndex] = nums[i];
            }
        }

        return maxIndex+1;
    }

    private int binarySearch(int[] arr, int len, int key) {
        int from = 0, to = len, middle;
        while (from <= to) {
            middle = ((to-from)>>1) + from;
            if (arr[middle] < key) {
                from = middle+1;
            } else if (arr[middle] > key) {
                to = middle-1;
            } else {
                return -1;
            }
        }
        return from;
    }
}