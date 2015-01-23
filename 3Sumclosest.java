/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return 
the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
参考Container With Most Water：https://oj.leetcode.com/problems/container-with-most-water/
*/
public class Solution {
    public int threeSumClosest1(int[] num, int target) {
        int minDiff = Integer.MAX_VALUE;
        int sum = target;
        int length = num.length;
        Arrays.sort(num);
        for (int start = 0; start < length-2; ++start){
            int middle = start + 1, end = length - 1;
            int diff;
            while (middle < end){
                diff = num[start] + num[middle] + num[end] - target;
                if (diff < 0){
                    while (middle < end && diff < 0){
                        ++middle;
                        if (-diff < minDiff) {
                            minDiff = -diff;
                            sum = diff + target;
                        }
                        diff = num[start] + num[middle] + num[end] - target;
                    }
                } else if (diff > 0){
                    while (middle < end && diff > 0){
                        --end;
                        if (diff < minDiff) {
                            minDiff = diff;
                            sum = diff + target;
                        }
                        diff = num[start] + num[middle] + num[end] - target;
                    }
                } else
                    return target;
            }
        }
        return sum;
    }
    
    public int threeSumClosest2(int[] num, int target) {
        int minDiff = Integer.MAX_VALUE;
        int sum = target;
        int length = num.length;
        Arrays.sort(num);
        for (int start = 0; start < length-2; ++start){
            int middle = start + 1, end = length - 1;
            int diff;
            while (middle < end){
                diff = num[start] + num[middle] + num[end] - target;
                if (diff < 0){
                    ++middle;
                    if (-diff < minDiff) {
                        minDiff = -diff;
                        sum = diff + target;
                    }
                } else if (diff > 0){
                    --end;
                    if (diff < minDiff) {
                        minDiff = diff;
                        sum = diff + target;
                    }
                } else
                    return target;
            }
        }
        return sum;
    }
}
