package facebook.sortNums;

public class Solution {
    public void sort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int zeroStart = 0, zeroEnd = nums.length - 1;
        int i = 0;
        while(i <= zeroEnd) {
            int num = nums[i];
            if(num < 0) {
                System.out.println("swap " + num + " from " + i + " to " + zeroStart);
                swap(nums, zeroStart++, i++);
            }
            else if(num > 0){
                System.out.println("swap " + num + " from " + i + " to " + zeroEnd);
                swap(nums, zeroEnd--, i);
            }
            else {
                i++;
            }
        }

    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 3, 0, -1, 4, 0, -5};
        Solution sol = new Solution();
        sol.sort(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
