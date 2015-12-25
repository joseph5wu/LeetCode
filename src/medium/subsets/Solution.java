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

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        // sort the array
        Arrays.sort(nums);
        dfs(nums, 0, results, new ArrayList<>());
        return results;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> results, List<Integer> path) {
        results.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, results, path);
            path.remove(path.size() - 1);
        }
    }
}
