package easy.removeDuplicatesFromSortedArray;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.

 双指针，一个指针 i 扫描数组，一个指针 end 记录没有重复数字的新数组的尾部。
 (1) A[end]=A[i]，A[i]为重复数字，跳过。
 (2) A[end]!=A[i]，将A[i]放到A[end+1]位置，end++
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }

        int end = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[end]) {
                end++;
                if(end != i) {
                    nums[end] = nums[i];
                }
            }
        }

        return end + 1;
    }
}
