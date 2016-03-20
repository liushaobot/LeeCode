/*
  Follow up for "Find Minimum in Rotated Sorted Array":
  What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

/**
 * Created by shaobo on 2016/3/19.
 */
public class Solution {
    public int findMin1(int[] nums) { //by me
        int start = 0;
        int end = nums.length - 1;
        
        if (nums[start] < nums[end])
            return nums[start];

        while (start < end - 1) {
            if (nums[start] == nums[end]) {
                while (start < end && nums[start] == nums[start+1])
                    ++start;
                if (start == end)
                    return nums[start];
                while (start < end && nums[end] == nums[end-1])
                    --end;
                if (nums[start] < nums[start+1])
                    ++start;
                else
                    --end;
            }
            while (start < end - 1) {
                int mid = (end - start) / 2 + start;
                if (nums[mid] >= nums[start])
                    start = mid;
                else
                    end = mid;
            }
        }

        return (nums[start] < nums[end]) ? nums[start] : nums[end];
    }
    
    public int findMin2(int[] nums) {//follow other
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[end])
                start = mid + 1;
            else if (nums[mid] < nums[end])
                end = mid;
            else
                --end;
        }

        return nums[end];
    }
}
