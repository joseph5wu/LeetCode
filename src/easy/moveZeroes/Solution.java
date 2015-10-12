package easy.moveZeroes;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

     For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

     Note:
     You must do this in-place without making a copy of the array.
     Minimize the total number of operations.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int zeroIndex = 0;
        int nonZeroIndex = 0;
        while(zeroIndex < nums.length && nonZeroIndex < nums.length) {
            // zeroIndex找到第一个zero的index
            while(zeroIndex < nums.length && nums[zeroIndex] != 0) {
                zeroIndex++;
            }
            nonZeroIndex = zeroIndex;
            // 找到zero后面的第一个非0的index
            while(nonZeroIndex < nums.length && nums[nonZeroIndex] == 0) {
                nonZeroIndex++;
            }

            if(zeroIndex < nums.length && nonZeroIndex < nums.length) {
                // 交换两个元素
                nums[zeroIndex] = nums[nonZeroIndex];
                nums[nonZeroIndex] = 0;
            }
            nonZeroIndex++;
            zeroIndex++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution sol = new Solution();
        sol.moveZeroes(nums);
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < nums.length; i++) {
            result.append(nums[i] + " ");
        }
        System.out.println(result.toString());
    }
}
