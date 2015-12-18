package medium.factorCombinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        if(n <= 3) {
            return results;
        }

        helper(n, -1, new ArrayList<>(), results);
        return results;
    }

    private void helper(int n, int start, List<Integer> current, List<List<Integer>> results){
        if(start != -1) {
            current.add(n);
            results.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
        }

        // to reduce time, just need to loop to sqrt(n)
        int end = (int)Math.sqrt(n);
        for(int i = Math.max(2, start); i <= end; i++) {
            if(n % i == 0) {
                current.add(i);
                helper(n / i, i, current, results);
                current.remove(current.size() - 1);
            }
        }
    }
}
