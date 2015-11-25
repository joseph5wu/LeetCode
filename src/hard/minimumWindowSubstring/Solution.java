package hard.minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        int count = 0;
        int sLen = s.length(), tLen = t.length();
        int iMin = -1, jMin = -1;
        int i = 0, j = 0;
        Map<Character, Integer> times = new HashMap<>();

        // keep track of the number of char in t
        for(char c : t.toCharArray()) {
            if(times.containsKey(c)) {
                times.put(c, times.get(c) + 1);
            }
            else {
                times.put(c, 1);
            }
        }

        while(j <= sLen) {
            if(count < tLen && j < sLen) {
                char c = s.charAt(j);
                if(times.containsKey(c)) {
                    int cTimes = times.get(c);
                    times.put(c, cTimes - 1);
                    if(cTimes >= 1) {
                        count++;
                    }
                }
                j++;
            }
            else if(count == tLen){
                char c = s.charAt(i);
                if(times.containsKey(c)) {
                    int cTimes = times.get(c);
                    if(cTimes == 0) {
                        count--;
                        if((iMin == -1 && jMin == -1) || (jMin - iMin > j - i)) {
                            iMin = i;
                            jMin = j;
                        }
                    }
                    times.put(c, cTimes + 1);
                }
                i++;
            }
            else {
                break; // count<tLen && j = sLen
            }
        }
        return (iMin >= 0 && jMin >= 0) ? s.substring(iMin, jMin) : "";
    }
}
