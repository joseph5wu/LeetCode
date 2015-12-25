package medium.longestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {
    /**
     * O(N*N)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * O(N*LogN)  http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        // the minimum value of the last element of the longest increasing sequence whose length is i+1
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int length = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < dp[0]) {
                dp[0] = nums[i];
            }
            else if(nums[i] > dp[length - 1]) {
                dp[length++] = nums[i];
            }
            else {
                int k = Arrays.binarySearch(dp, 0, length, nums[i]);
                if(k < 0) {
                    k = -(k + 1);
                }
                dp[k] = nums[i];
            }
        }

        return length;
    }
}
