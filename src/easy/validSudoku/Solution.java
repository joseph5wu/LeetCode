package easy.validSudoku;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
//        if(board == null || board.length != 9 || board[0].length != 9) {
//            return false;
//        }
//
//        // 先检查每一行
//        for(int i = 0; i < 9; i++) {
//            boolean[] flags = new boolean[9];
//            for(int j = 0; j < 9; j++) {
//                if(board[i][j] != '.') {
//                    if(flags[(board[i][j] - '1')]) {
//                        return false;
//                    }
//                    flags[(board[i][j] - '1')] = true;
//                }
//            }
//        }
//
//        // 接着检查每一列
//        for(int i = 0; i < 9; i++) {
//            boolean[] flags = new boolean[9];
//            for(int j = 0; j < 9; j++) {
//                if(board[j][i] != '.') {
//                    if(flags[board[j][i] - '1']) {
//                        return false;
//                    }
//                    flags[board[j][i] - '1'] = true;
//                }
//            }
//        }
//
//        // 然后检查每一九宫格
//        for(int block = 0; block < 9; block++){
//            boolean[] flags = new boolean[9];
//            for(int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
//                for(int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
//                    if(board[i][j] != '.') {
//                        if(flags[board[i][j] - '1']) {
//                            return false;
//                        }
//                        flags[board[i][j] - '1'] = true;
//                    }
//                }
//            }
//        }
//
//        return true;

        if(board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        // check every line
        for(int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(flags[board[i][j] - '1']) {
                        return false;
                    }
                    flags[board[i][j] - '1'] = true;
                }

            }
        }

        // check every column
        for(int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    if(flags[board[j][i] - '1']) {
                        return false;
                    }
                    flags[board[j][i] - '1'] = true;
                }
            }
        }

        // check every 9 * 9 grid
        for(int grid = 0; grid < 9; grid++) {
            boolean[] flags = new boolean[9];
            for(int i = grid / 3 * 3; i < grid / 3 * 3 + 3; i++) {
                for(int j = grid % 3 * 3; j < grid % 3 * 3 + 3; j++) {
                    if(board[i][j] != '.') {
                        if(flags[board[i][j] - '1']) {
                            return false;
                        }
                        flags[board[i][j] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {"....5..1.".toCharArray(),".4.3.....".toCharArray(),".....3..1".toCharArray(),
                "8......2.".toCharArray(),"..2.7....".toCharArray(),".15......".toCharArray(),
                ".....2...".toCharArray(),".2.9.....".toCharArray(),"..4......".toCharArray()};
        Solution sol = new Solution();
        System.out.print(sol.isValidSudoku(board));
    }

}
