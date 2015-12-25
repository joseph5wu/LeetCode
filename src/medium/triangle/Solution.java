package medium.triangle;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(triangle.size() - 1).size() == 0) {
            return 0;
        }

        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        int i = 0;
        for(int value : triangle.get(triangle.size() - 1)) {
            dp[i++] = value;
        }

        for(i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
