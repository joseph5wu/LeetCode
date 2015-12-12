package medium.decodeWays;

public class Solution {
    /**
     * The basic idea is using DP to iterate the result. A trick is that we need to set dp[0] to 1 as a dummy element, for the iteration of dp[2].
     dp[i]: The number of the ways for i length string. We can sum the possibilities of 1) one digit or 2) two digits correspondingly.
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= n; i++) {
            if(s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
