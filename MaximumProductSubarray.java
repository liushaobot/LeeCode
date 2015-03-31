/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 
状态Max[i]表示以data[i]结尾的最大连续子串乘积值，Min[i]表示以data[i]结尾的最小连续子串乘积值（考虑到负数的情况）。

状态转移方程：Max[i] = max(data[i], Max[i-1]*data[i], Min[i-1]*data[i]),

              Min[i] =  min(data[i], Max[i-1]*data[i],  Min[i-1]*data[i]).
*/
/**
 * Created by Shaobo on 2015/3/31.
 */
public class Solution {
    public int maxProduct1(int[] A) {
        int max = Integer.MIN_VALUE;
        int maxCurr, maxPrev = 1;
        int minCurr, minPrev = 1;
        for (int i = 0; i < A.length; ++i){
            maxCurr = Math.max(Math.max(A[i], maxPrev*A[i]), minPrev*A[i]);
            minCurr = Math.min(Math.min(A[i], maxPrev*A[i]), minPrev*A[i]);
            max = Math.max(max, maxCurr);
            maxPrev = maxCurr;
            minPrev = minCurr;
        }
        return max;
    }
    
    public int maxProduct2(int[] A) {
        int max = Integer.MIN_VALUE;
        int maxCurr, maxPrev = 1;
        int minCurr, minPrev = 1;
        for (int i = 0; i < A.length; ++i){
            maxCurr = Max(Max(A[i], maxPrev*A[i]), minPrev*A[i]);
            minCurr = Min(Min(A[i], maxPrev*A[i]), minPrev*A[i]);
            max = Math.max(max, maxCurr);
            maxPrev = maxCurr;
            minPrev = minCurr;
        }
        return max;
    }
    private int Max(int a, int b){
        return (a > b) ? a : b;
    }
    private int Min(int a, int b){
        return (a < b) ? a : b;
    }
}
