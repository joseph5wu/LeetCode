package easy.validAnagram;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

     For example,
     s = "anagram", t = "nagaram", return true.
     s = "rat", t = "car", return false.

     Note:
     You may assume the string contains only lowercase alphabets.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a'] -= 1;
            if(counts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
