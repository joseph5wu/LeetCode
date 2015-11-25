package medium.findPeakElement;

public class Solution {
    public int findGlobalPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int peak = nums[0];
        int peakIndex = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1] && nums[i] > peak) {
                peak = nums[i];
                peakIndex = i;
            }
        }

        if(nums[nums.length - 1] > peak) {
            return nums.length - 1;
        }
        else {
            return peakIndex;
        }
    }

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return nums[left] > nums[right] ? left : right;



    }
}
