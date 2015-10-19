package medium.productOfArrayExceptSelf;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int[] results = new int[nums.length];
        results[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            results[i] *= right;
            right *= nums[i];
        }

        return results;
    }
}
