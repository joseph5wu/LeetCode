package hard.rangeSumQuery;

public class NumMatrix {
    private int[][] matrix;
    private int[][] rowSum;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        this.matrix = matrix;
        rowSum = new int[matrix.length][matrix[0].length];
        rowSum[0][0] = matrix[0][0];
        for(int i = 1; i < matrix.length; i++) {
            rowSum[i][0] = matrix[i][0];
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                rowSum[i][j] = matrix[i][j] + rowSum[i][j - 1];
            }
        }
    }

    public void update(int row, int col, int val) {
        for(int i = col; i < rowSum[0].length; i++) {
            rowSum[row][i] += (val - matrix[row][col]);
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++) {
            sum += rowSum[i][col2];
            if(col1 - 1 >= 0) {
                sum -= rowSum[i][col1 - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMa = new NumMatrix(matrix);
        System.out.println(numMa.sumRegion(2,1,4,3));
        numMa.update(3,2,2);
        System.out.println(numMa.sumRegion(2,1,4,3));
    }
}
