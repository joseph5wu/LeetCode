package medium.implementTrie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0) {
            return;
        }
        Map<Character, TrieNode> children = root.children;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode temp = null;
            if(children.containsKey(c)) {
                temp = children.get(c);
            }
            else {
                temp = new TrieNode(c);
                children.put(c, temp);
            }

            children = temp.children;

            // set leaf node
            if(i == word.length() - 1) {
                temp.isLeaf = true;
            }
        }
    }

    private TrieNode searchNode(String word) {
        if(word == null || word.length() == 0) {
            return null;
        }
        Map<Character, TrieNode> children = root.children;
        TrieNode temp = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                temp = children.get(c);
                children = temp.children;
            }
            else {
                return null;
            }
        }

        return temp;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        if(node != null && node.isLeaf) {
            return true;
        }
        else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
}

class TrieNode {
    char c;
    Map<Character, TrieNode> children = null;
    boolean isLeaf;

    public TrieNode() {
        children = new HashMap<>();
    }
    public TrieNode(char c) {
        children = new HashMap<>();
        this.c = c;
    }
}
