package medium.bestTimeToBuyAndSellStock;

public class Solution {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

         Design an algorithm to find the maximum profit.
         You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
         However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }

        return maxProfit;
    }
}
