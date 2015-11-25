package hard.wordBreak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;

        for(int i = 0; i < s.length(); i++) {
            if(!flags[i]) {
                continue;
            }
            for(String word : wordDict) {
                int wordLen = word.length();
                int end = i + wordLen;
                if(end > s.length()) {
                    continue;
                }
                if(flags[end]) {
                    continue;
                }
                if(s.substring(i, end).equals(word)) {
                    flags[end] = true;
                }
            }
        }

        return flags[s.length()];
    }

    public List<String> wordBreak2(String s, Set<String> wordDict) {
        List<String> results = new LinkedList<>();
        if(s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return results;
        }

        List<String>[] dp = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();

        for(int i = 0; i < s.length(); i++) {
            if(dp[i] == null) {
                continue;
            }
            for(String word : wordDict) {
                int wordLen = word.length();
                int end = i + wordLen;
                if(end > s.length()) {
                    continue;
                }

                if(s.substring(i, end).equals(word)) {
                    if(dp[end] == null) {
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }

        if(dp[s.length()] == null) {
            return results;
        }
        List<String> temp = new ArrayList<>();
        recursive(dp, s.length(), results, temp);
        return results;
    }

    private void recursive(List<String>[] dp, int end, List<String> results, List<String> temp) {
        if(end <= 0) {
            String result = temp.get(temp.size() - 1);
            for(int i = temp.size() - 2; i >= 0; i--) {
                result += (" " + temp.get(i));
            }
            results.add(result);
            return;
        }

        for(String word : dp[end]) {
            temp.add(word);
            recursive(dp, end - word.length(), results, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
