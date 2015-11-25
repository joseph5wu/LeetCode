package hard.wildcardMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }

        int i = 0;
        int j = 0;
        int starIndex = -1;
        int sIndex = -1;
        while(i < s.length()) {
            if(j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            }
            else if(j < p.length() && (p.charAt(j) == '*')) {
                starIndex = j;
                sIndex = i;
                j++;
            }
            else if(starIndex != -1) {
                j = starIndex + 1;
                i = sIndex + 1;
                sIndex++;
            }
            else {
                return false;
            }
        }

        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}
