package medium.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    final String[] MAP = {"", "", "abc", "edf", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return results;
        }

        dfs(digits.toCharArray(), 0, "", results);
        return results;
    }

    private void dfs(char[] digitsChar, int position, String solution, List<String> results) {
        if(position == digitsChar.length) {
            results.add(solution);
            return;
        }
        int digit = digitsChar[position] - '0';
        for(int i = 0; i < MAP[digit].length(); i++) {
            dfs(digitsChar, position + 1, solution + MAP[digit].charAt(i), results);
        }
    }
}
