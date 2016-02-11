package easy.implementStrStr;

/**
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }
        if(haystack.length() < needle.length()) {
            return -1;
        }

        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while(j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                if(j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
