/**
 * Created by Shaobo on 2015/8/7.
 */
public class Solution {
    public static void main(String[] args){
        int[] nums = {3, 4, -1, 1};
        Solution solution = new Solution();
        int res = solution.firstMissingPositive(nums);
        System.out.println("The first missing positive integer is " + res + ".");
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i){
            if (i+1 == nums[i])
                continue;
            int n = nums[i];
            while (n >= 1 && n <= nums.length && n != nums[n-1]){
                int tmp = n;
                n = nums[n-1];
                nums[tmp-1] = tmp;
            }
        }
        for (int i = 0; i < nums.length; ++i){
            if (i+1 != nums[i])
                return i+1;
        }
        return nums.length + 1;
    }
}
