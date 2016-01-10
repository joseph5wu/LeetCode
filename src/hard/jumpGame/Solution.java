package hard.jumpGame;

public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        int steps = 0;
        int index = 0;
        int currentMax = 0;
        int nextMax = 0;
        while(currentMax - index + 1 > 0) {
            steps++;
            while(index <= currentMax) {
                nextMax = Math.max(nextMax, nums[index] + index);
                if(nextMax >= nums.length - 1) {
                    return steps;
                }
                index++;
            }
            currentMax = nextMax;
        }

        return 0;
    }
}
