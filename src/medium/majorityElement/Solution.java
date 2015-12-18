package medium.majorityElement;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }

        int[] counts = new int[2];
        int[] majorityElements = new int[2];
        for(int i = 0;i < nums.length; i++) {
            if(majorityElements[0] == nums[i]) {
                counts[0]++;
            }
            else if(majorityElements[1] == nums[i]) {
                counts[1]++;
            }
            else if(counts[0] == 0) {
                majorityElements[0] = nums[i];
                counts[0]++;
            }
            else if(counts[1] == 0) {
                majorityElements[1] = nums[i];
                counts[1]++;
            }
            else {
                counts[0]--;
                counts[1]--;
            }
        }

        // check whether majority elements count reach 1/3
        counts[0] = 0;
        counts[1] = 0;
        for(int num : nums){
            if(num == majorityElements[0]) {
                counts[0]++;
            }
            else if(num == majorityElements[1]) {
                counts[1]++;
            }
        }

        if(counts[0] > (nums.length / 3) && !results.contains(majorityElements[0])) {
            results.add(majorityElements[0]);
        }
        if(counts[1] > (nums.length / 3) && !results.contains(majorityElements[1])) {
            results.add(majorityElements[1]);
        }

        return results;
    }
}
