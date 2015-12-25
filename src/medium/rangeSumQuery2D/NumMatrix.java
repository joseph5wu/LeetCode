package medium.rangeSumQuery2D;

public class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        dp = matrix;
        for(int i = 1; i < matrix.length; i++) {
            dp[i][0] += dp[i - 1][0];
        }
        for(int i = 1; i < matrix[0].length; i++) {
            dp[0][i] += dp[0][i - 1];
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                dp[i][j] += (dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rowMin = Math.min(row1, row2);
        int rowMax = Math.max(row1, row2);
        int colMin = Math.min(col1, col2);
        int colMax = Math.max(col1, col2);

        int sum = dp[rowMax][colMax];
        if(rowMin > 0) {
            sum -= dp[rowMin - 1][colMax];
        }
        if(colMin > 0) {
            sum -= dp[rowMax][colMin - 1];
        }
        if(rowMin > 0 && colMin > 0) {
            sum += dp[rowMin - 1][colMin - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix sol = new NumMatrix(matrix);
        System.out.println(sol.sumRegion(2,1,4,3));

    }
}
