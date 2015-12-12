package medium.removeDuplicateLetters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        // find last position of every letter
        Map<Character, Integer> lastPosMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lastPosMap.put(s.charAt(i), i);
        }

        // find min last position
        char[] results = new char[lastPosMap.size()];
        int begin = 0; int end = findMinLastPos(lastPosMap);

        for(int i = 0; i < results.length; i++) {
            // find the smallest letter from begin to end
            char minLetter = 'z' + 1;
            for(int j = begin; j <= end; j++) {
                if(lastPosMap.containsKey(s.charAt(j)) && s.charAt(j) < minLetter) {
                    minLetter = s.charAt(j);
                    begin = j + 1;
                }
            }

            results[i] = minLetter;
            if(i == results.length - 1) {
                break;
            }
            // remove the minLetter from lastPosMap
            lastPosMap.remove(minLetter);
            if(s.charAt(end) == minLetter) {
                end = findMinLastPos(lastPosMap);
            }
        }

        return new String(results);
    }

    private int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if(lastPosMap.isEmpty()) {
            return -1;
        }

        int minLastPos = Integer.MAX_VALUE;
        for(int lastPost : lastPosMap.values()) {
            minLastPos = Math.min(minLastPos, lastPost);
        }

        return minLastPos;
    }
}
