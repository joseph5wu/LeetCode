package medium.containsDuplicate;

import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0 || nums == null || nums.length <= 1) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if((set.floor(value) != null && value <= set.floor(value) + t)
                    || (set.ceiling(value) != null && value >= set.ceiling(value) - t)) {
                return true;
            }
            set.add(value);

            if(i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
