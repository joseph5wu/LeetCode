package medium.sparseMatrixMultiplication;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) {
            return null;
        }

        int rows = A.length;
        int mid = A[0].length;
        int columns = B[0].length;
        int[][] results = new int[rows][columns];
        Map<Integer, Map<Integer, Integer>> bMap = new HashMap<>();
        for(int i = 0; i < mid; i++) {
            bMap.put(i, new HashMap<>());
            for(int j = 0; j < columns; j++) {
                if(B[i][j] != 0) {
                    bMap.get(i).put(j, B[i][j]);
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < mid; j++) {
                if(A[i][j] != 0) {
                    for(Integer k : bMap.get(j).keySet()) {
                        results[i][k] += A[i][j] * bMap.get(j).get(k);
                    }
                }
            }
        }

        return results;
    }
}
