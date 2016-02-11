package facebook.checkSubarraySumEqualsK;

import java.util.*;
public class Solution {
    public boolean check(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                return true;
            }
            if(sumMap.containsKey(sum - k)) {
                return true;
            }
            if(!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{1, -1, 5, -2, 3};
        System.out.println(sol.check(nums, 7));
    }
}
