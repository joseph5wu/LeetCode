package hard.regularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        if(p.length() == 0) {
            return s.length() == 0;
        }
        // when the second char of p is not * or p length = 1
        if(p.length() == 1 || p.charAt(1) != '*') {
            if(s.length() < 1) {
                return false;
            }
            else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        // when the second char of p is *
        else {
            // when * stand for 0 element
            if(isMatch(s, p.substring(2))) {
                return true;
            }
            int i = 0;
            while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if(isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

//    public boolean isMatch2(String s, String p) {
//
//    }
}
