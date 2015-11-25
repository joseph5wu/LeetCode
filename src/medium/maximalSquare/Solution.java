package medium.maximalSquare;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length, column = matrix[0].length;
        int[][] dp = new int[row][column];

        int max = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }
                else if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
