/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
public class Solution {
    public int candy(int[] ratings) {// 4ms
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (countDown > 0) {
                    total += countDown*(countDown+1)/2; // arithmetic progression
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i-1] ? 1 : prev+1;
                total += prev;
            } else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown*(countDown+1)/2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;
    }

    public int candy(int[] ratings) {// 5ms
        int length = ratings.length;
        if (length <= 1) return length;

        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);

        for (int i = 1; i < length; ++i) {
            if (ratings[i] > ratings[i-1])
                nums[i] = nums[i-1] + 1;
        }

        for (int i = length-1; i > 0; --i) {
            if (ratings[i-1] > ratings[i])
                nums[i-1] = Math.max(nums[i]+1, nums[i-1]);
        }

        int res = 0;
        for (int num : nums) {
            res += num;
        }

        return res;
    }
}
