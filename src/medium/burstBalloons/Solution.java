package medium.burstBalloons;

public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] newNums = new int[nums.length + 2];
        for(int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;

        int n = newNums.length;
        // dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；
        // l与r的跨度k从2开始逐渐增大；
        // 三重循环依次枚举范围跨度k，左边界l，中点m；右边界r = l + k；
        int[][] dp = new int[n][n];
        for(int k = 2; k < n; k++) {
            for(int left = 0; left < n - k; left++) {
                int right = left + k;
                for(int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            newNums[left] * newNums[i] * newNums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
