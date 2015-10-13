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

        int hayLength = haystack.length();
        int needleLength = needle.length();
        if(needleLength == 0) {
            return 0;
        }
        if(hayLength < needleLength) {
            return -1;
        }

        for(int i = 0; i < hayLength - needleLength + 1; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for(int j = 1; j < needleLength; j++) {
                    if(haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return i;
                }
            }
        }

        return -1;
    }
}
