package hard.editDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) {
            return 0;
        }
        if(word1 == null) {
            return word2.length();
        }
        if(word2 == null) {
            return word1.length();
        }

        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        for(int i = 1; i <= word1.length(); i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= word2.length(); i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i <= word2.length(); i++) {
            for(int j = 1; j <= word1.length(); j++) {
                if(word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[word2.length()][word1.length()];
    }

    public int minDistance2(String word1, String word2) {
        if(word1 == null && word2 == null) {
            return 0;
        }
        if(word1 == null) {
            return word2.length();
        }
        if(word2 == null) {
            return word1.length();
        }

        int[] dp = new int[word1.length() + 1];
        for(int i = 1; i <= word1.length(); i++) {
            dp[i] = i;
        }

        for(int i = 1; i <= word2.length(); i++) {
            int pre = dp[0];
            dp[0] = i;
            for(int j = 1; j <= word1.length(); j++) {
                int temp = dp[j];
                if(word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    dp[j] = pre;
                }
                else {
                    dp[j] = Math.min(pre, Math.min(dp[j], dp[j - 1])) + 1;
                }
                pre = temp;
            }
        }

        return dp[word1.length()];
    }
}
