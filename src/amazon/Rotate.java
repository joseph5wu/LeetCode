package amazon;

import java.util.Arrays;

public class Rotate {

    public static int[][] rotate(int[][] matrix, boolean clockwise) {
        // edge case check

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] newMatrix = new int[columns][rows];

        if(!clockwise) {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    newMatrix[j][rows - 1 - i] = matrix[i][j];
                }
            }
        }
        else {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    newMatrix[columns - 1 - j][i] = matrix[i][j];
                }
            }
        }

        return newMatrix;
    }

    public int[][] solution(int[][] matrix, boolean isClockWise) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        // first clock wise transpose
        int[][] newMatrix = transpose(matrix);
        // then flip to right position
        flip(newMatrix, isClockWise);
        return newMatrix;
    }

    private int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] newMatrix = new int[columns][rows];
        for(int i = 0; i < columns; i++) {
            for(int j = 0; j < rows; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }

        return newMatrix;
    }

    private void flip(int[][] matrix, boolean isClockWise) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int temp = 0;
        if(isClockWise) {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns / 2; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][columns - 1 - j];
                    matrix[i][columns - 1 - j] = temp;
                }
            }
        }
        else {
            for(int i = 0; i < rows / 2; i++) {
                for(int j = 0; j < columns; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[rows - 1 - i][j];
                    matrix[rows - 1 - i][j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11}
        };
        Rotate sol = new Rotate();
        int[][] rotated = sol.solution(matrix, true);
        System.out.println(Arrays.deepToString(rotated));
        rotated = sol.solution(matrix, false);
        System.out.println(Arrays.deepToString(rotated));
    }
}
