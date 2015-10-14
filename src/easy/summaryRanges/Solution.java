package easy.summaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        if(nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }

        int leftIndex = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            // 判断是否为递增
            if(nums[i] + 1 != nums[i + 1]) {
                // 判断left的序号是否为自己,是则记录该点，并且将leftIndex+1
                if(leftIndex == i) {
                    result.add(nums[i] + "");
                    leftIndex++;
                }
                else {
                    result.add(nums[leftIndex] + "->" + nums[i]);
                    leftIndex = i + 1;
                }
            }
        }

        if(leftIndex != nums.length - 1) {
            result.add(nums[leftIndex] + "->" + nums[nums.length - 1]);
        }
        else {
            result.add(nums[leftIndex] + "");
        }

        return result;
    }
}
