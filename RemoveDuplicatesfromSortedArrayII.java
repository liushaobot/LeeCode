/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 
2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates1(int[] nums) {
        //define at most k times of duplicate numbers
        final int k = 2;

        //check if it is an empty array
        if(nums.length == 0) return 0;

        //start pointer of new array
        int m = 1;

        // count the time of duplicate numbers occurence
        int count = 1;

        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i - 1]) {
                if(count < k) {
                    nums[m++] = nums[i];
                }
                count++;
            } else {
                count = 1;
                nums[m++] = nums[i];
            }
        }
        return m;
    }
    
    public int removeDuplicates2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;

        int count = 1;
        int duplicate = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i-1]) {
                nums[count] = nums[i];
                ++count;
                duplicate = 0;
            } else if (duplicate == 0) {
                nums[count] = nums[i];
                ++count;
                ++duplicate;
            }
        }
        return count;
    }
}