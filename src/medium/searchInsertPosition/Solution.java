package medium.searchInsertPosition;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        while(i < nums.length - 1) {
            if(nums[i] == target) {
                return i;
            }
            else if(nums[i] > target) {
                return i;
            }
            else if(nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
            else {
                i++;
            }
        }

        if(nums[nums.length - 1] >= target) {
            return nums.length - 1;
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums[0] >= target) {
            return 0;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < target && target <= nums[i + 1]) {
                return i + 1;
            }
        }
        return nums.length;
    }

    public int searchInsert3(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if(target == nums[mid]) {
            return mid;
        }
        else if(target < nums[mid]) {
            return start < mid ? searchInsert(nums, target, start, mid - 1) : start;
        }
        else {
            return end > mid ? searchInsert(nums, target, mid + 1, end) : (end + 1);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = {1, 3, 5, 6};
        System.out.print(sol.searchInsert3(test, 2));
    }
}
