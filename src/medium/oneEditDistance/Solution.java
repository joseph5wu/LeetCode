package medium.oneEditDistance;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if((s == null || s.length() == 0) && (t == null || t.length() == 0)) {
            return false;
        }
        if(s == null || s.length() == 0) {
            return t.length() == 1;
        }
        if(t == null || t.length() == 0) {
            return s.length() == 1;
        }
        if(Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        int diffCount = 0;
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) != t.charAt(j)) {
                diffCount++;
                if(diffCount > 1) {
                    return false;
                }
                if(s.length() == t.length()) {
                    i++;
                    j++;
                }
                else if(s.length() < t.length()) {
                    j++;
                }
                else {
                    i++;
                }
            }
            else {
                i++;
                j++;
            }
        }
        if(i < s.length() || j < t.length()) {
            diffCount++;
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print(sol.isOneEditDistance("ab", "cb"));
    }
}
