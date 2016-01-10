package hard.distantSubSequences;

public class Solution {
    public int numDistinct(String s, String t) {
        if(s == null && t == null) {
            return 1;
        }
        if(s == null || t == null) {
            return 0;
        }

        int[][] dp = new int[t.length() + 1][s.length() + 1];
        // filling the first row with 1
        for(int j = 0; j < s.length() + 1; j++) {
            dp[0][j] = 1;
        }

        // the first column will be 0 by default

        for(int i = 0; i < t.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                }
                else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        return dp[t.length()][s.length()];
    }
}
