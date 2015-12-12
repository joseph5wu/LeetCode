package medium.addAndSearchWord;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null || word.length() == 0) {
            return;
        }

        Map<Character, TrieNode> next = root.next;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!next.containsKey(c)) {
                next.put(c, new TrieNode(c));
            }
            if(i == word.length() - 1) {
                next.get(c).isLeaf = true;
            }

            next = next.get(c).next;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfsSearch(root.next, word, 0);
    }

    private boolean dfsSearch(Map<Character, TrieNode> next, String word, int steps) {
        if(steps == word.length()) {
            return next.size() == 0;
        }

        char c = word.charAt(steps);
        if(next.containsKey(c)) {
            if(steps == word.length() - 1 && next.get(c).isLeaf) {
                return true;
            }

            return dfsSearch(next.get(c).next, word, steps + 1);
        }
        else if(c == '.') {
            for(Character key : next.keySet()) {
                if(steps == word.length() - 1 && next.get(key).isLeaf) {
                    return true;
                }
                if(dfsSearch(next.get(key).next, word, steps + 1)) {
                    return true;
                }
            }
            return false;
        }
        else {
            return false;
        }
    }
}

class TrieNode{
    char c;
    Map<Character, TrieNode> next = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {

    }

    public TrieNode(char c) {
        this.c = c;
    }
}
