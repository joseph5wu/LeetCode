package medium.missingRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            ranges.add(getRange(lower, upper));
            return ranges;
        }

        if(lower < nums[0]) {
            ranges.add(getRange(lower, nums[0] - 1));
            lower = nums[0];
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - lower >= 2) {
                ranges.add(getRange(lower + 1, nums[i] - 1));
            }
            lower = nums[i];
        }

        if(lower < upper) {
            ranges.add(getRange(lower + 1, upper));
        }

        return ranges;
    }

    private String getRange(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
