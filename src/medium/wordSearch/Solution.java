package medium.wordSearch;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean exist(char[][] board, String word) {
        if(board == null || word == null) {
            return false;
        }
        int rows = board.length;
        int columns = board[0].length;
        int steps = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(board[i][j] == word.charAt(steps)) {
                    board[i][j] = '0';
                    if(dfs(board, word, i, j, steps + 1)) {
                        return true;
                    }
                    board[i][j] = word.charAt(steps);
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int steps) {
        if(steps == word.length()) {
            return true;
        }

        char c = word.charAt(steps);
        int rows = board.length;
        int columns = board[0].length;
        // left
        if(j + 1 < columns && board[i][j + 1] == c) {
            board[i][j + 1] = '0';
            if(dfs(board, word, i, j + 1, steps + 1)) {
                return true;
            }
            board[i][j + 1] = c;
        }
        // right
        if(j - 1 >= 0 && board[i][j - 1] == c) {
            board[i][j - 1] = '0';
            if(dfs(board, word, i, j - 1, steps + 1)) {
                return true;
            }
            board[i][j - 1] = c;
        }
        // down
        if(i + 1 < rows && board[i + 1][j] == c) {
            board[i + 1][j] = '0';
            if(dfs(board, word, i + 1, j, steps + 1)) {
                return true;
            }
            board[i + 1][j] = c;
        }
        // up
        if(i - 1 >= 0 && board[i - 1][j] == c) {
            board[i - 1][j] = '0';
            if(dfs(board, word, i - 1, j, steps + 1)) {
                return true;
            }
            board[i - 1][j] = c;
        }

        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        if(board == null || words == null) {
            return results;
        }

        // build trie
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for(int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if(node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.result = words[i];
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, results);
            }
        }

        return results;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> results) {
        char c = board[i][j];
        // current char in board has been visited
        if(c == '0') {
            return;
        }
        TrieNode node = root.next[c - 'a'];
        // current char in board not in trienode, no need to check
        if(node == null) {
            return;
        }
        if(node.result != null && !results.contains(node.result)) {
            results.add(node.result);
        }
        board[i][j] = '0';

        // right
        if(j + 1 < board[0].length) {
            dfs(board, i, j + 1, node, results);
        }
        // left
        if(j - 1 >= 0) {
            dfs(board, i, j - 1, node, results);
        }
        // down
        if(i + 1 < board.length) {
            dfs(board, i + 1, j, node, results);
        }
        // up
        if(i - 1 >= 0) {
            dfs(board, i - 1, j, node, results);
        }

        board[i][j] = c;
    }
}

class TrieNode {
    public String result;
    public TrieNode[] next = new TrieNode[26];
}

