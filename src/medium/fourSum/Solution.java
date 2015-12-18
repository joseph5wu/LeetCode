package medium.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4) {
            List<List<Integer>> empty = new ArrayList<>();
            return empty;
        }

        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int index, int target) {
        if(n == 2) {
            return twoSum(nums, index, target);
        }

        List<List<Integer>> results = new ArrayList<>();
        int i = index;
        while(i <= nums.length - n) {
            List<List<Integer>> temp = nSum(nums, n - 1, i + 1, target - nums[i]);
            for(List<Integer> tempList : temp) {
                tempList.add(0, nums[i]);
            }
            results.addAll(temp);
            i++;
            // avoid duplication
            while(i <= nums.length - n && nums[i - 1] == nums[i]) {
                i++;
            }
        }

        return results;
    }

    private List<List<Integer>> twoSum(int[] nums, int index, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int ptr1 = index, ptr2 = nums.length - 1;
        while(ptr1 < ptr2) {
            if(nums[ptr1] + nums[ptr2] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[ptr1]);
                result.add(nums[ptr2]);
                results.add(result);
                ptr1++;
                // avoid duplication
                while(ptr1 < ptr2 && nums[ptr1] == nums[ptr1 - 1]) {
                    ptr1++;
                }
                ptr2--;
                // avoid duplication
                while(ptr1 < ptr2 && nums[ptr2] == nums[ptr2 + 1]) {
                    ptr2--;
                }
            }
            else if(nums[ptr1] + nums[ptr2] < target) {
                ptr1++;
            }
            else {
                ptr2--;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        Solution sol = new Solution();
        System.out.print(sol.fourSum(nums, 0));
    }
}
