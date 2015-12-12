package medium.sortColors;

public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int i = left;
        while(i <= right) {
            if(nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            }
            else if(nums[i] == 2) {
                swap(nums, right, i);
                right--;
            }
            else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
