package hard.longestSubstringWithAtMostTwoDistinctCharacters;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        char first = s.charAt(0);
        int firstIndex = 0;
        while(firstIndex + 1 < s.length() && s.charAt(firstIndex + 1) == first) {
            firstIndex++;
        }
        if(firstIndex == s.length() - 1) {
            return s.length();
        }

        char second = s.charAt(firstIndex + 1);
        int secondIndex = firstIndex + 1;

        int startIndex = 0;
        int maxLen = secondIndex  + 1;
        for(int i = secondIndex + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != first && c != second) {
                startIndex = Math.min(firstIndex, secondIndex) + 1;
                firstIndex = Math.max(firstIndex, secondIndex);
                first = (firstIndex == secondIndex ? second : first);
                secondIndex = i;
                second = c;
            }
            else {
                if(c == first) {
                    firstIndex = i;
                }
                else{
                    secondIndex = i;
                }
                maxLen = Math.max(maxLen, i - startIndex + 1);
            }
        }
        return maxLen;
    }
}
