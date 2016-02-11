package facebook.findPeakValley;

public class Solution {
    public int find(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        // if the value keeps increasing or decreasing, there is no valley or peak
        if(Math.abs(nums[0] - nums[nums.length - 1]) == nums.length - 1) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == 0 || mid == nums.length - 1) {
                return -1;
            }
            if((nums[mid - 1] - nums[mid]) * (nums[mid + 1] - nums[mid]) > 0) {
                return mid;
            }
            if(Math.abs(nums[mid] - nums[start]) == mid - start) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,3,2};
        int[] nums2 = {};
        int[] nums3 = {1,2,3,4,5,6,7,8,7};
        int[] nums4 = {1,2,3,4,5};
        int[] nums5 = {5,4,3,2,1,2,3};
        int[] nums6 = {9,8,7,6,7};
        Solution sol = new Solution();
        System.out.println(sol.find(nums1));
        System.out.println(sol.find(nums2));
        System.out.println(sol.find(nums3));
        System.out.println(sol.find(nums4));
        System.out.println(sol.find(nums5));
        System.out.println(sol.find(nums6));
    }

}
