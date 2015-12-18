package medium.reverseWordsInAString;

public class Solution {
    public String reverseWords(String s) {
        if(s == null) {
            return null;
        }

        s = s.trim();
        int length = s.length();
        if(length == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = length - 1, j = i + 1; i >= 0; i--) {
            if(i == 0 ||(s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')) {
                sb.append(s.substring(i, j)).append(" ");
            }
            else if(s.charAt(i) == ' ') {
                j = i;
            }
        }

        return sb.length() > 0 ? sb.deleteCharAt(sb.length() - 1).toString() : "";
    }

    public void reverseWords(char[] s) {
        if(s == null || s.length <= 1) {
            return;
        }

        int start = 0;
        int end = -1;
        int i = start;
        // reverse every word
        while(i < s.length) {
            if(s[i] == ' ' || i == s.length - 1) {
                end = s[i] == ' ' ? i - 1 : i;
                reverse(s, start, end);
                start = i + 1;
            }
            i++;
        }

        // reverse the whole string
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
