package medium.maximumProductSubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        int[] products = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            result = Math.max(max, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, -2, 4, -2};
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(test));
    }
}
