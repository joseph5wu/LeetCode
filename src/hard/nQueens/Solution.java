package hard.nQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int count = 0;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if(n != 1 && n < 4) {
            return results;
        }
        helper(results, new ArrayList<String>(), 0, n, new boolean[n], new boolean[n * 2],
                new boolean[n * 2]);

        return results;
    }

    private void helper(List<List<String>> results, List<String> board, int row, int n, boolean[] cols, boolean[] d1,
                        boolean[] d2) {
        if(row == n) {
            results.add(new ArrayList<String>(board));
        }

        for(int i = 0; i < n; i++) {
            int id1 = i - row + n;
            int id2 = i + row;
            if(!cols[i] && !d1[id1] && !d2[id2]) {
                char[] r = new char[n];
                Arrays.fill(r, '.');
                r[i] = 'Q';
                board.add(new String(r));

                cols[i] = true;
                d1[id1] = true;
                d2[id2] = true;
                helper(results, board, row + 1, n, cols, d1, d2);
                board.remove(board.size() - 1);
                d2[id2] = false;
                d1[id1] = false;
                cols[i] = false;
            }
        }
    }

    public int totalNQueens(int n) {
        this.count = 0;
        if(n != 1 && n < 4) {
            return this.count;
        }
        helper(0, n, new boolean[n], new boolean[n * 2], new boolean[n * 2]);
        return this.count;
    }

    private void helper(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if(row == n) {
            this.count ++;
        }

        for(int i = 0; i < n; i++) {
            int id1 = i - row + n;
            int id2 = i + row;
            if(!cols[i] && !d1[id1] && !d2[id2]) {
                cols[i] = true;
                d1[id1] = true;
                d2[id2] = true;

                helper(row + 1, n, cols, d1, d2);

                d2[id2] = false;
                d1[id1] = false;
                cols[i] = false;
            }
        }
    }
}
