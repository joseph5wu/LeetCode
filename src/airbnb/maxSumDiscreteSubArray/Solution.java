package airbnb.maxSumDiscreteSubArray;

public class Solution {

    public static int maxSum(int[] nums) {
        int dp0 = nums[0];
        int dp1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int temp = dp1;
            dp1 = Math.max(nums[i], Math.max(dp1, dp0 + nums[i]));
            dp0 = temp;
        }

        return dp1;
    }

    public static void main(String[] args) {
         int[] nums = {-4, -10, -3, -1, -5};
//        int[] nums = {4, 9, 6};
        System.out.println(maxSum(nums));
    }
}

