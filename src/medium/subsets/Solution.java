package medium.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        if(nums == null || nums.length == 0) {
            return results;
        }

        // sort
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();

            // get all lists from the prev
            for(List<Integer> l : results) {
                List<Integer> newList = new ArrayList<>(l);
                newList.add(nums[i]);
                temp.add(newList);
            }

            results.addAll(temp);
        }

        return results;
    }
}
