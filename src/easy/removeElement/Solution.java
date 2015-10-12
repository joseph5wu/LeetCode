package easy.removeElement;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int index = 0;
        while(index < length) {
            if(nums[index] == val) {
                // 将数组最后一个元素置于当前的位置
                nums[index] = nums[length - 1];
                length--;
            }
            else{
                index++;
            }
        }

        return length;
    }
}
