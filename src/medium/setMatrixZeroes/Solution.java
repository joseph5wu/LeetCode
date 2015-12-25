package medium.setMatrixZeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        // mark the first column
        int col0 = 1;
        // using first row/column to mark the whole row/column whether there is 0
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0) {
                col0 = 0;
            }
            for(int j = 1; j < columns; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = rows - 1; i >= 0; i--) {
            for(int j = columns - 1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }

}
