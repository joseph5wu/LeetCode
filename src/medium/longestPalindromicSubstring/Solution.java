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

    public String longestPalindrome2(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        int index = 0;
        // mark the longest substring start index and count
        int start = 0;
        int count = 0;
        // mark current substring left/right index
        int left = 0;
        int right = 0;
        while(index < len) {
            // if right half is shorter than the half of count, just break the loop
            if(len - 1 - index < count / 2) {
                break;
            }

            left = index;
            // skip the duplication of current char
            while(index < len - 1 && s.charAt(index) == s.charAt(index + 1)) {
                index++;
            }
            right = index;
            index++;

            while(left > 0 && right < len - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }

            if(count < (right - left + 1)) {
                start = left;
                count = right - left + 1;
            }
        }

        return s.substring(start, start + count);
    }
}
