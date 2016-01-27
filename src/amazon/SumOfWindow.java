package amazon;

public class SumOfWindow {
    public int[] solution(int[] nums, int size) {
        if(nums == null || nums.length == 0 || nums.length < size) {
            throw new IllegalArgumentException("Invalid input");
        }

        // using array to collect the result
        int[] sums = new int[nums.length - size + 1];
        for(int i = 0; i < size; i++) {
            sums[0] += nums[i];
        }
        for(int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] - nums[i - 1] + nums[i + size -1];
        }

        return sums;
    }
}
