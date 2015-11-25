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
}
