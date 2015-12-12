package medium.paintHouse;

public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[costs.length + 1][3];
        for(int i = 1; i <= costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
        }

        return Math.min(dp[costs.length][0], Math.min(dp[costs.length][1], dp[costs.length][2]));
    }

    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        int min1 = 0, min2 = 0, min1Id = -1;
        for(int i = 0; i < costs.length; i++) {
            int m1 = Integer.MAX_VALUE, m2 = m1, m1Id = -1;
            for(int j = 0; j < costs[0].length; j++) {
                int cost = (j == min1Id ? min2 : min1) + costs[i][j];
                if(cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    m1Id = j;
                }
                else if(cost < m2) {
                    m2 = cost;
                }
            }
            min1 = m1;
            min1Id = m1Id;
            min2 = m2;
        }

        return min1;
    }
}
