/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the 
stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy 
again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += Math.max(prices[i]-prices[i-1], 0);
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int price = Integer.MAX_VALUE, ans = 0;
        boolean buy = false;//是否已买过股票

        for (int i = 0; i < prices.length-1; ++i) {
            if (prices[i] < prices[i+1] && buy == false) {
                price = prices[i];
                buy = true;
            } else if (prices[i] > prices[i+1] && buy == true) {
                ans += prices[i] - price;
                buy = false;
            }
        }
        if (prices[prices.length-1] > price && buy == true)
            ans += prices[prices.length-1] - price;
        return ans;
    }
}
