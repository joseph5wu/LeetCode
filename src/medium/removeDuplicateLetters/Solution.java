package medium.removeDuplicateLetters;

import java.util.HashMap;
import java.util.Map;

/**
 * The basic idea is to find out the smallest result letter by letter (one letter at a time). Here is the thinking process for input "cbacdcbc":

 find out the last appeared position for each letter; c - 7 b - 6 a - 2 d - 4
 find out the smallest index from the map in step 1 (a - 2);
 the first letter in the final result must be the smallest letter from index 0 to index 2;
 repeat step 2 to 3 to find out remaining letters.
 the smallest letter from index 0 to index 2: a
 the smallest letter from index 3 to index 4: c
 the smallest letter from index 4 to index 4: d
 the smallest letter from index 5 to index 6: b
 so the result is "acdb"
 */
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
