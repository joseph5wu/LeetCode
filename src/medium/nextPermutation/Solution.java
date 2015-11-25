package medium.nextPermutation;

public class Solution {
    /**
     * step 1: search from right, find the first i that nums[i] < nums[i + 1]

     step 2: search from right, find the first j that nums[i] < nums[j]

     step 3: swap nums[i] with nums[j]

     step 4: reverse nums from i + 1 to the end

     in step1, if not find i that nums[i] < nums[i + 1], just reverse nums from 0 to the end.
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if(i < 0) {
            reverse(nums, 0, nums.length - 1);
        }
        else {
            int j = nums.length - 1;
            while(j > i && nums[j] <= nums[i]) {
                j--;
            }
            if(i != j && nums[i] != nums[j]) {
                swap(nums, i, j);
            }
            reverse(nums, i + 1, nums.length - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int begin, int end) {
        while(begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }
}
