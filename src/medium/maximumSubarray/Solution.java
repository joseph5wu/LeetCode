package medium.maximumSubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int max = nums[0];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = Math.max(nums[i], sums[i - 1] + nums[i]);
            max = Math.max(max, sums[i]);
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        return maxArray(nums, 0, nums.length - 1, Integer.MIN_VALUE);
    }

    private int maxArray(int[] nums, int start, int end, int max) {
        if(start > end) {
            return Integer.MIN_VALUE;
        }

        int mid = start + (end - start) / 2;
        int leftMax = maxArray(nums, start, mid - 1, max);
        int rightMax = maxArray(nums, mid + 1, end, max);
        max = Math.max(Math.max(leftMax, rightMax), max);

        int sum = 0;
        leftMax = 0;
        for(int i = mid - 1; i >= start; i--) {
            sum += nums[i];
            if(sum > leftMax) {
                leftMax = sum;
            }
        }
        sum = 0;
        rightMax = 0;
        for(int i = mid + 1; i <= end; i++) {
            sum += nums[i];
            if(sum > rightMax) {
                rightMax = sum;
            }
        }
        max = Math.max(max, nums[mid] + leftMax + rightMax);
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sol.maxSubArray2(test));
    }
}
