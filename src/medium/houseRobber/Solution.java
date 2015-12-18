package medium.houseRobber;

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int start, int end) {
        if(start > end) {
            return 0;
        }

        int first = 0, second = nums[start];
        int i = start + 1;
        while(i <= end) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
            i++;
        }

        return second;
    }
}
