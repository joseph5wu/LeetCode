package medium.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        if(nums == null || nums.length == 0) {
            return result;
        }
        // sort the array using quick sort with O(nlogn)
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++)  {
            int li = i + 1;
            int hi = nums.length - 1;
            while(li < hi) {
                if(nums[i] + nums[li] + nums[hi] < target) {
                    result += hi - li;
                    li++;
                }
                else {
                    hi--;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }

        // sort the array
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            // avoid duplicate. if nums[i] = nums[i - 1], skip it
            if(i == 0 || nums[i] > nums[i - 1]) {
                int li = i + 1;
                int hi = nums.length - 1;
                while(li < hi) {
                    if(nums[i] + nums[li] + nums[hi] == 0) {
                        List<Integer> temp = new ArrayList<>(3);
                        temp.add(nums[i]);
                        temp.add(nums[li]);
                        temp.add(nums[hi]);
                        result.add(temp);
                        hi--;
                        li++;
                        // avoid duplicate.
                        while(li < hi && nums[hi] == nums[hi + 1]) {
                            hi--;
                        }
                        while(li < hi && nums[li] == nums[li - 1]) {
                            li++;
                        }
                    }
                    else if(nums[i] + nums[li] + nums[hi] > 0) {
                        hi--;
                    }
                    else {
                        li++;
                    }
                }
            }
        }

        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        if(nums == null || nums.length < 3) {
            return result;
        }

        // sort the array
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            int li = i + 1;
            int hi = nums.length - 1;
            while(li < hi) {
                int sum = nums[i] + nums[li] + nums[hi];
                if(sum == target) {
                    return sum;
                }

                if(minDiff > Math.abs(target - sum)) {
                    minDiff = Math.abs(target - sum);
                    result = sum;
                }
                if(target < sum) {
                    hi--;
                }
                else {
                    li++;
                }
            }
        }
        return result;
    }
}
