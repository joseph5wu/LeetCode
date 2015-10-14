package easy.rotateArray;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        k = k % length;
        if(k <= 0) {
            return;
        }

        int[] temp = new int[length];
        int j = 0;
        for(int i = length - k; i < length; i++) {
            temp[j++] = nums[i];
        }
        for(int i = 0; i < length - k; i++) {
            temp[j++] = nums[i];
        }

        for(int i = 0; i < length; i++) {
            nums[i] = temp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int length = nums.length;
        k = k % length;
        if(k <= 0) {
            return;
        }

        reverse(nums, 0, length - k - 1);
        reverse(nums, length - k, length - 1);
        reverse(nums, 0, length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
