package hard.shortestPalindrome;

public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int end = s.length() - 1;
        int i = 0;
        int j = end;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else {
                i = 0;
                end--;
                j = end;
            }
        }

        return new StringBuilder(s.substring(end + 1)).reverse() + s;
    }
}
