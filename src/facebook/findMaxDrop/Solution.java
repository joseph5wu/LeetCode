package facebook.findMaxDrop;

public class Solution {
    public int findMaxDrop(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int drop = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            drop = Math.max(drop, max - num);
        }

        return drop;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 2, 3, 28, -1};
        Solution sol = new Solution();
        System.out.println(sol.findMaxDrop(nums));
    }
}
