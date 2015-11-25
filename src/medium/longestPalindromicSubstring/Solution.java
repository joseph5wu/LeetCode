package medium.longestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        String max = s.substring(0, 1);
        String temp = null;
        for(int i = 0; i < s.length(); i++) {
            if(i > 0 && i < s.length() - 1 && s.charAt(i - 1) == s.charAt(i + 1)) {
                temp = longestPalindrome(s, i - 1, i + 1);
                max = max.length() > temp.length() ? max : temp;
            }
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                temp = longestPalindrome(s, i, i + 1);
                max = max.length() > temp.length() ? max : temp;
            }
        }

        return max;
    }

    private String longestPalindrome(String s, int start, int end) {
        int length = s.length();
        while(start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }
}
