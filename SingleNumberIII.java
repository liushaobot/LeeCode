/**
 * Created by shaobo on 2016/3/29.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        //int bit = 0;
        //while ((sum&(1<<bit)) == 0) ++bit;
        int bit = (sum&(sum-1)) ^ sum;

        int[] result = new int[2];
        for (int num : nums) {
            if ((num&bit) == 0) {//if ((num&(1<<bit)) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
