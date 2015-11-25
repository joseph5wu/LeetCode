package medium.uniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : (j == 0 ? 0 : dp[j - 1]) + dp[j];
            }
        }

        return dp[n - 1];
    }
}
