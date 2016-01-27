package amazon;

import java.util.Arrays;

public class FourInteger {
    public int solution(int a, int b, int c, int d) {
        int[] nums = new int[]{a, b, c, d};
        Arrays.sort(nums);

        swap(nums, 0, 1);
        swap(nums, 2, 3);
        swap(nums, 1, 2);

        return Math.abs(nums[0] - nums[1]) + Math.abs(nums[1] - nums[2]) + Math.abs(nums[2] - nums[3]);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index2];
        nums[index2] = nums[index1];
        nums[index1] = temp;
    }
}
