/*
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

Hint:

There is a simple O(n) solution to this problem.
You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
*/

public class Solution {
    // Dynamic Programming
    public int integerBreak(int n) { //By myself 1ms
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j*2 <= i; ++j) {
                int tmp = (dp[j]>j ? dp[j] : j)*(dp[i-j]>(i-j) ? dp[i-j] : (i-j));
                if (tmp > max)
                    max = tmp;
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public int integerBreak(int n) { // Readable 2ms
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j*2 <= i; ++j) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j)*Math.max(dp[i-j], i-j));
            }
        }
        return dp[n];
    }
    // Math https://discuss.leetcode.com/topic/43055/why-factor-2-or-3-the-math-behind-this-problem
    public int integerBreak(int n) { // 0ms O(n)
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;
        
        return product;
    }

    public int integerBreak(int n) { // O(log(n))
        if(n == 2)
            return 1;
        else if(n == 3)
            return 2;
        else if(n%3 == 0)
            return (int)Math.pow(3, n/3);
        else if(n%3 == 1)
            return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
        else 
            return 2 * (int) Math.pow(3, n/3);
    }
}