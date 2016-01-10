package medium.coinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) {
            return 0;
        }
        if(coins == null || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];

        Arrays.sort(coins);
        int min = -1;
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(coin > i) {
                    break;
                }
                if(dp[i - coin] != -1){
                    int minTemp = dp[i - coin] + 1;
                    min = min < 0 ? minTemp : Math.min(min, minTemp);
                }
            }
            dp[i] = min;
            min = -1;
        }

        return dp[amount];
    }

    private int minCount = Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount) {
        if(amount < 1) {
            return 0;
        }
        if(coins == null || coins.length == 0) {
            return -1;
        }

        minCount = Integer.MAX_VALUE;
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return minCount;
    }

    private void dfs(int[] coins, int index, int remain, int count) {
        if(remain == 0) {
            minCount = Math.min(minCount, count);
            return;
        }
        if(index == -1 || remain < 0) {
            return;
        }

        int coin = coins[index];
        // using this coin
        if(remain >= coin) {
            dfs(coins, index, remain - coin, count + 1);
        }
        // not using this coin
        dfs(coins, index - 1, remain, count);
    }

    public static void main(String[] args) {
        int[] coins = new int[]{270, 373, 487, 5, 62};
        Solution sol = new Solution();
        int result = sol.coinChange2(coins, 8121);
        int result1 = sol.coinChange(coins, 8121);
        System.out.println(result);
        System.out.println(result1);
    }
}
