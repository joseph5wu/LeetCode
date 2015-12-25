package medium.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(k == n || k == 0) {
            List<Integer> result = new ArrayList<>();
            for(int i = 1; i <= k; i++) {
                result.add(i);
            }
            List<List<Integer>> results = new ArrayList<>();
            results.add(result);
            return results;
        }

        // if n is in result
        List<List<Integer>> results = combine(n - 1, k - 1);
        for(List<Integer> result : results) {
            result.add(n);
        }

        // if n is not in result
        List<List<Integer>> notInResults = combine(n - 1, k);
        for(List<Integer> result : notInResults) {
            results.add(result);
        }

        return results;
    }
}
