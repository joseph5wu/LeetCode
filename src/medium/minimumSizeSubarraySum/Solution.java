package medium.minimumSizeSubarraySum;

public class Solution {
    /**
     * O(n)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0;
        int sum = 0, min = Integer.MAX_VALUE;
        while(j < nums.length) {
            while(sum < s && j < nums.length) {
                sum += nums[j++];
            }
            if(sum >= s) {
                while(sum >= s && i < j) {
                    sum -= nums[i++];
                }
                min = Math.min(min, j - i + 1);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * O(NLOGN)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i < nums.length + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int min = nums.length + 1;
        for(int i = 0; i < nums.length + 1; i++) {
            int right = searchRightBound(i + 1, nums.length, sums[i] + s, sums);
            if(right == nums.length + 1) {
                break;
            }
            min = Math.min(min, right - i);
        }

        return min == nums.length + 1 ? 0 : min;
    }

    private int searchRightBound(int left, int right, int target, int[] sums) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Solution sol = new Solution();
        int result = sol.minSubArrayLen2(11, nums);
        System.out.println(result);
    }
}
