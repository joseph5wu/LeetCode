package medium.findMinimumInRotatedSortedArray;

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            if(nums[start] < nums[end]) {
                return nums[start];
            }

            int mid = start + (end - start) / 2;
            if(nums[start] <= nums[mid]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return nums[start];
    }

    /**
     * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are allowed?
     * @param nums
     * @return
     */
    public int findMinHard(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[end]) {
                end = mid;
            }
            else if(nums[mid] > nums[end]) {
                start = mid + 1;
            }
            else {
                // since duplication allowed, we don't know the min locates in which side, so just reduce end
                // besides, nums[mid] == nums[end], reduce end won't affect the result
                end--;
            }
        }

        return nums[start];
    }
}
