package medium.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return results;
        }

        // sort candidates
        Arrays.sort(candidates);
        recursive(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void recursive(List<List<Integer>> results, List<Integer> current, int[] candidates, int target, int index) {
        if(target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if(newTarget >= 0) {
                current.add(candidates[i]);
                recursive(results, current, candidates, newTarget, i);
                current.remove(current.size() - 1);
            }
            else{
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return results;
        }

        // sort candidates
        Arrays.sort(candidates);
        recursive2(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void recursive2(List<List<Integer>> results, List<Integer> current, int[] candidates, int target, int index) {
        if(target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int newTarget = target - candidates[i];
            if(newTarget < 0) {
                break;
            }

            current.add(candidates[i]);
            recursive2(results, current, candidates, target - candidates[i], i + 1);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        recursive3(results, new ArrayList<Integer>(), k, n, 1);
        return results;
    }

    private void recursive3(List<List<Integer>> results, List<Integer> current, int k, int n, int index) {
        if(k == 1) {
            if(n < index || n > 9) {
                return;
            }
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(n);
            results.add(newCurrent);
            return;
        }

        for(int i = index; i <= n / k && i <= 9; i++) {
            current.add(i);
            recursive3(results, current, k - 1, n - i, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
