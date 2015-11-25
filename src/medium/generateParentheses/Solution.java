package medium.generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if(n <= 0) {
            return results;
        }

        dfs(results, "", n, n);
        return results;
    }

    private void dfs(List<String> results, String current, int leftRemain, int rightRemain) {
        if(leftRemain > rightRemain) {
            return;
        }
        if(leftRemain == 0 && rightRemain == 0) {
            results.add(current);
            return;
        }

        if(leftRemain > 0) {
            dfs(results, current + "(", leftRemain - 1, rightRemain);
        }
        if(rightRemain > 0) {
            dfs(results, current + ")", leftRemain, rightRemain - 1);
        }
    }
}
