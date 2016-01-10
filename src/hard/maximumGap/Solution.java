package hard.maximumGap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        // get the min and max value from nums
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // the minimum possible gap
        int gap = (int)Math.ceil((double)(max - min) / (nums.length - 1));
        if(gap == 0) {
            return 0;
        }
        int[] minBucket = new int[nums.length];
        int[] maxBucket = new int[nums.length];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        // put the numbers into bucket
        for(int i : nums) {
            int pos = (i - min) / gap;
            minBucket[pos] = Math.min(minBucket[pos], i);
            maxBucket[pos] = Math.max(maxBucket[pos], i);
        }

        // scan the bucket for max gap
        int maxGap = 0;
        int previous = min;
        for(int i = 0; i <= nums.length - 1; i++) {
            // empty bucket
            if(minBucket[i] == Integer.MAX_VALUE || maxBucket[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, minBucket[i] - previous);
            previous = maxBucket[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10000000};
        Solution sol = new Solution();
        System.out.println(sol.maximumGap(nums));
    }
}