package hard.findMissingPossitive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }

        bucketSort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void bucketSort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1) {
                if(nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
