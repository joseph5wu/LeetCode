package medium.addAndSearchWord;

public class WordDictionary {
    WordNode root = new WordNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null || word.length() == 0) {
            return;
        }
        addWord(word.toCharArray(), 0, root);
    }

    private void addWord(char[] wordChars, int index, WordNode parent) {
        char c = wordChars[index];
        int pos = c - 'a';
        WordNode child = parent.children[pos];
        if(child == null) {
            child = new WordNode();
            parent.children[pos] = child;
        }
        if(index == wordChars.length - 1) {
            child.isLeaf = true;
            return;
        }
        addWord(wordChars, index + 1, child);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] wordChar, int index, WordNode parent) {
        if(index == wordChar.length) {
            return parent.isLeaf;
        }
        WordNode[] children = parent.children;
        char c = wordChar[index];
        if(c == '.') {
            for(WordNode child : children) {
                if(child != null) {
                    boolean result = search(wordChar, index + 1, child);
                    if(result) {
                        return true;
                    }
                }
            }
            return false;
        }
        else {
            WordNode child = children[c - 'a'];
            if(child == null) {
                return false;
            }
            return search(wordChar, index + 1, child);
        }
    }

    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("a");
        System.out.println(dic.search("a"));
    }
}

class WordNode {
    boolean isLeaf;
    WordNode[] children = new WordNode[26];
}
