/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums[start] < nums[end])
            return nums[start];

        while (start < end - 1) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[start])
                start = mid;
            else
                end = mid;
        }

        return nums[end];
    }
}
