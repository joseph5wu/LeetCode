package facebook.houseRobber;

import java.util.*;
public class Solution {
    public List<Integer> rob(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }
        if(nums.length == 1) {
            results.add(nums[0]);
            return results;
        }

        int even = nums[0];
        results.add(0);
        int odd = Math.max(even, nums[1]);
        List<Integer> oddResults = new ArrayList<>();
        oddResults.add(nums[0] > nums[1] ? nums[0] : nums[1]);
        for(int i = 2; i < nums.length; i++) {
            if(i % 2 == 0) {
                if(even + nums[i] > odd) {
                    even += nums[i];
                    results.add(i);
                }
                else {
                    even = odd;
                    results = new ArrayList<>(oddResults);
                }
            }
            else {
                if(odd + nums[i] > even) {
                    odd += nums[i];
                    oddResults.add(i);
                }
                else {
                    odd = even;
                    oddResults = new ArrayList<>(results);
                }
            }
        }

        return even > odd ? results : oddResults;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 3, 5, 2, 4, 18, 7, 8, 9};
        List<Integer> results = sol.rob(nums);
        for(Integer result : results) {
            System.out.print(result + " ");
        }

    }

}
