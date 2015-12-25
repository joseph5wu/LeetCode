package medium.jumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        int max = 0;
        for(int i = 0; i <= max && max < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
        }

        return max >= nums.length - 1;
    }
}
