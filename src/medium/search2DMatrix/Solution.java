package medium.search2DMatrix;

public class Solution {
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n =matrix[0].length;
        int i = 0;
        int j = n - 1;
        while(i < m && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] > target) {
                j--;
            }
            else {
                i++;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n =matrix[0].length;
        if(target > matrix[m - 1][n - 1] || target < matrix[0][0]) {
            return false;
        }

        int start = 0;
        int end = m * n - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int midX = mid / n;
            int midY = mid % n;
            if(matrix[midX][midY] == target) {
                return true;
            }
            else if(matrix[midX][midY] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}
