/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

/**
 * Created by shaobo on 2016/3/28.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null ||
                prices.length <= 1 ||
                k <= 0)
            return 0;

        if (k > prices.length/2) { // the same as Best Time to Buy ans Sell Stock II -- Greedy Algorithm
            int profit = 0;
            for (int i = 1; i < prices.length; ++i) {
                profit += Math.max(prices[i]-prices[i-1], 0);
            }
            return profit;
        } else { //Dynamic Programming
            int[] buy = new int[k];
            int[] sell = new int[k];
            Arrays.fill(buy, Integer.MIN_VALUE);

            for (int price : prices) {//foreach loop
                int tmp = 0;
                for (int j = 0; j < k; ++j) {
                    if (buy[j] < tmp-price) buy[j] = tmp-price;
                    if (sell[j] < buy[j]+price) sell[j] = buy[j] + price;
                    tmp = sell[j];
                }
            }
            return sell[k-1];
        }
    }
}
