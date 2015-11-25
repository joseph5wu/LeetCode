package easy.palindromePermutation;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }

        Set<Character> charSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charSet.contains(c)) {
                charSet.remove(c);
            }
            else {
                charSet.add(c);
            }
        }

        return charSet.size() == 0 || charSet.size() == 1;
    }
}
