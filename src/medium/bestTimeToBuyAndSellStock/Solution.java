package medium.bestTimeToBuyAndSellStock;

import java.util.Map;

public class Solution {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE, max = 0;
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }

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

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit. You may complete at most two transactions.

     Note:
     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        // first solve the best from left
        int[] one = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            one[i] = Math.max(one[i - 1], prices[i] - min);
        }

        // second solve the best from right
        int[] two = new int[prices.length];
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            two[i] = Math.max(two[i + 1], max - prices[i]);
        }

        max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            max = Math.max(max, one[i] + two[i]);
        }
        return max;
    }

    public int maxProfitCoolDown(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int doNothing1 = -prices[0];
        int sell1 = 0;
        int doNothing0 = 0;
        int buy0 = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            doNothing1 = Math.max(doNothing1, buy0);
            buy0 = -prices[i] + doNothing0;
            doNothing0 = Math.max(doNothing0, sell1);
            sell1 = prices[i] + doNothing1;
        }

        return Math.max(sell1, doNothing0);
    }

}
