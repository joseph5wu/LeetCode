package medium.removeDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length <= 2) {
            return nums.length;
        }

        int i = 1, j = 0;
        boolean firstReplicate = false;

        while(i < nums.length) {
            if(nums[i] == nums[j] && firstReplicate) {
                while(i < nums.length && nums[i] == nums[j]) {
                    i++;
                }
                firstReplicate = false;
            }
            else {
                firstReplicate = (nums[i] == nums[j]);
                swap(nums, i, j + 1);
                i++;
                j++;
            }
        }

        return j + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
