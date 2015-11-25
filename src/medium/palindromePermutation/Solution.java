package medium.palindromePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return results;
        }

        int[] chars = new int[256];
        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        // mark the odd times of one char
        int odd = -1;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] % 2 == 1) {
                if(odd == -1) {
                    odd = i;
                }
                else {
                    return results;
                }
            }
        }

        String palindrome = "";
        if(odd != -1) {
            palindrome += (char) odd;
            chars[odd] -= 1;
        }
        dfs(results, chars, palindrome, s.length());
        return results;
    }

    private void dfs(List<String> results, int[] chars, String palindrome, int n) {
        if(palindrome.length() == n) {
            results.add(palindrome);
        }
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == 0) {
                continue;
            }
            String newPalind = (char) i + palindrome + (char) i;
            chars[i] -= 2;
            dfs(results, chars, newPalind, n);
            chars[i] += 2;
        }
    }
}
