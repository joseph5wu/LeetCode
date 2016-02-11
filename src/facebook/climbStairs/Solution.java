package facebook.climbStairs;

import java.util.*;
public class Solution {
    public int solution(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n <= 2) {
            return n;
        }

        int dp1 = 1, dp2 = 2;
        for(int i = 3; i <= n; i++) {
            dp2 = dp1 + dp2;
            dp1 = dp2 - dp1;
        }
        return dp2;
    }

    public List<String> climbStairs(int n) {
        List<String> results = new ArrayList<>();
        helper(n, 0, results, new StringBuilder());
        return results;
    }

    private void helper(int n, int steps, List<String> results, StringBuilder path) {
        if(steps == n) {
            results.add(path.substring(0, path.length() - 2));
            return;
        }

        // one step
        if(steps + 1 <= n) {
            StringBuilder one = new StringBuilder(path);
            one.append(1).append("->");
            helper(n, steps + 1, results, one);
        }

        // two steps
        if(steps + 2 <= n) {
            StringBuilder two = new StringBuilder(path);
            two.append(2).append("->");
            helper(n, steps + 2, results, two);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> results = sol.climbStairs(5);
        for(String path : results) {
            System.out.println(path);
        }
        System.out.println("solutions has " + sol.solution(5) + " paths has " + results.size());
    }
}
