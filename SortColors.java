/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in
the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/

/**
 * Created by shaobo on 2016/3/27.
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        //red -- 0  white -- 1  blue -- 2
        int red = 0, white = 0, blue = nums.length-1;
        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, red, white);
                ++red;
                ++white;
            } else if (nums[white] == 2) {
                swap(nums, white, blue);
                --blue;
            } else {
                ++white;
            }
        }
    }

    public void swap(int[] nums, int from, int to) {
        if (from == to)
            return;
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
