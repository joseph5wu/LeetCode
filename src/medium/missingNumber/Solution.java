package medium.missingNumber;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int sum = (nums.length + 1) * nums.length / 2;
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}
