package medium.wiggleSort;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        for(int i = 0; i < nums.length - 1; i++) {
            if(((i % 2 == 0) && nums[i] > nums[i + 1])
                || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }

    public void wiggleSort2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int i1 = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
        int i2 = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            temp[i] = i % 2 == 0 ? nums[i1--] : nums[i2--];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

    }
}
