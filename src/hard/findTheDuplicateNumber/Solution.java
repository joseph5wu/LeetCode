package hard.findTheDuplicateNumber;

public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0, right = nums.length - 1;
        int mid = 0, count = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            count = countLess(nums, mid);
            if(count > mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int countLess(int[] nums, int mid) {
        int count = 0;
        for(int num : nums) {
            if(num <= mid) {
                count++;
            }
        }
        return count;
    }

    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
