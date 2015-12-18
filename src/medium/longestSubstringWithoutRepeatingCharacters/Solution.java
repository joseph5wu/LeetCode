package medium.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> marks = new HashSet<>();
        int max = 0, count = 0, i = 0, j = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            count++;
            if(!marks.contains(c)) {
                marks.add(c);
            }
            else{
                // need to delete all chars before the last c
                while(j < s.length() && s.charAt(j) != c) {
                    count--;
                    marks.remove(s.charAt(j));
                    j++;
                }
                // delete last c
                count--;
                j++;
            }
            max = Math.max(max, count);
            i++;
        }

        return max;
    }
}
