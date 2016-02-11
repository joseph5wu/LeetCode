package facebook.trieNodeSearch;

public class Solution {
    private Node root = new Node();

    public void insert(String word) {
        if(word == null || word.length() == 0) {
            return;
        }

        Node[] children = root.getAllChildren();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children[c - 'a'] == null) {
                children[c - 'a'] = new Node();
            }
            if(i == word.length() - 1) {
                children[c - 'a'].terminal = true;
            }
            children = children[c - 'a'].getAllChildren();
        }
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean searchWithWildcard(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int pos, Node parent) {
        if(pos == word.length()) {
            return parent.isTerminal();
        }

        char c = word.charAt(pos);
        Node[] children = parent.getAllChildren();
        if(c == '*') {
            // it can skip a char
            if(search(word, pos + 1, parent)) {
                return true;
            }

            for(Node child : children) {
                if(child != null && search(word, pos + 1, child)) {
                    return true;
                }
            }

            return false;
        }
        else {
            if(children[c - 'a'] == null) {
                return false;
            }
            return search(word, pos + 1, children[c - 'a']);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.insert("joseph");
        sol.insert("is");
        sol.insert("awesome");
        sol.insert("joe");
        System.out.println(sol.search("joseph"));
        System.out.println(sol.searchWithWildcard("joes"));
    }

}

class Node {
    boolean terminal = false;
    Node[] children = new Node[26];

    Node getChildForLetter(char letter) {
        return children[letter - 'a'];
    }
    Node[] getAllChildren() {
        return children;
    }
    boolean isTerminal() {
        return terminal;
    }
}
