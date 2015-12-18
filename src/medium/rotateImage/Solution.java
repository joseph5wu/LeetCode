package medium.rotateImage;

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int length = matrix.length;
        for(int i = 0; i < length; i++) {
            for(int j = i; j < length - i; j++) {
                if(length - 1 - i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[length - 1 - j][i];
                    matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                    matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                    matrix[j][length - 1 - i] = temp;
                }
            }
        }
    }
}
