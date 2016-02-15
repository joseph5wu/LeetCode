package airbnb.maxSumDiscreteSubArray;

public class Solution {
    public static int maxSubSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp1 = nums[0], dp2 = Math.max(nums[0], nums[1]);
        int max = Integer.MIN_VALUE;
        boolean included = nums[1] > nums[0];
        for(int i = 2; i < nums.length; i++) {
            int temp = dp2;
            if(nums[i] <= 0) {
                // no need to include this nums exception the max is less then current
                if(max < nums[i]) {
                    dp2 = nums[i];
                    included = true;
                }
                else {
                    included = false;
                }
            }
            else {
                if(included) {
                    dp2 = Math.max(dp1 + nums[i], dp2);
                    included = (dp2 == dp1 + nums[i]);
                }
                else {
                    dp2 = Math.max(dp1, dp2) + nums[i];
                    included = true;
                }
            }
            max = Math.max(max, dp2);
            dp1 = temp;
        }

        return max;
    }

    public static void main(String[] args) {
        // int[] nums = {4, 10, 3, 1, 5};
        int[] nums = {4, 9, 6};
        System.out.println(maxSubSum(nums));
    }
}

