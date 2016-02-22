package airbnb.similarWords;

import java.util.*;
public class Solution {
    public static List<String> getSimilarWords(String[] words, String target, int k) {
        // first build word trie-tree
        TrieNode root = new TrieNode();
        for(String word : words) {
            Map<Character, TrieNode> next = root.next;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!next.containsKey(c)) {
                    next.put(c, new TrieNode());
                }
                if(i == word.length() - 1) {
                    next.get(c).isEnd = true;
                }
                else {
                    next = next.get(c).next;
                }
            }
        }

        int[] dp = new int[target.length() + 1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }

        // using dfs to traversal the tree to find valid word
        List<String> results = new ArrayList<>();
        helper(root, target, "", k, dp, results);
        return results;
    }

    private static void helper(TrieNode node, String target, String current, int k, int[] dp, List<String> results) {
        if(node.isEnd) {
            // check whether the diff is less than or equals to k, otherwise stop
            if(dp[target.length()] <= k) {
                results.add(current);
            }
            else {
                return;
            }
        }

        Map<Character, TrieNode> next = node.next;
        for(char c : next.keySet()) {
            int[] newDp = new int[target.length() + 1];
            newDp[0] = current.length() + 1;  // means if target length is 0, how many diff chars
            for(int i = 0; i < target.length(); i++) {
                if(target.charAt(i) == c) {
                    newDp[i + 1] = dp[i];
                }
                else {
                    newDp[i + 1] = Math.min(dp[i], Math.min(dp[i + 1], newDp[i])) + 1;
                }
            }
            helper(next.get(c), target, current + c, k, newDp, results);
        }
    }

    public static void main (String[] args) {
        String[] dic = new String[]{"ab","dfs", "a","fsa"};
        List<String> ret = getSimilarWords(dic, "f", 2);
        for(String str : ret)
            System.out.println(str);
    }
}

class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> next;

    public TrieNode() {
        isEnd = false;
        next = new HashMap<>();
    }
}
