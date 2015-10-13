package easy.isomorphicStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        else if(s == null) {
            return false;
        }
        else if (t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sIndex = new HashMap<>();
        Map<Character, Integer> tIndex = new HashMap<>();
        int length = s.length();
        for(int i = 0; i < length; i++) {
            if(!Objects.equals(sIndex.put(s.charAt(i), i), tIndex.put(t.charAt(i), i))) {
                return false;
            }
        }
        return true;
    }
}
