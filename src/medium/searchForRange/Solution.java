package medium.searchForRange;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums == null || nums.length == 0) {
            return result;
        }

        // search for the left one
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if(nums[left] != target) {
            return result;
        }
        result[0] = left;

        // then for the right one
        right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2 + 1; // make mid biased to the right
            if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        result[1] = right;

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,7,7,8,8,9};
        int left = 0, right = array.length - 1;
        int target = 8;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        System.out.print(left + " " + right);
    }
}
