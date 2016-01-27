package medium.permutations;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }

        Set<Integer> valid = new HashSet<>();
        for(Integer num : nums) {
            valid.add(num);
        }

        dfs(nums, results, new ArrayList<Integer>(), valid);

        return results;
    }

    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> paths, Set<Integer> valid) {
        if(paths.size() == nums.length) {
            List<Integer> newPaths = new ArrayList<Integer>(paths);
            results.add(newPaths);
            return;
        }

        for(Integer num : nums) {
            if(valid.contains(num)) {
                valid.remove(num);
                paths.add(num);
                dfs(nums, results, paths, valid);
                paths.remove(paths.size() - 1);
                valid.add(num);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, results, new LinkedList<Integer>(), visited);
        return results;
    }

    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> paths, boolean[] visited) {
        if(paths.size() == nums.length) {
            results.add(new LinkedList<>(paths));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i - 1 >= 0 && visited[i - 1] && nums[i - 1] == nums[i])) {
                continue;
            }

            visited[i] = true;
            paths.add(nums[i]);
            dfs(nums, results, paths, visited);
            paths.remove(paths.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        //int[] nums = {1};
        Solution sol = new Solution();
//        List<List<Integer>> results = sol.permute(nums);
//        for(List<Integer> result : results) {
//            for(Integer i : result) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }
        int[] nums = new int[]{1, 1, 2};
        sol.permuteUnique(nums);
    }
}
