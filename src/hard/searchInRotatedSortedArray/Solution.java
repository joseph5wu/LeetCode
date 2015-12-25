package hard.searchInRotatedSortedArray;

public class Solution {
    // This solution is just a slightly modified binary search,
    // we dont need to look for where the list got rotated at all...
    // Rotated list should look something like this:
    // [x - y][a - b] where x > b
    // case 1: target < x
    // - cond1: midpoint > x: move left bound to right of midpoint
    // - cond2: midpoint > target: move right bound to left of midpoint
    // - cond3: midpoint < target: move left to right of midpoint
    // case 2: target > x
    // - cond1: opposite of case 1
    // - cond2-3: same (just normal binary search)
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if(midVal == target) {
                return mid;
            }

            if(nums[left] <= midVal) {
                if(nums[left] <= target && target < midVal) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                if(midVal < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
        }

        return -1;
    }

    public boolean search2(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if(midVal == target) {
                return true;
            }
            else if(midVal < nums[left]) {
                if(target > nums[right] || target < midVal) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if(midVal > nums[left]) {
                if(target < nums[left] || target > midVal) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                left++;
            }
        }

        return false;
    }
}
