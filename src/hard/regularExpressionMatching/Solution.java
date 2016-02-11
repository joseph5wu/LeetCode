package hard.regularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null) {
            return true;
        }
        if(s == null || p == null) {
            return false;
        }

        return helper(s, p);
    }

    private boolean helper(String s, String p) {
        if(p.length() == 0) {
            return s.length() == 0;
        }

        // when p[1] is not *
        if(p.length() == 1 || p.charAt(1) != '*') {
            if(s.length() < 1) {
                return false;
            }
            if(p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)) {
                return false;
            }
            return helper(s.substring(1), p.substring(1));
        }
        else {
            // when p[1] is *
            // if * means zero element
            if(helper(s, p.substring(2))) {
                return true;
            }
            while(s.length() != 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                if(helper(s.substring(1), p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return false;
        }
    }
}