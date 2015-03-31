/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
*/
public class Solution {
    public int maxSubArray1(int[] A) {//对于全负数数组要特殊对待
        if (A.length == 0)
            return 0;
        int maxNegative = Integer.MIN_VALUE;
        int max = 0, tmp = 0;
        for (int i = 0; i < A.length; ++i){
            if (A[i] <= 0 && A[i] > maxNegative)
                maxNegative = A[i];
            if (tmp > 0)
                tmp += A[i];
            else
                tmp = A[i];
            if (tmp > max)
                max = tmp;
        }
        return (max != 0) ? max : maxNegative;
    }
    
    public int maxSubArray2(int[] A) {//对于全负数数组也无需特殊对待
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; ++i){
            sum += A[i];
            max = (max < sum) ? sum : max;
            sum = (sum < 0) ? 0 : sum;
        }
        return max;
    }
}
