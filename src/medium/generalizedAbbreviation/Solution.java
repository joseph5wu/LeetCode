package medium.generalizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> results = new ArrayList<>();
        if(word == null || word.length() == 0) {
            results.add(word);
            return results;
        }

        backtracking(results, word, "", 0, 0);
        return results;
    }

    private void backtracking(List<String> results, String word, String cur, int pos, int count) {
        if(pos == word.length()) {
            if(count > 0) {
                cur += String.valueOf(count);
            }
            results.add(cur);
        }
        else {
            // abbreviate it
            backtracking(results, word, cur, pos + 1, count + 1);
            // keep it
            backtracking(results, word, cur + (count > 0 ? count : "") + word.charAt(pos), pos + 1, 0);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> results =  sol.generateAbbreviations("word");
        for(String result : results) {
            System.out.print(result + " ");
        }
    }
}
