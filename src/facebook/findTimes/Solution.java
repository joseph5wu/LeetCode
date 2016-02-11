package facebook.findTimes;

public class Solution {
    public int findTimes(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums[0] > target || nums[nums.length - 1] < target) {
            return 0;
        }

        // using binary search twice to find the first and the last index
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        if(nums[start] != target) {
            return 0;
        }
        int left = start;
        // the second times find the right one
        end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2 + 1;
            if(nums[mid] <= target) {
                start = mid;
            }
            else {
                end = mid - 1;
            }
        }

        return start - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[25];
        for(int i = 0; i < 25; i++) {
            nums[i] = i / 5;
        }

        Solution sol = new Solution();
        for(int i = 0; i < 5; i++) {
            System.out.println(sol.findTimes(nums, i));
        }
    }

}
