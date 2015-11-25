package medium.gameOfLive;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.

 Follow up:
 Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int lbs = getLiveNeighbors(board, i, j);
                if(board[i][j] == 0 && lbs == 3) {
                    board[i][j] = 2;
                }
                if(board[i][j] == 1 && (lbs == 2 || lbs == 3)) {
                    board[i][j] = 3;
                }
            }
        }

        // get the next stages
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int getLiveNeighbors(int[][] board, int i, int j) {
        int lives = 0;
        for(int p = Math.max(0, i - 1); p <= Math.min(board.length - 1, i + 1); p++) {
            for(int q = Math.max(0, j - 1); q <= Math.min(board[0].length - 1, j + 1); q++) {
                lives += board[p][q] & 1;
            }
        }
        // delete itself
        lives -= board[i][j] & 1;
        return lives;
    }
}
