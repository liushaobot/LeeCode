/**
 * Created by shaobo on 2016/3/29.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum ^= nums[i];
        }

        //int bit = 0;
        //while ((sum&(1<<bit)) == 0) ++bit;
        int bit = (sum&(sum-1)) ^ sum;

        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if ((nums[i]&bit) == 0) {//if ((nums[i]&(1<<bit)) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}
