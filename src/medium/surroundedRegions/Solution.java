package medium.surroundedRegions;

import commons.models.Point;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        // only need to bfs 4 boards and then set those O connect to the board to 1
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for(int i = 0; i < n; i++) {
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'V' || board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int i = point.x, j = point.y;
            if(board[i][j] == '1' || board[i][j] == 'V') { // using V to mark the node has been visited
                continue;
            }
            if(board[i][j] == 'O') {
                board[i][j] = '1'; // 1 means is the O in the board
                if(i - 1 >= 0) {
                    queue.add(new Point(i - 1, j));
                }
                if(i + 1 < board.length) {
                    queue.add(new Point(i + 1, j));
                }
                if(j - 1 >= 0) {
                    queue.add(new Point(i, j - 1));
                }
                if(j + 1 < board[0].length) {
                    queue.add(new Point(i, j + 1));
                }
            }
            else {
                board[i][j] = 'V';
            }
        }
    }
}
