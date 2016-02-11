package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }

        // sort the nums array
        Arrays.sort(nums);

        backtracking(nums, 0, new ArrayList<Integer>(), 0, results, target);

        return results;
    }

    private void backtracking(int[] nums, int index, List<Integer> path, int sum,
                              List<List<Integer>> results, int target) {
        for(int i = index; i < nums.length; i++) {
            // skip the replication
            if(i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            if(sum + nums[i] > target) {
                break;
            }
            else if(sum + nums[i] == target) {
                List<Integer> newPath = new ArrayList<Integer>(path);
                newPath.add(nums[i]);
                results.add(newPath);
                break;
            }
            else {
                path.add(nums[i]);
                backtracking(nums, i + 1, path, sum + nums[i], results, target);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, 0, 1, 2};
        Subset sol = new Subset();
        System.out.println(sol.solution(nums, 1));
    }
}
