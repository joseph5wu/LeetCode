package hard.sudokuSolver;

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        // check column
        for(int row = 0; row < 9; row++) {
            if(board[row][j] == c) {
                return false;
            }
        }

        // check row
        for(int column = 0; column < 9; column++) {
            if(board[i][column] == c) {
                return false;
            }
        }

        // check 3 * 3 block
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for(int column = (j / 3) * 3; column < (j / 3) * 3 + 3; column++) {
                if(board[row][column] == c) {
                    return false;
                }
            }
        }

        return true;
    }
}
