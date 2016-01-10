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

    public String shortestPalindrome2(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }

    private int getCommonLength(String str) {
        StringBuilder sb = new StringBuilder(str);
        String rev = new StringBuilder(str).reverse().toString();
        sb.append("#").append(rev);

        int[] maxLength = new int[sb.length()];
        int index = 0;
        for(int i = 1; i < sb.length(); i++) {
            if(sb.charAt(index) == sb.charAt(i)) {
                maxLength[i] = maxLength[i - 1] + 1;
                index++;
            }
            else {
                index = maxLength[i - 1];
                while(index > 0 && sb.charAt(index) != sb.charAt(i)) {
                    // we will try to shorten the match string length until we revert to beginning of match(index = 1)
                    index = maxLength[index - 1];
                }
                if(sb.charAt(index) == sb.charAt(i)) {
                    index++;
                }
                maxLength[i] = index;
            }
        }
        return maxLength[maxLength.length - 1];
    }

    public static void main(String[] args) {
        String s = "aacecaaa";
        Solution sol = new Solution();
        System.out.println(sol.shortestPalindrome2(s));
    }

    /**
     * for next
     int[] next = new int[sb.length()];
     next[0] = -1;
     int k = -1;
     int j = 0;
     while(j < next.length - 1) {
     if(k == -1 || sb.charAt(j) == sb.charAt(k)) {
     next[++j] = ++k;
     }
     else {
     k = next[k];
     }
     }
     return next[next.length - 1];
     */
}
