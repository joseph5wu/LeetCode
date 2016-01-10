package hard.wordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null && str == null) {
            return true;
        }
        else if(pattern == null || str == null) {
            return false;
        }

        Map<Character, String> patMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        return isMatch(pattern, 0, str, 0, patMap, wordSet);
    }

    private boolean isMatch(String pattern, int pPos, String word, int wPos, Map<Character, String> patMap, Set<String> wordSet) {
        if(pPos == pattern.length() && wPos == word.length()) {
            return true;
        }
        if(pPos == pattern.length() || wPos == word.length()) {
            return false;
        }

        // get current pattern
        char p = pattern.charAt(pPos);
        if(patMap.containsKey(p)) {
            String match = patMap.get(p);
            if(!word.startsWith(match, wPos)) {
                return false;
            }
            return isMatch(pattern, pPos + 1, word, wPos + match.length(), patMap, wordSet);
        }
        else {
            for(int k = wPos; k < word.length(); k++) {
                String match = word.substring(wPos, k + 1);
                if(wordSet.contains(match)) {
                    continue;
                }
                patMap.put(p, match);
                wordSet.add(match);

                if(isMatch(pattern, pPos + 1, word, k + 1, patMap, wordSet)) {
                    return true;
                }

                patMap.remove(p);
                wordSet.remove(match);
            }
        }

        return false;
    }
}
