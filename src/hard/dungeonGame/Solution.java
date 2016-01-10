package hard.dungeonGame;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int rows = dungeon.length;
        int columns = dungeon[0].length;
        int[][] dp = new int[rows][columns];
        // from bottom right to top left
        // P.S. if the value is negative means it only needs the least lives which means 1
        dp[rows - 1][columns - 1] = Math.max(1, 1 - dungeon[rows - 1][columns - 1]);

        // deal with left column
        for(int i = rows - 2; i >= 0; i--) {
            dp[i][columns - 1] = Math.max(1, dp[i + 1][columns - 1] - dungeon[i][columns - 1]);
        }
        // deal with bottom row
        for(int i = columns - 2; i >= 0; i--) {
            dp[rows - 1][i] = Math.max(1, dp[rows - 1][i + 1] - dungeon[rows - 1][i]);
        }
        // deal with the rest
        for(int i = rows - 2; i >= 0; i--) {
            for(int j = columns - 2; j >= 0; j--) {
                int right = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                int bottom = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                dp[i][j] = Math.min(right, bottom);
            }
        }

        return dp[0][0];
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int rows = dungeon.length;
        int columns = dungeon[0].length;
        int[] dp = new int[columns + 1];
        for(int i = 0; i <= columns; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[columns - 1] = 1;

        for(int i = rows - 1; i >= 0; i--) {
            for(int j = columns - 1; j >= 0; j--) {
                dp[j] = Math.max(1, Math.min(dp[j], dp[j + 1]) - dungeon[i][j]);
            }
        }

        return dp[0];
    }
}
