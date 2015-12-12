package medium.twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> temp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(temp.containsKey(target - nums[i])) {
                int[] results = {temp.get(target - nums[i]) + 1, i + 1};
                return results;
            }
            else {
                temp.put(nums[i], i);
            }
        }

        // can't find current match
        int[] results = {0, 0};
        return results;
    }

    // sorted array
    public int[] twoSum2(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("invalid input");
        }

        int[] results = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int value = numbers[left] + numbers[right];
            if(value == target) {
                results[0] = left + 1;
                results[1] = right + 1;
                return results;
            }
            else if(value < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return results;
    }

    Map<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for(Integer key : map.keySet()) {
            int other = value - key;
            if((key == other && map.get(key) > 1) || (key != other && map.containsKey(other))) {
                return true;
            }
        }

        return false;
    }
}
