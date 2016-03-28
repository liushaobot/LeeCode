/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

/**
 * Created by shaobo on 2016/3/28.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //https://leetcode.com/discuss/91739/my-explanation-for-o-n-solution
        int buy1, sell1, buy2, sell2;

        buy1 = buy2 = Integer.MIN_VALUE;
        sell1 = sell2 = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (buy1 < -prices[i]) buy1 = -prices[i];       // Transaction 1: buy
            if (sell1 < buy1+prices[i]) sell1 = buy1+prices[i]; // Transaction 1: sell
            if (buy2 < sell1-prices[i]) buy2 = sell1-prices[i]; // Transaction 2: buy
            if (sell2 < buy2+prices[i]) sell2 = buy2+prices[i]; // Transaction 2: sell
        }
        return sell2;
    }
}
